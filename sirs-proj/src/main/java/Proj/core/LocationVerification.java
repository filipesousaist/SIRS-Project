package Proj.core;

import java.util.List;

public class LocationVerification {
	Time _time;
	String _evidenceType;
	byte[] _evidence;
	LocationClaim _locationClaim;
	List<LocationEndorsement> _locationEndorsement;
	
	public LocationVerification(String evidenceType, byte[] evidence) {
		_evidenceType=evidenceType;
		_evidence=evidence;
	}

}
