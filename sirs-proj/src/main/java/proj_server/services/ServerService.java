package proj_server.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proj_contract.proto.Coordinates;
import proj_contract.proto.LocationClaim;
import proj_contract.services.ClientResponse;
import proj_contract.services.ClientServiceGrpc;
import proj_contract.services.ClientServiceGrpc.ClientServiceBlockingStub;
import proj_contract.services.RegisterRequest;
import proj_contract.services.ServerResponse;
import proj_contract.services.ServerServiceGrpc.ServerServiceImplBase;
import proj_server.AuthoritativeRSU;
import proj_server.Entity;
import proj_server.EnvironmentServer;
import proj_server.Location;
import proj_server.NonAuthoritativeRSU;
import proj_server.SmartVehicle;
import proj_server.exception.MapPositionOutOfBoundsException;
import proj_server.exception.MapPositionTakenException;

public class ServerService extends ServerServiceImplBase {
	EnvironmentServer _server;
	Map<Integer, ClientServiceBlockingStub> _clientStubs;
	
	public ServerService(EnvironmentServer server) {
		_server = server;
		_clientStubs = new HashMap<Integer, ClientServiceBlockingStub>();
	}
	
	@Override
	public void register(RegisterRequest request, StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
		Coordinates coords = request.getCoordinates();
		// TODO: falta algumas verificações de input

		int x = coords.getX();
		int y = coords.getY();
		int id = request.getId();
		String type = request.getType();
		Entity ent = createEntity(id, new Location(x, y), type, request.getSpeed());
		
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
	
	private Entity createEntity(int id, Location location, String type, int speed) {
		switch (type) {
			case "SV":
				return new SmartVehicle(id, location, speed);
			case "A-RSU":
				return new AuthoritativeRSU(id, location);
			case "NA-RSU":
				return new NonAuthoritativeRSU(id, location);
			default:
				return null;
		}
	}
	
	private void createChannel(int id) {
		int port = id + 9090;
		System.out.println("Trying to connect to port " + port + "...");
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
		ClientServiceBlockingStub clientStub = ClientServiceGrpc.newBlockingStub(channel);
		_clientStubs.put(id, clientStub);
	}
	
	public void setServer(EnvironmentServer server) {
		_server = server;	
	}

	@Override
	public void broadcastLocationClaim(LocationClaim request, StreamObserver<ServerResponse> responseObserver) {
		List<Entity> entities = _server.getCloseEntities(_server.getEntity(request.getProverId()), 3);
		for (Entity ent: entities) {
			if (ent != null) {
				int port = ent.getID() + 9090;
				System.out.println("Trying to connect to port " + port + "...");
				
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
				ClientServiceBlockingStub clientStub = ClientServiceGrpc.newBlockingStub(channel);
				ClientResponse response = clientStub.receiveLocationClaim(request);
				System.out.println("Answer: " + response.getResponseMessage());		
			}
		}
		
		respondToClient(responseObserver, "Broadcast Location Claim");
	}
	
	private void respondToClient(StreamObserver<ServerResponse> responseObserver, String message) {
		ServerResponse response = ServerResponse.newBuilder()
			.setResponseMessage("Server received \"" + message + "\" successfully.")
			.setResponseCode(0)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
