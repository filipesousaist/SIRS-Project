package Proj.Main;
import java.io.IOException;
import java.util.List;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import Proj.Services.*;
import Proj.core.Entity;
import Proj.core.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class App{

	long timeInMillis = System.currentTimeMillis(); // current time in milliseconds
    public static void main( String[] args ){ // args are the map size
    	ServerEnvironment serverEn = new ServerEnvironment(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    	ServerService service = new ServerService();
    	service.setServer(serverEn);    	   	
    	Server server = ServerBuilder.forPort(9090).addService(service).build(); 

       	try {
			server.start();
			System.out.println("Server started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}       
    }
}
