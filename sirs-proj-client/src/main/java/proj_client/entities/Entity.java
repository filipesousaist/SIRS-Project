package proj_client.entities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import proj_client.base.Location;
import proj_client.services.ClientService;
import proj_contract.proto.EncryptedLocationClaim;
import proj_contract.proto.EncryptedLocationEndorsement;
import proj_contract.proto.EncryptedLocationEndorsementRequest;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.services.ConnectionInfo;
import proj_contract.services.ConnectionInfoResponse;
import proj_contract.services.RegisterRequest;
import proj_contract.services.SecretKeyMessage;
import proj_contract.services.SecretKeyMessageWithId;
import proj_contract.services.ServerResponse;
import proj_contract.services.ServerServiceGrpc;
import proj_contract.services.ServerServiceGrpc.ServerServiceBlockingStub;

public abstract class Entity {
	static final double MAX_DIFFERENCE = 3;
	
	protected int _id;
	protected Location _location;
	protected List<SmartVehicle> _observations;
	protected int _timestep;

	protected ServerServiceBlockingStub _serverStub;
	protected Map<Integer, ClientData> _clientsData;
	
	private PrivateKey _privateKey;
	private Certificate _certificate;
	private Certificate _ca_certificate;

	private Set<String> _typesToConnectTo;
	
	private SecureRandom _secureRandom;

	public class ClientData {
		public boolean isActive;
		public String type;
		public Certificate certificate;
		public SecretKey secretKey;
	}
	
	public class KeyAndSignature2 implements Serializable {
		private static final long serialVersionUID = 5124426518934236147L;
		public byte[] secretKeyBytes;
		public byte[] signatureBytes;
	}

	public Entity(int id, int x, int y, int timestep) {
		_id = id;
		_location = new Location(x, y);	
		_timestep = timestep;
	}

	public List<SmartVehicle> getObservations() {
		return _observations;
	}

	public SmartVehicle getObservation(int id) {
		List<SmartVehicle> svs = _observations.stream().filter(sv -> sv.getId() == id)
				.sorted(Comparator.comparing(SmartVehicle::getTimestep).reversed()).collect(Collectors.toList());
		return svs.size() > 0 ? svs.get(0) : null;
	}
	
	public SmartVehicle getMostSimilarObservation(LocationClaim claim) {
		double minDifference = MAX_DIFFERENCE + Double.MIN_VALUE;
		SmartVehicle mostSimilarObservation = null;
		for (SmartVehicle sv: getObservations()) {
			double difference = getDifference(sv, claim);
			if (difference < minDifference) {
				minDifference = difference;
				mostSimilarObservation = sv;
			}
		}
		return mostSimilarObservation;
	}
	
	public double getDifference(SmartVehicle observation, LocationClaim claim) {
		EntityData claimData = claim.getEntityData();
		if (observation.getId() != claimData.getId())
			return MAX_DIFFERENCE + 1;

		double distance = observation.getLocation().distance(claimData.getCoordinates());
		int deltaTime = Math.abs(observation.getTimestep() - claim.getTimestep());

		return distance + deltaTime;
	}

	public void setLocation(int x, int y) {
		_location.setX(x);
		_location.setY(y);
	}

	public Location getLocation() {
		return _location;
	}

	public int getId() {
		return _id;
	}

	public int getTimestep() {
		return _timestep;
	}

	public int getSpeed() {
		return 0;
	}

	public abstract String getType();
	
	public EntityData toData() {
		return EntityData.newBuilder()
			.setType(getType())
			.setCoordinates(_location.toCoordinates())
			.setId(_id)
			.build();
	}

	protected abstract String[] getTypesToConnectTo();

	@Override
	public String toString() {
		return "<" + getType() + " " + _id + ">: \n" + "  - Timestep: " + _timestep + "\n" + "  - Location: "
				+ _location;
	}
	
	public void setupConnections() {
		_observations = new ArrayList<SmartVehicle>();
		_clientsData = new ConcurrentHashMap<Integer, ClientData>();

		_typesToConnectTo = new HashSet<String>();
		_typesToConnectTo.addAll(Arrays.asList(getTypesToConnectTo()));
		
		setupCertificates();
		
		connectToEnvironmentServer(); // To be able to call RPCs
		
		register(); // Send id, location, type and speed to EnvironmentServer
		
		startClientService(); // Listen to RPCs from EnvironmentServer
	}
	
	private void setupCertificates() {
		_secureRandom = new SecureRandom();
		try {	
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			_certificate = cf.generateCertificate(new FileInputStream("certificates/" + _id + "/cert.pem"));
			Collection<? extends Certificate> certificates = 
				cf.generateCertificates(new FileInputStream("certificates/" + _id + "/chain.pem"));
			for (Certificate cert: certificates) {
				try {
					_certificate.verify(cert.getPublicKey());
					_ca_certificate = cert;
					break;
				} catch (InvalidKeyException e) {
					continue;
				} catch (NoSuchAlgorithmException | NoSuchProviderException | SignatureException e) {
					e.printStackTrace();
					return;
				}
			}
			
			_privateKey = PemUtils.readPrivateKeyFromFile("certificates/" + _id + "/privkey.pem", "RSA");
			
			byte[] data = "test".getBytes("UTF8");
	        byte[] signatureBytes = sign(data);

	        System.out.println(
	        	verifySignature(data, signatureBytes, _certificate.getPublicKey()) ?
	        	"Own signature is correct." :
	        	"Own signature is wrong."
	        );
		} catch (IOException | CertificateException e) {
			e.printStackTrace();
		}
	}
	
