package proj_server.entities;

import proj_server.base.Location;

public class SmartVehicle extends Entity {

	public SmartVehicle(int id, Location location, int speed) {
		super(id, location, speed);
		
	}

	public String getType() {
		return "SV";
	}
}
