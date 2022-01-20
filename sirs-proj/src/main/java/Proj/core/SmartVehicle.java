package Proj.core;

public class SmartVehicle extends Entity implements Prover, Witness {

	public SmartVehicle(int id, Location location, int speed) {
		super(id, location, speed);
		
	}

	public void receiveLocationVerification() {
		
	}

	public void receiveLocationClaim() {
	
		
	}

	public void sendLocationEndorsement() {
		
		
	}

	public void broadcastLocationClaim() {
		
		
	}

	public String getType() {
		return "SV";
	}

}
