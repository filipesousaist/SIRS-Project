package proj_client.entities;

public class SmartVehicle extends Entity {
	int _speed;
	
	public SmartVehicle(int id, int x, int y, int timestep, int initialSpeed) {
		super(id, x, y, timestep);
		_speed = initialSpeed;
	}
	
	public SmartVehicle(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
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
		return super.toString() + 
			(_speed > 0 ? ("\n  - Speed: " + _speed) : "");
	}
}
