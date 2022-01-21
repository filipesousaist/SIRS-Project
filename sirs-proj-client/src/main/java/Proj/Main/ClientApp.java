package Proj.Main;

import java.io.IOException;

import Proj.Proto.Location;
import Proj.Proto.LocationClaim;
import Proj.Proto.Observation;
import Proj.Services.ClientService;
import Proj.Services.RegisterRequest;
import Proj.Services.ServerResponse;
import Proj.Services.ServerServiceGrpc;
import Proj.Services.ServerServiceGrpc.ServerServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ClientApp {
	public static void main(String[] args) {
		ClientService service = new ClientService();
    	int port = Integer.parseInt(args[0])+9090;
    	Server server = ServerBuilder.forPort(port).addService(service).build(); 
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		try {
			server.start();
			System.out.println("client services started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			ServerServiceBlockingStub serverStub = ServerServiceGrpc.newBlockingStub(channel);
			register(channel, serverStub, args[0], args[1] + "," + args[2], 
				args[3], (args.length > 4) ? Integer.parseInt(args[4]) : 0);
			broadcastLocationClaim(channel, serverStub,"1",args[0],1,2,2,"RSU","4");
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}       
		
		
	}
	
	public static void register(ManagedChannel channel, ServerServiceBlockingStub serverStub,
		String id, String location, String type, int speed) {
		
		RegisterRequest registerRequest = RegisterRequest.newBuilder()
			.setId(id)
			.setLocation(location)
			.setType(type)
			.setSpeed(speed)
			.build();
		
		ServerResponse response = serverStub.register(registerRequest);		
		System.out.println(response.getResponseMessage());
	}
	
	public static void broadcastLocationClaim(ManagedChannel channel, ServerServiceBlockingStub serverStub,
			String claimId, String proverId, int x,int y, int time, String type, String id) {
				Location location = Location.newBuilder().setX(x).setY(y).build();
				Observation observation = Observation.newBuilder().setType(type).setId(id).build();
				LocationClaim locationClaim = LocationClaim.newBuilder()				
				.setClaimId(claimId)
				.setLocation(location)
				.setProverId(proverId)
				.setTime(time)
				.setObservation(observation)
				.build();
			
			ServerResponse response = serverStub.broadcastLocationClaim(locationClaim);			
			System.out.println(response.getResponseMessage());
		}
	}
