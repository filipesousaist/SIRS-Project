package proj_server.entities;

import proj_server.base.Location;

public class AuthoritativeRSU extends RoadSideUnit {

	public AuthoritativeRSU(int id, Location location) {
		super(id, location);
	}

	@Override
	public String getType() {
		return "A-RSU";
	}

}
