package Proj.core;

public class Position {
	Location _loc;
	Entity _ent;
	
	public Position(Location loc, Entity ent){
		_loc = loc;
		_ent=ent;
	}
	
	public Location getLocation() {
		return _loc;
	}
	
	public Entity getEntity() {
		return _ent;
	}
	
	public void setEntity(Entity ent) {
		_ent=ent;
	}

}
