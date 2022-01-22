package Proj.Services;

import java.util.List;

import Proj.Proto.LocationClaim;
import Proj.Services.ClientServiceGrpc.ClientServiceBlockingStub;
import Proj.Services.ServerServiceGrpc.ServerServiceImplBase;
import Proj.core.AuthoritativeRSU;
import Proj.core.Entity;
import Proj.core.Location;
import Proj.core.NonAuthoritativeRSU;
import Proj.core.SmartVehicle;
import Proj.core.EnvironmentServer;
import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ServerService extends ServerServiceImplBase {
	EnvironmentServer _server;
	// TODO: falta algumas verificações de input
	@Override
	public void register(RegisterRequest request, StreamObserver<ServerResponse> responseObserver) {
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
		ServerResponse res = ServerResponse.newBuilder().setResponseMessage("sucessfully received").setResponseCode(1).build();		
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
