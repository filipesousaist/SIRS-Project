package proj_client;

public class NonAuthoritativeRSU extends RoadSideUnit{

	public NonAuthoritativeRSU(int id, int x, int y) {
		super(id, x, y);
	}
	
	@Override 
	public String getType() {
		return "NA-RSU";
	}
}
