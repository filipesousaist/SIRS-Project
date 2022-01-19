package Proj.Services;
import Proj.Main.*;

import Proj.Services.ServerServiceGrpc.ServerServiceImplBase;
import Proj.Services.ServerServiceOuterClass.RegisterRequest;
import Proj.Services.ServerServiceOuterClass.RegisterResponse;
import Proj.core.Entity;
import Proj.core.Location;
import Proj.core.ServerEnvironment;
import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;
import io.grpc.stub.StreamObserver;

public class ServerService extends ServerServiceImplBase{
	ServerEnvironment _server;
	// TODO: falta algumas verificações de input
	@Override
	public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
		String s = request.getLocation();
		String[] loc = s.split(",");
		int x = Integer.parseInt(loc[0]);
		int y = Integer.parseInt(loc[1]);
		int id = Integer.parseInt(request.getId());
		Entity ent = new Entity(id, new Location(x,y), request.getType());
		
		try {
			_server.addEntity(ent);
			System.out.println("Successfully added " + ent.getType() + " with id " + ent.getID() +
				" to position {x: " + x + ", y: " + y + "}.");
		}
		catch (MapPositionTakenException | MapPositionOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setServer(ServerEnvironment server) {
		_server = server;	
	}

}
