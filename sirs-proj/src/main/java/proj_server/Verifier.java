package proj_server;

import java.util.List;

public interface Verifier {
	public static final List<LocationVerification> _locs = null;
	public void receiveLocationClaim();	
	public void receiveLocationEndorsement();
	public void broadcastLocationVerification();

}
