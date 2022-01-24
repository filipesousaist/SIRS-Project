package proj_client.entities;

public class AuthoritativeRSU extends RoadSideUnit{

	public AuthoritativeRSU(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
	}
	
	@Override 
	public String getType() {
		return "A-RSU";
	}
}
