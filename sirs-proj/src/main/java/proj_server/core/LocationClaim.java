package proj_server.core;


import java.util.List;

public class LocationClaim {
	String _evidenceType;
	byte[] _evidence;
	Location _location;
	Time _time;
	List<LocationEndorsement> _locationEndorsement;
	LocationVerification _locationVerification;
	
	public LocationClaim(String evidenceType, byte[] evidence){
		_evidenceType=evidenceType;
		_evidence = evidence;		
	}
	
	public void setTime(Time time) {
		_time=time;
	}
	
	public void setLocation(Location loc) {
		_location = loc;
	}
	
	public void setLocationVerification(LocationVerification locver) {
		_locationVerification = locver;
	}
	
	public void addLocationEndorsement(LocationEndorsement endor) {
		_locationEndorsement.add(endor);
	}
	
	public String getEvidencetype() {
		return _evidenceType;
	}
	
	public byte[] getEvidence() {
		return _evidence;
	}
	public Location getLocation() {
		return _location;
	} 

	public Time getTime() {
		return _time;
	} 
	
	public List<LocationEndorsement> getLocationEndorsements() {
		return _locationEndorsement;
	} 
	
	public LocationVerification getLocationVerification() {
		return _locationVerification;
	}



}
