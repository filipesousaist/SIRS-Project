package Proj.core;
public class Entity {
	int _id;
	Location _location;
	String _type;
	public Entity(int id, Location location, String type) {
		_id=id;
		_location = location;
		_type=type;
	}
	
	public void setLocation(Location loc) {
		_location = loc;		
		
	}
	
	public Location getLocation() {
		return _location;
	}
	
	
	public int getID() {
		return _id;
	}
	
	public String getType() {
		return _type;
	}
	
	public void collectDataFromSensors() {
		
	}
}
