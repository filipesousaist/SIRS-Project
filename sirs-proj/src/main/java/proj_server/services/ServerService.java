package proj_server.services;

import java.util.List;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
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
	// TODO: falta algumas verificações de input
	@Override
	public void register(RegisterRequest request, StreamObserver<proj_contract.services.ServerResponse> responseObserver) {
		String s = request.getLocation();
		String[] loc = s.split(",");
		int x = Integer.parseInt(loc[0]);
		int y = Integer.parseInt(loc[1]);
		int id = Integer.parseInt(request.getId());
		Entity ent = createEntity(id, new Location(x,y), request.getType(), request.getSpeed());
		
		try {
			_server.addEntity(ent);
			System.out.println("Successfully added " + ent.getType() + " with id " + ent.getID() +
				" to position {x: " + x + ", y: " + y + "}.");
		}
		catch (MapPositionTakenException | MapPositionOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		ServerResponse res = ServerResponse.newBuilder().setResponseMessage("Successfully received").setResponseCode(1).build();		
		responseObserver.onNext(res);
		responseObserver.onCompleted();
		
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
	
	public void setServer(EnvironmentServer server) {
		_server = server;	
	}

	@Override
	public void broadcastLocationClaim(LocationClaim request, StreamObserver<ServerResponse> responseObserver) {
		List<Entity> entities = _server.getCloseEntities(_server.getEntity(Integer.parseInt(request.getProverId())));
		for(Entity ent: entities) {
			if(ent!=null) {
			int port = ent.getID()+9090;
			System.out.println("trying to connect to port : "+port);
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
			ClientServiceBlockingStub clientStub = ClientServiceGrpc.newBlockingStub(channel);
			ClientResponse response = clientStub.receiveLocationClaim(request);
			System.out.println("Resposta: "+response.getResponseMessage());		
			}
		}
		
		super.broadcastLocationClaim(request, responseObserver);
	}

}
