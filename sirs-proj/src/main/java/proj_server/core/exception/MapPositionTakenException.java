package proj_server.core.exception;

import proj_server.core.Entity;
import proj_server.core.Location;

public class MapPositionTakenException extends Exception {
	Entity _oldEntity;
	Entity _newEntity;

	private static final long serialVersionUID = 1L;
	
	public MapPositionTakenException(Entity oldEntity, Entity newEntity) {
		_oldEntity = oldEntity;
		_newEntity = newEntity;
	}
	
	@Override
	public String getMessage() {
		Location loc = _newEntity.getLocation();
		
		return "Failed to add " + _newEntity.getType() + " with id " + _newEntity.getID() +
				" to position {x: " + loc.getX() + ", y: " + loc.getY() + "}:" +
				" position already taken by " + _oldEntity.getType() + " with id " + _oldEntity.getID() + ".";
	}

}
