package Proj.core;

public class SmartVehicle extends Client {
	int speed;
	
	public SmartVehicle(String id, int x, int y, int initialSpeed) {
		super(id, x, y);
		
		speed = initialSpeed;
	}
}
