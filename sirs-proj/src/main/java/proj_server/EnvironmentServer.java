package proj_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import proj_contract.proto.EntitiesData;
import proj_contract.proto.EntityData;
import proj_contract.services.ClientResponse;
import proj_contract.services.ClientServiceGrpc.ClientServiceBlockingStub;
import proj_server.exception.MapPositionOutOfBoundsException;
import proj_server.exception.MapPositionTakenException;

public class EnvironmentServer implements Runnable {
	 private Road _road;
	 private List<Entity> _entities;
	 private Map<Integer, ClientServiceBlockingStub> _clientStubs;
	 
	 // receive the map size
	 public EnvironmentServer(int length, int lanes) {
		 _road = new Road(length, lanes + 2);
		 _entities = new ArrayList<Entity>();
	 }
	 
	 public void addEntity(Entity entity) throws MapPositionTakenException, MapPositionOutOfBoundsException {	 
		 _road.addEntity(entity);
		 // entity will only be added to _entities if _map.addEntity does not throw an exception
		 _entities.add(entity);
		 _road.print();
		 _road.draw();
	 }
	 
	 public List<Entity> getEntities() {
		 return _entities;
	 }
	 
	 public Entity getEntity(int id) {
		 for (Entity ent: _entities) {
			 if (ent.getID() == id)
				 return ent;
		 }
		 return null;
	 }
	 public List<Entity> getCloseEntities(Entity ent, int minDistance) {
		 List<Entity> list = new ArrayList<Entity>();
		 Location loc1 = ent.getLocation();
		 int x1 = loc1.getX(), y1 = loc1.getY();
		 
		 for (Entity otherEnt: _entities) {
			 Location loc2 = otherEnt.getLocation();
			 int dx = x1 - loc2.getX(), dy = y1 - loc2.getY();
			 
			 if (dx * dx + dy * dy <= minDistance * minDistance &&
				 otherEnt.getID() != ent.getID()) 
				 list.add(otherEnt);
		 }		 
		 return list;
	 }
	 
	 public void collectDataFromSensors(Entity entity) {
		 int id = entity.getID();
		 EntitiesData data = EntitiesData.newBuilder()
		     .addAllEntityData(new ArrayList<EntityData>()) // TODO: Add close SVs to list
		     .build();
		 ClientResponse response = _clientStubs.get(id).collectDataFromSensors(data);
		 System.out.println(response.getResponseMessage());
	 }
	 
	 @Override
	 public void run() {
		 try {
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 while (true) {
				reader.readLine();
				for (Entity ent: _entities)
					_road.moveEntity(ent, ent.getSpeed());
				_road.print();
				_road.draw();
				for (Entity ent: _entities)
					collectDataFromSensors(ent);
			 } 
		 }
		 catch (IOException e) {
			e.printStackTrace();
		 }
	 }
}
