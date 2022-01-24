package proj_client.entities;

public class NonAuthoritativeRSU extends RoadSideUnit{

	public NonAuthoritativeRSU(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
	}
	
	@Override 
	public String getType() {
		return "NA-RSU";
	}
}
