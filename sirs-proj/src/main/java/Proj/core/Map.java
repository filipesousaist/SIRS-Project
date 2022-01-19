package Proj.core;

import java.util.ArrayList;
import java.util.List;

import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;

public class Map {
	int _width;
	int _height;
	
	List<Position> _positions;
	
	public Map(int width, int height) {
		_width = width;
		_height = height;
		_positions = new ArrayList<Position>();
		
		for (int x = 0; x < width ; x ++) {
			for (int y = 0; y < height; y ++) {
				Position pos = new Position(new Location(x, y), null);
				_positions.add(pos);
			}			
		}		
	}
	
	public void MapPrinter() {
	}
	
	// entity can be null	
	public void addEntity(Entity ent) throws MapPositionTakenException, MapPositionOutOfBoundsException {
		Location entLoc = ent.getLocation();
		
		for (Position pos : _positions) {
			Location loc = pos.getLocation();
			
			if (loc.getX() == entLoc.getX() && loc.getY() == entLoc.getY()) {
				Entity oldEnt = pos.getEntity();
				if (oldEnt == null) {	
					pos.setEntity(ent);
					return;
				}
				throw new MapPositionTakenException(oldEnt, ent);
			}
		}		
		throw new MapPositionOutOfBoundsException(ent);
	}
}
