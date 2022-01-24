package proj_server.main;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCredentials;
import proj_server.base.EnvironmentServer;
import proj_server.services.ServerService;

public class App {
	ServerCredentials s;
	long timeInMillis = System.currentTimeMillis(); // current time in milliseconds
    public static void main( String[] args ){ // args are the map size
    	EnvironmentServer serverEn = new EnvironmentServer(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    	ServerService service = new ServerService(serverEn);
    	Server server = ServerBuilder.forPort(9090).addService(service).build(); 

       	try {
			server.start();
			System.out.println("Server started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			
			(new Thread(serverEn)).start();
			
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}       
    }
}
