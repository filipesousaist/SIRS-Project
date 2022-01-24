package proj_client.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import proj_client.base.Location;

public abstract class Entity {
	private int _id;
	private Location _location;
	private List<SmartVehicle> _observations;
	private int _timestep;
	
	public Entity(int id, int x, int y, int timestep) {
		_id = id;
		_location = new Location(x, y);
		_observations = new ArrayList<SmartVehicle>();
	}
	
	public void collectDatafromSensors(SmartVehicle sv) {
		_observations.add(sv);
	}
	
	public List<SmartVehicle> getObservations() {
		return _observations;
	}
	
	public SmartVehicle getObservation(int id) {
		List<SmartVehicle> svs = _observations.stream()
			.filter(sv -> sv.getId() == id)
			.sorted(Comparator.comparing(SmartVehicle::getTimestep).reversed())
			.collect(Collectors.toList());
		return svs.size() > 0 ? svs.get(0) : null;
	}
	
	public void setLocation(int x, int y) {
		_location.setX(x);
		_location.setY(y);		
	}
	
	public Location getLocation() {
		return _location;
	}
	
	public int getId() {
		return _id;
	}
	
	public int getTimestep() {
		return _timestep;
	}
	
	public void setTimestep(int timestep){
		_timestep = timestep;
	}
	
	public int getSpeed() {
		return 0;
	}
	
	public abstract String getType();
	
	@Override
	public String toString() {
		return "<" + getType() + " " + _id + ">: \n" +
			"  - Timestep: " + _timestep + "\n" +
			"  - Location: " + _location;
	}
}
