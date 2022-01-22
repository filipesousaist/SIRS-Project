package proj_server;

public class NonAuthoritativeRSU extends RoadSideUnit implements Witness, Verifier {
	public NonAuthoritativeRSU(int id, Location location) {
		super(id, location);
		
	}

	public void receiveLocationEndorsement() {
		
		
	}

	public void broadcastLocationVerification() {
		
		
	}

	public void receiveLocationClaim() {
		
		
	}

	public void sendLocationEndorsement() {
		
		
	}


	public String getType() {
		return "NA-RSU";
	}
}
