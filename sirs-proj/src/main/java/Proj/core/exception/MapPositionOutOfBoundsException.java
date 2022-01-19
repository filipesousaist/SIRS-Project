package Proj.core.exception;

import Proj.core.Entity;
import Proj.core.Location;

public class MapPositionOutOfBoundsException extends Exception {
	Entity _entity;
	
	private static final long serialVersionUID = 1L;
	
	public MapPositionOutOfBoundsException(Entity entity) {
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