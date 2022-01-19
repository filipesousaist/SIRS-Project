package Proj.core;

import java.util.List;

public class Map {
	 List<Position> _map;
	
	
	public Map(int _x, int _y) {
		for(int x = 0; x<_x ;x++) {
			for(int y =0; y<_y; y++) {
				Entity ent = null;
				Location loc = new Location(x,y);
				Position pos = new Position(loc,ent);
				_map.add(pos);
			}			
		}		
	}
	
	public void MapPrinter() {
	}
	
	// entity can be null	
	public boolean addEntity(Entity ent, Location loc) {
		for(Position pos : _map) {
			if(pos.getLocation().getX()==loc.getX() && pos.getLocation().getY()==loc.getY()) {
				pos.setEntity(ent);
				return true;
			}
		}		
		return false;
	}
}
