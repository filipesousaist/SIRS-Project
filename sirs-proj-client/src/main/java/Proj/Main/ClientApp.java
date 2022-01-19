package Proj.Main;

import Proj.Services.ServerServiceGrpc;
import Proj.Services.ServerServiceGrpc.ServerServiceBlockingStub;
import Proj.Services.ServerServiceOuterClass.RegisterRequest;
import Proj.Services.ServerServiceOuterClass.RegisterResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
		
		// stubs - generate from proto
		
		ServerServiceBlockingStub serverStub = ServerServiceGrpc.newBlockingStub(channel);
		
		RegisterRequest registerRequest = RegisterRequest.newBuilder()
			.setType("SV")
			.setLocation(args[0] + "," + args[1])
			.setId("1")
			.build();
		
		RegisterResponse response = serverStub.register(registerRequest);
		
		System.out.println(response.getResponseMessage());
	}

}
