package Proj.Services;

import Proj.Services.ServerServiceGrpc.ServerServiceImplBase;
import Proj.Services.ServerServiceOuterClass.RegisterRequest;
import Proj.Services.ServerServiceOuterClass.RegisterResponse;
import Proj.core.AuthoritativeRSU;
import Proj.core.Entity;
import Proj.core.Location;
import Proj.core.NonAuthoritativeRSU;
import Proj.core.SmartVehicle;
import Proj.core.EnvironmentServer;
import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;
import io.grpc.stub.StreamObserver;

public class ServerService extends ServerServiceImplBase {
	EnvironmentServer _server;
	// TODO: falta algumas verificações de input
	@Override
	public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
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

}
