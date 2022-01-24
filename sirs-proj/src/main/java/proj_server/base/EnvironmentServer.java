package proj_server.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import proj_contract.proto.EntitiesData;
import proj_contract.proto.EntityData;
import proj_contract.proto.TimestepData;
import proj_contract.services.ClientResponse;
import proj_contract.services.ClientServiceGrpc.ClientServiceBlockingStub;
import proj_server.entities.Entity;
import proj_server.exception.MapPositionOutOfBoundsException;
import proj_server.exception.MapPositionTakenException;

public class EnvironmentServer implements Runnable {
	private Road _road;
	private List<Entity> _entities;
	private Map<Integer, ClientServiceBlockingStub> _clientStubs;
	private int _timestep;
	 
	public EnvironmentServer(int length, int lanes) {
		_road = new Road(length, lanes + 2);
		_entities = new ArrayList<Entity>();
		_clientStubs = new HashMap<Integer, ClientServiceBlockingStub>();
		_timestep = 0;
	}
	 
	public void addEntity(Entity entity) throws MapPositionTakenException, MapPositionOutOfBoundsException {	 
		_road.addEntity(entity);
		// entity will only be added to _entities if _map.addEntity does not throw an exception
		_entities.add(entity);
		_road.display();
	}
 
	public List<Entity> getEntities() {
		return _entities;
	}
	 
	public Entity getEntity(int id) {
		for (Entity ent: _entities)
			if (ent.getID() == id)
				return ent;
		return null;
	}
	
	public List<Entity> getNearbyEntities(Entity ent, int minDistance) {
		List<Entity> list = new ArrayList<Entity>();
		Location loc1 = ent.getLocation();
		int x1 = loc1.getX(), y1 = loc1.getY();
		 
		for (Entity otherEnt: _entities) {
			Location loc2 = otherEnt.getLocation();
			int x2 = loc2.getX(), y2 = loc2.getY();
			int dx = x1 - x2, dy = y1 - y2;
			 
			if (dx * dx + dy * dy <= minDistance * minDistance &&
				otherEnt.getID() != ent.getID()) 
				list.add(otherEnt);
		}		 
		return list;
	}
	
	public Map<Integer, ClientServiceBlockingStub> getClientStubs() {
		return _clientStubs;
	}
	
	public void sendTimestepData(Entity entity) {
		TimestepData data = TimestepData.newBuilder()
			.setCoordinates(entity.getLocation().toCoordinates())
			.setTimestep(_timestep)
			.build();
		ClientResponse response = _clientStubs.get(entity.getID()).updateTimestepData(data);
		System.out.println(response.getResponseMessage());
	}
 
	public void collectDataFromSensors(Entity entity) {
		List<EntityData> nearbyEntities = getNearbyEntities(entity, 2)
			.stream()
			.map(ent -> ent.toData())
			.collect(Collectors.toList());
		EntitiesData data = EntitiesData.newBuilder()
			.addAllEntityData(nearbyEntities)
			.build();
		 
		ClientResponse response = _clientStubs.get(entity.getID()).collectDataFromSensors(data);
		System.out.println(response.getResponseMessage());
	}
 
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				reader.readLine();
				++ _timestep;
				System.out.println("Starting timestep " + _timestep + ".");
				for (Entity ent: _entities)
					_road.moveEntity(ent, ent.getSpeed());
				_road.display();
				for (Entity ent: _entities) {
					sendTimestepData(ent);
					collectDataFromSensors(ent);
				}
			} 
		}
		catch (IOException e) {			
			 e.printStackTrace();
		}
	}
}
