package Proj.Main;

import Proj.Services.ServerServiceGrpc;
import Proj.Services.ServerServiceGrpc.ServerServiceBlockingStub;
import Proj.Services.ServerServiceOuterClass.RegisterRequest;
import Proj.Services.ServerServiceOuterClass.RegisterResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		ServerServiceBlockingStub serverStub = ServerServiceGrpc.newBlockingStub(channel);
		
		register(channel, serverStub, args[0], args[1] + "," + args[2], 
			args[3], (args.length > 4) ? Integer.parseInt(args[4]) : 0);
	}
	
	public static void register(ManagedChannel channel, ServerServiceBlockingStub serverStub,
		String id, String location, String type, int speed) {
		
		RegisterRequest registerRequest = RegisterRequest.newBuilder()
			.setId(id)
			.setLocation(location)
			.setType(type)
			.setSpeed(speed)
			.build();
		
		RegisterResponse response = serverStub.register(registerRequest);
		
		System.out.println(response.getResponseMessage());
	}

}
