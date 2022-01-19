package Proj.Main;
import java.io.IOException;
import java.util.List;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import Proj.Services.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class App{
	long timeInMillis = System.currentTimeMillis(); // current time in milliseconds
    public static void main( String[] args ) {
    	ServerService serverService = new ServerService();
    	Server server = ServerBuilder.forPort(9090).addService(serverService).build(); 
       	try {
			server.start();
			System.out.println("Server started at port: " + server.getPort() + " at time: " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
			
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}       
    }
}