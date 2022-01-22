package proj_server;

import java.util.List;

public interface Witness {
	public static final List<LocationEndorsement> _locs = null;
	public void receiveLocationClaim();
	public void sendLocationEndorsement();

}
