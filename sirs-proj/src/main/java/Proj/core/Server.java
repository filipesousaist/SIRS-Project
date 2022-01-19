package Proj.core;

import java.util.List;


public class Server {
	 Map _map;
	 int id;
	 List<Entity> _entities;
	 
	 // receive the map size
	 public Server(int x, int y){
		 _map = new Map(x,y);
		 
	 }
	 
	 public static void generateEntity() {	
	 }
	 
	 public static void checkEntityPositions() {		 
	 }
	 
	 public boolean addEntity() {
		 return true;
		 
	 }
}
