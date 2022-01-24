package proj_client.main;

import java.io.IOException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import proj_client.base.EntityServer;
import proj_client.entities.AuthoritativeRSU;
import proj_client.entities.Entity;
import proj_client.entities.NonAuthoritativeRSU;
import proj_client.entities.SmartVehicle;
import proj_client.services.ClientService;
import proj_contract.services.RegisterRequest;
import proj_contract.services.ServerResponse;
import proj_contract.services.ServerServiceGrpc;
import proj_contract.services.ServerServiceGrpc.ServerServiceBlockingStub;

public class ClientApp {
	public static void main(String[] args) { //falta verificar argumentos
		int id = Integer.parseInt(args[0]);
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		int speed = (args.length > 4) ? Integer.parseInt(args[4]) : 0;
		String type = args[3];
		
		Entity entity = createEntity(id, x, y, type, speed);
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		ServerServiceBlockingStub serverStub = ServerServiceGrpc.newBlockingStub(channel);
		
		EntityServer entityServer = new EntityServer(entity, serverStub);
			
		register(entity, serverStub);
		
		(new Thread(entityServer)).start();
		
    	startClientService(entityServer, id);
	}
	
	public static void register(Entity entity, ServerServiceBlockingStub serverStub) {
		RegisterRequest registerRequest = RegisterRequest.newBuilder()
			.setId(entity.getId())
			.setCoordinates(
				entity.getLocation().toCoordinates()
			)
			.setType(entity.getType())
			.setSpeed(entity.getSpeed())
			.build();
		
		ServerResponse response = serverStub.register(registerRequest);		
		System.out.println(response.getResponseMessage());
	}
	
	private static Entity createEntity(int id, int x, int y, String type, int speed) {
		Entity entity;
		switch (type) {
			case "SV":
				entity = new SmartVehicle(id, x, y, 0, speed); break;
			case "A-RSU":
				entity = new AuthoritativeRSU(id, x, y, 0); break;
			case "NA-RSU":
				entity = new NonAuthoritativeRSU(id, x, y, 0); break;
			default:
				entity = null; break;
		}
		return entity;
	}
	
	private static void startClientService(EntityServer entityServer, int id) {
		ClientService service = new ClientService(entityServer);
		Server server = ServerBuilder.forPort(9090 + id).addService(service).build();
		
		try {
			server.start();
			System.out.println("Client services started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}   
	}
}
