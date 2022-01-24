package proj_server.entities;

import proj_server.base.Location;

public class NonAuthoritativeRSU extends RoadSideUnit {
	public NonAuthoritativeRSU(int id, Location location) {
		super(id, location);
		
	}

	@Override
	public String getType() {
		return "NA-RSU";
	}
}
