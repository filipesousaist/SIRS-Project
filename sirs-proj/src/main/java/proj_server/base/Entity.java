package proj_server.base;

import proj_contract.proto.EntityData;

public class Entity {
	int _id;
	Location _location;
	String _type;
	int _speed;
	
	public Entity(int id, Location location, String type, int speed) {
		_id = id;
		_location = location;
		_type = type;
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
	
	public String getType() {
		return _type;
	}
	
	public int getSpeed() {
		return _speed;
	}

	public EntityData toData() {
		return EntityData.newBuilder()
			.setType(_type)
			.setCoordinates(_location.toCoordinates())
			.setId(_id)
			.build();
	}
}