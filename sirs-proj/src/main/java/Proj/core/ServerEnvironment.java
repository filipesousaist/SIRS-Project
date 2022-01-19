package Proj.core;

import java.util.ArrayList;
import java.util.List;


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
	 
	 //verificacoes em falta	 
	 public boolean addEntity(Entity ent, Location loc){
		 _entities.add(ent);
		 _map.addEntity(ent, loc);
		 return true;
		 
	 }
}