	private byte[] sign(byte[] data) {
		Signature sig;
		try {
			sig = Signature.getInstance("SHA1WithRSA");
			sig.initSign(_privateKey);
	        sig.update(data);
	        return sig.sign();
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private boolean verifySignature(byte[] data, byte[] signatureBytes, PublicKey publicKey) {
		try {
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initVerify(publicKey);
	        sig.update(data);
	        return sig.verify(signatureBytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        
	}
	
	private void connectToEnvironmentServer() {
		System.out.println("Trying to connect to port 9090...");
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		_serverStub = ServerServiceGrpc.newBlockingStub(channel);
		System.out.println("Successfully connected to port 9090.");
	}
	
	private void register() {
		RegisterRequest registerRequest = RegisterRequest.newBuilder()
			.setId(_id)
			.setCoordinates(
				_location.toCoordinates()
			)
			.setType(getType())
			.setSpeed(getSpeed())
			.build();
		
		ServerResponse response = _serverStub.register(registerRequest);		
		System.out.println(response.getResponseMessage());
	}
	
	private void startClientService() {
		ClientService service = new ClientService(this);
		Server server = ServerBuilder.forPort(9090 + _id).addService(service).build();
		
		try {
			server.start();
			System.out.println("Client services started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}   
	}

	////////////////////////////////////////
	// Methods to be used by EntityServer //
	////////////////////////////////////////

	public void printConnections() {
		for (int id : _clientsData.keySet()) {
			ClientData data = _clientsData.get(id);
			System.out.println(data.type + " " + id + ": " + (data.isActive ? "Active" : "Inactive"));
		}
	}

	public void printOwnInformation() {
		System.out.println(this);
	}

	public void printObservations() {
		for (SmartVehicle sv : getObservations())
			System.out.println(sv);
	}

	/////////////////////////////////////////
	// Methods to be used by ClientService //
	/////////////////////////////////////////

	public void updateTimestepData(int timestep, int x, int y) {
		_timestep = timestep;
		setLocation(x, y);
	}

	public void collectDataFromSensors(SmartVehicle sv) {
		_observations.add(sv);
		if (getType() == "SV")
			broadcastLocationClaim(sv.getId());
	}

	public synchronized void clearConnections() {
		synchronized (_clientsData) {
			for (int id : _clientsData.keySet()) {
				ClientData data = _clientsData.get(id);
				if (data.isActive)
					data.isActive = false;
				else
					_clientsData.remove(id);
			}
		}
	}

	public void broadcastConnectionInfoRequest() {
		ConnectionInfo connectionInfo = ConnectionInfo.newBuilder()
			.setId(_id)
			.setCertificate(getCertificateAny())
			.setType(getType())
			.build();
		ServerResponse response = _serverStub.broadcastConnectionInfoRequest(connectionInfo);
		System.out.println(response.getResponseMessage());
	}

	public void getConnectionInfo(ConnectionInfo request) {
		if (storeConnectionInfo(request.getId(), request.getCertificate(), request.getType())) {
			ConnectionInfo info = ConnectionInfo.newBuilder()
				.setId(_id)
				.setCertificate(getCertificateAny())
				.setType(getType())
				.build();
			
			ConnectionInfoResponse infoResponse = ConnectionInfoResponse.newBuilder()
				.setConnectionInfo(info)
				.setRequesterId(request.getId())
				.build();
			
			ServerResponse response = _serverStub.sendConnectionInfo(infoResponse);
			System.out.println(response.getResponseMessage());
		}
	}
	
	private boolean verifyCertificate(Certificate certificate) {
		try {
			certificate.verify(_ca_certificate.getPublicKey());
		} catch (InvalidKeyException | CertificateException | NoSuchAlgorithmException | NoSuchProviderException
				| SignatureException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	private Certificate convertAnyToCertificate(Any certificateAny) {
		byte[] certificateByteArray = certificateAny.getValue().toByteArray();
		return (Certificate) convertBytesToObject(certificateByteArray);
	}
	
	private Any getCertificateAny() {
		ByteString certificateByteString = ByteString.copyFrom(convertObjectToBytes(_certificate));
		return Any.newBuilder()
				.setValue(certificateByteString)
				.build();
	}
	
	public static byte[] convertObjectToBytes(Object obj) {
	      ByteArrayOutputStream boas = new ByteArrayOutputStream();
	      try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
	          ois.writeObject(obj);
	          return boas.toByteArray();
	      } catch (IOException ioe) {
	          ioe.printStackTrace();
	      }
	      throw new RuntimeException();
	  }
	
	// Convert byte[] to object
	public static Object convertBytesToObject(byte[] bytes) {
		InputStream is = new ByteArrayInputStream(bytes);
		try (ObjectInputStream ois = new ObjectInputStream(is)) {
			return ois.readObject();
		} catch (IOException | ClassNotFoundException ioe) {
			ioe.printStackTrace();
		}
		throw new RuntimeException();
	}

	public boolean storeConnectionInfo(int id, Any certificateAny, String type) {
		Certificate certificate = convertAnyToCertificate(certificateAny);
		
		if (verifyCertificate(certificate)) {
			synchronized (_clientsData) {
				if (_typesToConnectTo.contains(type)) {			
					boolean clientExists = _clientsData.containsKey(id);
					ClientData clientData = clientExists ? _clientsData.get(id) : new ClientData();
					clientData.isActive = true;
			
					if (!clientExists) {
						clientData.type = type;
						clientData.certificate = certificate;
						_clientsData.put(id, clientData);
					}
				}
			}
			return true;
		}
		return false;
	}
	
	public void sendSecretKey(int id) {
		boolean idExists;
		synchronized(_clientsData) {
			idExists = _clientsData.keySet().contains(id);
		}
		if (!idExists)
			return;
		
		try {		
			SecretKey secretKey = generateKey();		
			synchronized(_clientsData) {
				_clientsData.get(id).secretKey = secretKey;
			}
			
			PublicKey clientPublicKey;
			synchronized(_clientsData) {
				clientPublicKey = _clientsData.get(id).certificate.getPublicKey();
			}
	        byte[] encryptedKeyBytes = encrypt(convertObjectToBytes(secretKey), clientPublicKey);
	        
	        SecretKeyMessage message = SecretKeyMessage.newBuilder()
	        	.setEncryptedKey(ByteString.copyFrom(encryptedKeyBytes))
	        	.setSignature(ByteString.copyFrom(sign(encryptedKeyBytes)))
	        	.build();
	        
	        SecretKeyMessageWithId messageWithId = SecretKeyMessageWithId.newBuilder()
	        	.setSecretKeyMessage(message)
	        	.setReceiverId(id)
	        	.build();
	        ServerResponse response = _serverStub.sendSecretKey(messageWithId);
	        System.out.println(response.getResponseMessage());
	        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public SecretKey generateKey() throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(192, _secureRandom);
	    return keyGenerator.generateKey();
	}
	
	private byte[] encrypt(byte[] data, PublicKey key) {
		return cipher(data, key, Cipher.ENCRYPT_MODE);
	}
	
	private byte[] decrypt(byte[] data, PrivateKey key) {
		return cipher(data, key, Cipher.DECRYPT_MODE);
	}
	
	private byte[] cipher(byte[] data, Key key, int mode) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("RSA");
			cipher.init(mode, key);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
			IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] createInitializationVector()
    {
        byte[] initializationVector = new byte[16];
        _secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }
	
	public static byte[] encrypt(byte[] data, SecretKey secretKey, byte[] initializationVector)
    {
		return cipher(data, secretKey, initializationVector, Cipher.ENCRYPT_MODE);
    }
	
	public static byte[] decrypt(byte[] data, SecretKey secretKey, byte[] initializationVector)
    {
		return cipher(data, secretKey, initializationVector, Cipher.DECRYPT_MODE);
    }
	
	private static byte[] cipher(byte[] data, SecretKey secretKey, byte[] initializationVector, int mode) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			
			IvParameterSpec ivParameterSpec
            = new IvParameterSpec(initializationVector);
 
	        cipher.init(mode, secretKey, ivParameterSpec);
	        
	        return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
			InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			//e.printStackTrace();
			return null;
		}  
	}
	
	public void storeSecretKey(SecretKeyMessage request) {
		byte[] encryptedKeyBytes = request.getEncryptedKey().toByteArray();
		
		Set<Integer> clientIds;
		synchronized (_clientsData) {
			clientIds = _clientsData.keySet();
		}
		
		for (int id: clientIds) {
			ClientData clientData;
			synchronized (_clientsData) {
				clientData = _clientsData.get(id);
			}			
			byte[] keyBytes = decrypt(encryptedKeyBytes, _privateKey);
			if (keyBytes != null) {
				byte[] signatureBytes = request.getSignature().toByteArray();
				if (!verifySignature(encryptedKeyBytes, signatureBytes, clientData.certificate.getPublicKey())) {
					System.out.println(getType() + " " + _id + ": Wrong signature for id " + id + ".");
					return;
				}
				clientData.secretKey = (SecretKey) convertBytesToObject(keyBytes);
				return;
			}
		}
	}

	public void broadcastLocationClaim(int id) {
		System.out.println("This entity cannot perform this operation.");
	}
	
	public void broadcastLocationEndorsementRequest(EncryptedLocationClaim request) {
		System.out.println("This entity cannot perform this operation.");
	}
	
	public void sendLocationEndorsement(EncryptedLocationEndorsementRequest request) {
		System.out.println("This entity cannot perform this operation.");
	}

	public void storeLocationEndorsement(EncryptedLocationEndorsement request) {
		System.out.println("This entity cannot perform this operation.");
	}
}
	
