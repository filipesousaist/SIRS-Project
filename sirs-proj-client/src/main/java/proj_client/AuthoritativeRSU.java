package proj_client;

public class AuthoritativeRSU extends RoadSideUnit{

	public AuthoritativeRSU(int id, int x, int y) {
		super(id, x, y);
	}
	
	@Override 
	public String getType() {
		return "A-RSU";
	}
}
