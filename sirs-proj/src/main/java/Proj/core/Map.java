package Proj.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Proj.core.exception.MapPositionOutOfBoundsException;
import Proj.core.exception.MapPositionTakenException;

public class Map {	
	private int _width;
	private int _height;
	private int _size;
	
	List<Entity> _entities;
	
	MapDisplay _display;
	
	public Map(int width, int height) {
		_width = width;
		_height = height;
		_size = width * height;
		_entities = new ArrayList<Entity>(Collections.nCopies(_size, null));
		
		_display = new MapDisplay(this, _width, _height);
		_display.render();
	}
	
	public Entity getEntity(int x, int y) throws MapPositionOutOfBoundsException {
		int index = x * _height + y;
		if (index < 0 || index >= _size)
			throw new MapPositionOutOfBoundsException();
		return _entities.get(x * _height + y);
	}
	
	public Entity getEntityOrNull(int x, int y) {
		try {
			return getEntity(x, y);
		}
		catch (MapPositionOutOfBoundsException e) {
			return null;
		}
	}
	
	public void addEntity(Entity ent) throws MapPositionTakenException, MapPositionOutOfBoundsException {
		try {
			Location entLoc = ent.getLocation();
			int entX = entLoc.getX();
			int entY = entLoc.getY();
			
			Entity oldEnt = getEntity(entX, entY);
			if (oldEnt == null)
				_entities.set(entX * _height + entY, ent);
			else
				throw new MapPositionTakenException(oldEnt, ent);
		}
		catch (MapPositionOutOfBoundsException e) {
			e.setEntity(ent);
			throw e;
		}
	}
	
	public void moveEntity(Entity ent, int steps) {
		Location loc = ent.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		int oldX = x;
		
		for (int i = 0; i < steps; i ++) {
			int nextX = Math.floorMod(x + 1, _width);
			if (_entities.get(nextX * _height + y) != null)
				break;
			x = nextX;
		}
		
		// Remove entity from previous location
		_entities.set(oldX * _height + y, null);
		
		// Place entity in new location
		loc.setX(x);
		_entities.set(x * _height + y, ent);
		
	}
	
	public void print() {
		String roadLimit = "";
		for (int i = 0; i < _width; i ++)
			roadLimit += '=';
		
		System.out.println(roadLimit);
		
		for (int y = 0; y < _height; y ++) {
			String line = "";
			for (int x = 0; x < _width; x ++)
				line += entityToChar(x, y);
			System.out.println(line);
		}
		
		System.out.println(roadLimit);
	}
	
	private char entityToChar(int x, int y) {
		Entity entity = _entities.get(x * _height + y);
		if (entity == null)
			return ' ';
		
		switch (entity.getType()) {
			case "SV":
				return 'V';
			case "A-RSU":
				return 'A';
			case "NA-RSU":
				return 'N';
			default:
				return '?';
		}
	}
	
	public void draw() {
		_display.render();
	}
}
