package proj_server.core.exception;

import proj_server.core.Entity;
import proj_server.core.Location;

public class MapPositionOutOfBoundsException extends Exception {
	Entity _entity;
	
	private static final long serialVersionUID = 1L;
	
	public MapPositionOutOfBoundsException(Entity entity) {
		_entity = entity;
	}
	
	public MapPositionOutOfBoundsException() {
		
	}
	
	public void setEntity(Entity entity) {
		_entity = entity;
	}

	@Override
	public String getMessage() {
		Location loc = _entity.getLocation();
		
		return "Failed to add " + _entity.getType() + " with id " + _entity.getID() +
				" to position {x: " + loc.getX() + ", y: " + loc.getY() + "}:" +
				" position out of bounds.";
	}
	
}
