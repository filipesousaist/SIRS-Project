package Proj.Main;

import Proj.Services.ServerServiceGrpc;
import Proj.Services.ServerServiceGrpc.ServerServiceBlockingStub;
import Proj.Services.ServerServiceOuterClass.RegisterRequest;
import Proj.Services.ServerServiceOuterClass.RegisterResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
		
		ServerServiceBlockingStub serverStub = ServerServiceGrpc.newBlockingStub(channel);
		
		RegisterRequest registerRequest = RegisterRequest.newBuilder()
			.setId(args[0])
			.setLocation(args[1] + "," + args[2])
			.setType(args[3])
			.build();
		
		RegisterResponse response = serverStub.register(registerRequest);
		
		System.out.println(response.getResponseMessage());
	}

}
