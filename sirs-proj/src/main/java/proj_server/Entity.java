package proj_server;
public abstract class Entity {
	int _id;
	Location _location;
	int _speed;
	
	public Entity(int id, Location location, int speed) {
		_id = id;
		_location = location;
		_speed = speed;
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
	
	public abstract String getType();
	
	public int getSpeed() {
		return _speed;
	}
	
	public void collectDataFromSensors() {
		
	}
}
