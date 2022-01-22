package proj_server;

public class Location {
	int _x;
	int _y;
	
	public Location(int x,int y) {
		_x=x;
		_y=y;
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
}
