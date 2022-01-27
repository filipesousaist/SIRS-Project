package proj_client.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import proj_client.base.Location;
import proj_client.services.ClientService;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.LocationEndorsement;
import proj_contract.proto.LocationEndorsementRequest;
import proj_contract.services.ConnectionInfo;
import proj_contract.services.RegisterRequest;
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

	private Set<String> _typesToConnectTo;

	public class ClientData {
		public boolean isActive;
		public String type;
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
		System.out.println(claim);
		System.out.println(mostSimilarObservation);
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
		
		connectToEnvironmentServer(); // To be able to call RPCs
		
		register(); // Send id, location, type and speed to EnvironmentServer
		
		startClientService(); // Listen to RPCs from EnvironmentServer
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
		ConnectionInfo connectionInfo = ConnectionInfo.newBuilder().setRequesterId(_id).build();
		ServerResponse response = _serverStub.broadcastConnectionInfoRequest(connectionInfo);
		System.out.println(response.getResponseMessage());
	}

	public void getConnectionInfo(ConnectionInfo request) {
		ConnectionInfo info = ConnectionInfo.newBuilder().setId(_id).setPort(9090 + _id)
				.setRequesterId(request.getRequesterId()).setType(getType()).build();
		ServerResponse response = _serverStub.sendConnectionInfo(info);
		System.out.println(response.getResponseMessage());
	}

	public void storeConnectionInfo(int id, int port, String type) {
		synchronized (_clientsData) {
			if (_typesToConnectTo.contains(type)) {			
				boolean clientExists = _clientsData.containsKey(id);
				ClientData clientData = clientExists ? _clientsData.get(id) : new ClientData();
				clientData.isActive = true;
		
				if (!clientExists) {
					clientData.type = type;
					_clientsData.put(id, clientData);
				}
			}
		}
	}

	public void broadcastLocationClaim(int id) {
		System.out.println("This entity cannot perform this operation.");
	}
	
	public void broadcastLocationEndorsementRequest(LocationClaim request) {
		System.out.println("This entity cannot perform this operation.");
	}
	
	public void sendLocationEndorsement(LocationEndorsementRequest request) {
		System.out.println("This entity cannot perform this operation.");
	}

	public void storeLocationEndorsement(LocationEndorsement request) {
		System.out.println("This entity cannot perform this operation.");
	}
}
