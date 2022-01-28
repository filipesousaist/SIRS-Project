package proj_client.main;

import proj_client.entities.AuthoritativeRSU;
import proj_client.entities.Entity;
import proj_client.entities.NonAuthoritativeRSU;
import proj_client.entities.SmartVehicle;

public class ClientApp {
	public static void main(String[] args) { //falta verificar argumentos

		int id = Integer.parseInt(args[0]);
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		int speed = (args.length > 4) ? Integer.parseInt(args[4]) : 0;
		String type = args[3];

		Entity entity = createEntity(id, x, y, type, speed);
		
		(new Thread(()->{entity.setupConnections();})).start();
			
		//(new Thread(new EntityServer(entity))).start();
		
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
	
	
}
