package Proj.core;

import java.util.ArrayList;
import java.util.List;

import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;


public class ServerEnvironment {
	 Map _map;
	 int id;
	 List<Entity> _entities;
	 
	 // receive the map size
	 public ServerEnvironment(int x, int y){
		 _map = new Map(x,y);
		 _entities= new ArrayList<Entity>();
	 }
	 
	 public static void checkEntityPositions() {		 
	 }
	 
	 
	 public void addEntity(Entity entity) throws MapPositionTakenException, MapPositionOutOfBoundsException {	 
		 _map.addEntity(entity);
		 // entity will only be added to _entities if _map.addEntity does not throw an exception
		 _entities.add(entity);
	 }
}
