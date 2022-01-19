package Proj.core;

public abstract class Client {
	String id;
	Location location;
	
	public Client(String id, int x, int y) {
		this.id = id;
		this.location = new Location(x, y);
	}
}
