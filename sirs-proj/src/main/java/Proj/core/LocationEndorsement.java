package Proj.core;

public class LocationEndorsement {
	Time _time;
	String _evidenceType;
	byte[] _evidence;
	LocationClaim _locationclaim;
	LocationVerification _locationVerification;
	
	public LocationEndorsement(String evidenceType, byte[] evidence) {
		_evidenceType = evidenceType;
		_evidence = evidence;
	}
}
