package proj_server;

public class LocationEndorsement {
	Time _time;
	String _evidenceType;
	byte[] _evidence;
	LocationClaim _locationClaim;
	LocationVerification _locationVerification;
	
	public LocationEndorsement(String evidenceType, byte[] evidence) {
		_evidenceType = evidenceType;
		_evidence = evidence;
	}
	
	public void setTime(Time time) {
		_time = time;
	}
	
	public void setLocationClaim(LocationClaim loclaim) {
		_locationClaim = loclaim;
	}
	
	public void setLocationVerification(LocationVerification locver) {
		_locationVerification = locver;
	}
	public String getEvidenceType() {
		return _evidenceType;
	}
	public byte[] getEvidence() {
		return _evidence;
	}
	
	public LocationClaim getLocationClaim() {
		return _locationClaim;
	}
	
	public LocationVerification getLocationVerification() {
		return _locationVerification;
	}
	
	public Time getTime() {
		return _time;
	}	
}
