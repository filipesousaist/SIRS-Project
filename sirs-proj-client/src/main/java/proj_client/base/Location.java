package proj_client.base;

import proj_contract.proto.Coordinates;

public class Location {
	int _x;
	int _y;
	
	public Location(int x,int y) {
		_x = x;
		_y = y;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public void setX(int x) {
		_x = x;		
	}
	public void setY(int y) {
		_y = y;
	}
	
	@Override
	public String toString() {
		return "{x: " + _x + ", y: " + _y + "}";
	}
	
	public Coordinates toCoordinates() {
		return Coordinates.newBuilder().setX(_x).setY(_y).build();
	}
}