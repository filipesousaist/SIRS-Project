package Proj.core;


import java.util.List;

public class LocationClaim {
	String _evidenceType;
	byte[] _evidence;
	Location location;
	Time time;
	List<LocationEndorsement> _locationEndorsement;
	LocationVerification _locationVerification;
	
	public LocationClaim(String evidenceType, byte[] evidence){
		_evidenceType=evidenceType;
		_evidence = evidence;		
	}

}
