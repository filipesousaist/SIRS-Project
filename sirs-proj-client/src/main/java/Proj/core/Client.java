package Proj.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Client {
	String id;
	Location location;
	List<SmartVehicle> _cars;
	int timestep;
	
	public Client(String id, int x, int y) {
		this.id = id;
		this.location = new Location(x, y);
		_cars = new ArrayList<SmartVehicle>();
	}
	
	public void collectedDatafromSensors(SmartVehicle smart){
		_cars.add(smart);
	}
	public void setLocation(int x, int y) {
		this.location.setX(x);
		this.location.setY(y);		
	}
	public int getTimeStep() {
		return timestep;
	}
	public void setTimeStep(int time){
		this.timestep=time;
	}
}
