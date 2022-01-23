package proj_client;

public class SmartVehicle extends Entity {
	int _speed;
	
	public SmartVehicle(int id, int x, int y, int initialSpeed) {
		super(id, x, y);
		_speed = initialSpeed;
	}
	
	public SmartVehicle(int id, int x, int y) {
		super(id, x, y);
		_speed = 0;
	}
	
	@Override
	public int getSpeed() {
		return _speed;
	}
	
	@Override 
	public String getType() {
		return "SV";
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" +
			"  - Speed: " + _speed;
	}
}
