package proj_client.interfaces;

import proj_client.entities.SmartVehicle;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.LocationEndorsement;
import proj_contract.proto.LocationEndorsementRequest;
import proj_contract.proto.LocationEndorsementWithId;

public interface IWitness {
	// Maximum acceptable difference between location claim and endorsement
	
	public int getId();
	
	public SmartVehicle getMostSimilarObservation(LocationClaim claim);
	
	default public LocationEndorsementWithId getLocationEndorsement(LocationEndorsementRequest endorsementRequest) {
		LocationClaim claim = endorsementRequest.getLocationClaim();
		
		SmartVehicle mostSimilarObservation = getMostSimilarObservation(claim);
		
		if (mostSimilarObservation != null)
			System.out.println("Would send as endorsement the following observation: \n" + mostSimilarObservation);
		else {	
			System.out.println("No observation matches the received claim.");
			return null;
		}
		
		LocationEndorsement endorsement = LocationEndorsement.newBuilder()
			.setWitnessId(getId())
			.setClaimId(claim.getClaimId())
			.setProverId(claim.getProverId())
			.setTimestep(mostSimilarObservation.getTimestep())
			.setEntityData(mostSimilarObservation.toData())
			.build();
		
		LocationEndorsementWithId endorsementWithId = LocationEndorsementWithId.newBuilder()
			.setLocationEndorsement(endorsement)
			.setReceiverId(endorsementRequest.getRequesterId())
			.build();
		
		return endorsementWithId;
	}
}
