package proj_client.entities;

import java.util.Set;

import javax.crypto.SecretKey;

import com.google.protobuf.ByteString;

import proj_client.interfaces.IProver;
import proj_client.interfaces.IWitness;
import proj_contract.proto.Coordinates;
import proj_contract.proto.EncryptedLocationClaim;
import proj_contract.proto.EncryptedLocationClaimWithId;
import proj_contract.proto.EncryptedLocationEndorsement;
import proj_contract.proto.EncryptedLocationEndorsementRequest;
import proj_contract.proto.EncryptedLocationEndorsementWithId;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.LocationEndorsement;
import proj_contract.proto.LocationEndorsementRequest;
import proj_contract.services.ServerResponse;

public class SmartVehicle extends Entity implements IProver, IWitness {
	private int _speed;
	private int _claimId;
	
	public SmartVehicle(int id, int x, int y, int timestep, int initialSpeed) {
		super(id, x, y, timestep);
		_speed = initialSpeed;
		_claimId = 0;
	}
	
	public SmartVehicle(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
		_speed = 0;
		_claimId = 0;
	}
	
	@Override
	public int getSpeed() {
		return _speed;
	}
	
	@Override 
	public String getType() {
		return "SV";
	}
	
	@Override
	protected String[] getTypesToConnectTo() {
		return new String[] {"A-RSU"};
	}
	
	@Override
	public String toString() {
		return super.toString() + 
			(_speed > 0 ? ("\n  - Speed: " + _speed) : "");
	}
	
	
	// Send location claim to all nearby A-RSUs
	@Override
	public void broadcastLocationClaim(int observedId) {
		SmartVehicle obs = (observedId == _id) ? this : getObservation(observedId);
		
		if (obs == null) 
			System.out.println("No observations found for entity with id " + observedId + ".");
		else
		{	
			Coordinates coordinates = obs.getLocation().toCoordinates();
			
			EntityData entityData = EntityData.newBuilder()
				.setType(obs.getType())
				.setCoordinates(coordinates)
				.setId(observedId)
				.build();
			
			LocationClaim locationClaim = LocationClaim.newBuilder()				
				.setClaimId(++ _claimId)
				.setProverId(_id)
				.setTimestep(obs.getTimestep())
				.setEntityData(entityData)
				.build();
			
			for (int receiverId: _clientsData.keySet()) {
				byte[] initializationVector = createInitializationVector();
				SecretKey secretKey;
				synchronized (_clientsData) {
					secretKey = _clientsData.get(receiverId).secretKey;
				}
				if (secretKey != null) {	
					EncryptedLocationClaim encryptedLocationClaim = EncryptedLocationClaim.newBuilder()
						.setData(ByteString.copyFrom(encrypt(
							convertObjectToBytes(locationClaim),
							secretKey,
							initializationVector)))
						.setInitializationVector(ByteString.copyFrom(initializationVector))
						.build();
						
					EncryptedLocationClaimWithId encryptedLocationClaimWithId = EncryptedLocationClaimWithId.newBuilder()
						.setEncryptedLocationClaim(encryptedLocationClaim)
						.setReceiverId(receiverId)
						.build();
					ServerResponse response = _serverStub.sendLocationClaim(encryptedLocationClaimWithId);			
					System.out.println(response.getResponseMessage());				
				}
			}
		}	
	}
	
	@Override
	public void broadcastLocationClaims() {
		for (SmartVehicle sv: getObservations()) {
			if (sv.getTimestep() == _timestep)
				broadcastLocationClaim(sv.getId());
		}
	}
	
	@Override
	public void sendLocationEndorsement(EncryptedLocationEndorsementRequest request) {
		Set<Integer> clientIds;
		synchronized(_clientsData) {
			clientIds = _clientsData.keySet();
		}
		for (int senderId: clientIds) {
			ClientData clientData;
			synchronized(_clientsData) {
				clientData = _clientsData.get(senderId);
			}
			if (clientData.secretKey != null) {	
				byte[] locationEndorsementRequestBytes = decrypt(
					request.getData().toByteArray(),
					clientData.secretKey,
					request.getInitializationVector().toByteArray());
				if (locationEndorsementRequestBytes != null) {
					LocationEndorsementRequest locationEndorsementRequest =
						(LocationEndorsementRequest) convertBytesToObject(locationEndorsementRequestBytes);
					LocationEndorsement locationEndorsement = getLocationEndorsement(locationEndorsementRequest);
					if (locationEndorsement != null) {
						byte[] initializationVector = createInitializationVector();
						byte[] encryptedLocationEndorsementBytes = encrypt(
							convertObjectToBytes(locationEndorsement),
							clientData.secretKey,
							initializationVector
							);
						EncryptedLocationEndorsement encryptedLocationEndorsement = EncryptedLocationEndorsement.newBuilder()
							.setData(ByteString.copyFrom(encryptedLocationEndorsementBytes))
							.setInitializationVector(ByteString.copyFrom(initializationVector))
							.build();
						EncryptedLocationEndorsementWithId encryptedLocationEndorsementWithId = EncryptedLocationEndorsementWithId.newBuilder()
							.setEncryptedLocationEndorsement(encryptedLocationEndorsement)
							.setReceiverId(senderId)
							.build();
						ServerResponse response = _serverStub.sendLocationEndorsement(encryptedLocationEndorsementWithId);
						System.out.println(response.getResponseMessage());
						return;
					}	
				}
			}
		}
	}
}
