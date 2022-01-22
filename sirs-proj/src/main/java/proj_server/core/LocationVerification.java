package proj_server.core;

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

	public void setTime(Time time) {
		_time = time;
	}
	public void setLocationClaim(LocationClaim loclaim) {
		_locationClaim = loclaim;
		
	}
	public void addLocationEndorsement(LocationEndorsement locendor) {
		_locationEndorsement.add(locendor);
	}
	public Time getTime() {
		return _time;
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
	public List<LocationEndorsement> getLocationEndorsements(){
		return _locationEndorsement;
	}
}
