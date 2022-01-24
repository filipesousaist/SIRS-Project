package proj_server.entities;

import proj_server.base.Location;

public abstract class RoadSideUnit extends Entity{
	public RoadSideUnit(int id, Location location) {
		super(id, location, 0);
	}
}
