package Proj.Services;
import Proj.Main.*;

import Proj.Services.ServerServiceGrpc.ServerServiceImplBase;
import Proj.Services.ServerServiceOuterClass.RegisterRequest;
import Proj.Services.ServerServiceOuterClass.RegisterResponse;
import Proj.core.Entity;
import Proj.core.Location;
import io.grpc.stub.StreamObserver;

public class ServerService extends ServerServiceImplBase{
	Entity _ent;
	Location _loc;
	@Override
	public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
		String s = request.getLocation();
		String[] loc = s.split(",");
		int x = Integer.parseInt(loc[0]);
		int y = Integer.parseInt(loc[1]);
		_loc = new Location(x,y);
		int id = Integer.parseInt(request.getId());
		_ent = new Entity(id,_loc);
		System.out.println("New Entity request received");
		
		
		
	}
	
	public Entity getEntity() {
		return _ent;
	}

}
