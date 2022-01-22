package proj_server;

public class AuthoritativeRSU extends RoadSideUnit implements Verifier {

	public AuthoritativeRSU(int id, Location location) {
		super(id, location);
	}

	public void receiveLocationClaim(){	
		
	}

	public void receiveLocationEndorsement() {	
		
	}

	public void broadcastLocationVerification() {
				
	}
	
	public String getType() {
		return "A-RSU";
	}

}
