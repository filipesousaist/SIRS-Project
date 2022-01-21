package Proj.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;


public class EnvironmentServer implements Runnable {
	 Map _map;
	 int id;
	 List<Entity> _entities;
	 
	 // receive the map size
	 public EnvironmentServer(int x, int y){
		 _map = new Map(x,y);
		 _entities= new ArrayList<Entity>();
	 }
	 
	 public void addEntity(Entity entity) throws MapPositionTakenException, MapPositionOutOfBoundsException {	 
		 _map.addEntity(entity);
		 // entity will only be added to _entities if _map.addEntity does not throw an exception
		 _entities.add(entity);
	 }
	 
	 public List<Entity> getEntities(){
		 return _entities;
	 }
	 
	 public Entity getEntity(int id){
		 for(Entity ent: _entities){
			 if(ent.getID()==id) return ent;
		 }
		 return null;
	 }
	 public List<Entity> getCloseEntities(Entity ent){
		 List<Entity> lista = new ArrayList<Entity>();
		 for(Entity entity: _entities) {
			 if(Math.pow(entity.getLocation().getX()-ent.getLocation().getX(),2)+ Math.pow(entity.getLocation().getY()-ent.getLocation().getY(),2)<=9 && entity.getID()!=ent.getID()){
				 lista.add(entity);				 
			 }
		 }		 
		 return lista;
	 }
	 
	 @Override
	 public void run() {
		 try {
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 while (true) {
				reader.readLine();
				_map.moveEntities();
				_map.print();
			 } 
		 }
		 catch (IOException e) {
			e.printStackTrace();
		 }
	 }
}
