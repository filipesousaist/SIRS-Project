package proj_server.services;

import java.util.List;
import java.util.Map;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proj_contract.proto.Coordinates;
import proj_contract.proto.LocationClaimWithId;
import proj_contract.proto.LocationEndorsementRequestWithId;
import proj_contract.proto.LocationEndorsementWithId;
import proj_contract.services.ClientResponse;
import proj_contract.services.ClientServiceGrpc;
import proj_contract.services.ClientServiceGrpc.ClientServiceBlockingStub;
import proj_contract.services.ConnectionInfo;
import proj_contract.services.RegisterRequest;
import proj_contract.services.ServerResponse;
import proj_contract.services.ServerServiceGrpc.ServerServiceImplBase;
import proj_server.base.Entity;
import proj_server.base.EnvironmentServer;
import proj_server.base.Location;
import proj_server.exception.MapPositionOutOfBoundsException;
import proj_server.exception.MapPositionTakenException;

public class ServerService extends ServerServiceImplBase {
	EnvironmentServer _server;
	Map<Integer, ClientServiceBlockingStub> _clientStubs;
	
	public ServerService(EnvironmentServer server) {
		_server = server;
		_clientStubs = server.getClientStubs();
	}
	
	// ***********************
	// *** Service methods ***
	// ***********************
	
	@Override
	public void register(RegisterRequest request, StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
		Coordinates coords = request.getCoordinates();
		// TODO: falta algumas verificações de input

		int x = coords.getX();
		int y = coords.getY();
		int id = request.getId();
		String type = request.getType();
		Entity ent = new Entity(id, new Location(x, y), type, request.getSpeed());
		
		try {
			_server.addEntity(ent);
			System.out.println("Successfully added " + type + " with id " + id +
				" to position {x: " + x + ", y: " + y + "}.");
		}
		catch (MapPositionTakenException | MapPositionOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		createChannel(id);
		
		respondToClient(responseObserver, "Register");
	}
	
	@Override
	public void broadcastConnectionInfoRequest(ConnectionInfo request, StreamObserver<ServerResponse> responseObserver) {
		List<Entity> entities = _server.getNearbyEntities(_server.getEntity(request.getRequesterId()), 5);
		for (Entity ent: entities) {
			if (ent != null) {
				ClientResponse response = _clientStubs.get(ent.getID()).getConnectionInfo(request);
				System.out.println(response.getResponseMessage());
			}
		}
		
		respondToClient(responseObserver, "Broadcast Connection Info");
	}
	
	@Override
	public void sendConnectionInfo(ConnectionInfo request, StreamObserver<ServerResponse> responseObserver) {
		_clientStubs.get(request.getRequesterId()).sendConnectionInfo(request);
		
		respondToClient(responseObserver, "Send Connection Info");
	}
	
	@Override
	public void sendLocationClaim(LocationClaimWithId request, StreamObserver<ServerResponse> responseObserver) {
		int id = request.getReceiverId();
		if (_clientStubs.containsKey(id)) {
			ClientResponse response = _clientStubs.get(id).sendLocationClaim(request.getLocationClaim());
			System.out.println(response.getResponseMessage());
			respondToClient(responseObserver, "Send Location Claim");
		}
		else
			respondToClientError(responseObserver, "Send Location Claim", 1, "Receiver ID not found.");
	}
	
	@Override
	public void requestLocationEndorsement(LocationEndorsementRequestWithId request, StreamObserver<ServerResponse> responseObserver) {
		int id = request.getReceiverId();
		if (_clientStubs.containsKey(id)) {
			ClientResponse response = _clientStubs.get(id).requestLocationEndorsement(request.getLocationEndorsementRequest());
			System.out.println(response.getResponseMessage());
			respondToClient(responseObserver, "Request Location Endorsement");
		}
		else
			respondToClientError(responseObserver, "Request Location Endorsement", 1, "Requester ID not found.");
	}
	
	@Override
	public void sendLocationEndorsement(LocationEndorsementWithId request, StreamObserver<ServerResponse> responseObserver) {
		int id = request.getReceiverId();
		if (_clientStubs.containsKey(id)) {
			ClientResponse response = _clientStubs.get(id).sendLocationEndorsement(request.getLocationEndorsement());
			System.out.println(response.getResponseMessage());
			respondToClient(responseObserver, "Send Location Endorsement");
		}
		else
			respondToClientError(responseObserver, "Send Location Endorsement", 1, "Receiver ID not found.");
	}
	
	// *************************
	// *** Auxiliary methods ***
	// *************************
	
	private void createChannel(int id) {
		int port = id + 9090;
		System.out.println("Trying to connect to port " + port + "...");
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
		ClientServiceBlockingStub clientStub = ClientServiceGrpc.newBlockingStub(channel);
		_clientStubs.put(id, clientStub);
		
		System.out.println("Successfully connected to port " + port + ".");
	}
	
	private void respondToClient(StreamObserver<ServerResponse> responseObserver, String command) {
		ServerResponse response = ServerResponse.newBuilder()
			.setResponseMessage("Server executed '" + command + "' successfully.")
			.setResponseCode(0)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	private void respondToClientError(StreamObserver<ServerResponse> responseObserver, String command, int errorCode, String errorMessage) {
		ServerResponse response = ServerResponse.newBuilder()
			.setResponseMessage("Server error on " + command + ": " + errorMessage)
			.setResponseCode(errorCode)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
