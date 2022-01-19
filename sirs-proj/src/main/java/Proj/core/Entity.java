package Proj.core;
public class Entity {
	int _id;
	Location _location;
	public Entity(int id, Location location) {
		_id=id;
		_location = location;
	}
	
	public int getID() {
		return _id;
	}
	
	public void collectDataFromSensors() {
		
	}
}
