package proj_client.main;

import java.io.IOException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import proj_client.AuthoritativeRSU;
import proj_client.Client;
import proj_client.NonAuthoritativeRSU;
import proj_client.SmartVehicle;
import proj_client.services.ClientService;
import proj_contract.proto.Location;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.Observation;
import proj_contract.services.RegisterRequest;
import proj_contract.services.ServerResponse;
import proj_contract.services.ServerServiceGrpc;
import proj_contract.services.ServerServiceGrpc.ServerServiceBlockingStub;

public class ClientApp {
	public static void main(String[] args) { //falta verificar argumentos
		Client _client = null;
		String id = args[0];
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		int speed = (args.length > 4) ? Integer.parseInt(args[4]) : 0;
		String type = args[3];
		
		switch (type) {
		case "SV":
			_client = new SmartVehicle(id,x,y,speed);
		case "A-RSU":
			_client = new AuthoritativeRSU(id,x,y);
		case "NA-RSU":
			_client = new NonAuthoritativeRSU(id, x,y);
		
	}
		
		ClientService service = new ClientService();
		service.setClient(_client);
    	int port = Integer.parseInt(args[0]) + 9090;
    	Server server = ServerBuilder.forPort(port).addService(service).build(); 
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		try {
			server.start();
			System.out.println("client services started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			ServerServiceBlockingStub serverStub = ServerServiceGrpc.newBlockingStub(channel);
			register(channel, serverStub, id, x + "," + y, 
				type, speed);
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