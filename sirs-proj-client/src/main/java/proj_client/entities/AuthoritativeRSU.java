package proj_client.entities;

import proj_contract.proto.Coordinates;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.LocationEndorsement;
import proj_contract.proto.LocationEndorsementRequest;
import proj_contract.proto.LocationEndorsementRequestWithId;
import proj_contract.services.ServerResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AuthoritativeRSU extends Entity {
	private static final int MAX_ENDORSEMENTS = 3; 
	private static final int A_RSU_ENDORSEMENT_SCORE = 2;
	private static final int WITNESS_ENDORSEMENT_SCORE = 1;
	private static final int MAX_SCORE = MAX_ENDORSEMENTS * WITNESS_ENDORSEMENT_SCORE + A_RSU_ENDORSEMENT_SCORE; // Should be odd
	
	public class ClaimIdentifier {
		public int _claimId;
		public int _proverId;
		
		public ClaimIdentifier(int claimId, int proverId) {
			_claimId = claimId;
			_proverId = proverId;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null || o.getClass() != getClass())
				return false;
			ClaimIdentifier claimIdentifier = (ClaimIdentifier) o;
			
			return claimIdentifier._claimId == _claimId &&
				   claimIdentifier._proverId == _proverId;
		}
		
		@Override
		public int hashCode() {
			return ((_claimId + _proverId - 1) * (_claimId + _proverId)) / 2 + 1 - _proverId;
		}
		
		@Override
		public String toString() {
			return "{Prover ID: " + _proverId + ", Claim ID: " + _claimId + "}";
		}
	}
	public class ClaimData {
		public static final int LIFE_TIME = 1; 
		public LocationClaim _claim;
		public List<LocationEndorsement> _endorsements;
		public int _timer;
		
		public ClaimData(LocationClaim claim) {
			_claim = claim;
			_endorsements = new ArrayList<LocationEndorsement>();
			_timer = 0;
		}
	}
	private Map<ClaimIdentifier, ClaimData> _claimsData;
	
	public AuthoritativeRSU(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
		_claimsData = new ConcurrentHashMap<ClaimIdentifier, ClaimData>();
	}

	
	@Override
	public void updateTimestepData(int timestep, int x, int y) {
		super.updateTimestepData(timestep, x, y);
		Set<ClaimIdentifier> claimIdentifiers;
		
		synchronized (_claimsData) {
			claimIdentifiers = _claimsData.keySet();
		}
		for (ClaimIdentifier claimIdentifier: claimIdentifiers) {
			ClaimData claimData;
			synchronized (_claimsData) {				
				claimData = _claimsData.get(claimIdentifier);
			}
			if ((++ claimData._timer) >= ClaimData.LIFE_TIME) {
				verifyLocationClaim(claimIdentifier);
			}
		}
		
	}
	@Override 
	public String getType() {
		return "A-RSU";
	}
	
	@Override
	protected String[] getTypesToConnectTo() {
		return new String[] {"NA-RSU", "SV"};
	}
	
	@Override
	public void broadcastLocationEndorsementRequest(LocationClaim request) {
		ClaimIdentifier claimIdentifier = new ClaimIdentifier(request.getClaimId(), request.getProverId());
		boolean idExists;
		synchronized (_claimsData) {			
			idExists = _claimsData.containsKey(claimIdentifier);
		}
		if (! idExists) {
			synchronized (_claimsData) {				
				_claimsData.put(claimIdentifier, new ClaimData(request));
			}
			LocationEndorsementRequest locationEndorsementRequest = LocationEndorsementRequest.newBuilder()
				.setLocationClaim(request)
				.setRequesterId(_id)
				.build();
			
			LocationEndorsementRequestWithId.Builder builder = LocationEndorsementRequestWithId.newBuilder()
				.setLocationEndorsementRequest(locationEndorsementRequest);
			
			for (int receiverId: _clientsData.keySet()) {
				LocationEndorsementRequestWithId locationEndorsementRequestWithId = builder
					.setReceiverId(receiverId)
					.build();
				ServerResponse response = _serverStub.requestLocationEndorsement(locationEndorsementRequestWithId);			
				System.out.println(response.getResponseMessage());				
			}
		}
		else
			System.out.println("Location claim identifier " + claimIdentifier + " already exists.");
	}
	
	@Override
	public void storeLocationEndorsement(LocationEndorsement request) {
		ClaimIdentifier claimIdentifier = new ClaimIdentifier(request.getClaimId(), request.getProverId());
		boolean idExists; 
		synchronized (_claimsData) {
			idExists = _claimsData.containsKey(claimIdentifier);
		}
		if (idExists) {
			List<LocationEndorsement> endorsements;
			synchronized (_claimsData) {				
				endorsements = _claimsData.get(claimIdentifier)._endorsements;
			}
			if (endorsements.size() < MAX_ENDORSEMENTS) {
				endorsements.add(request);
				if (endorsements.size() == MAX_ENDORSEMENTS)
					verifyLocationClaim(claimIdentifier);
			}
			else
				System.out.println("Maximum amount of endorsements for location claim " + claimIdentifier + " reached.");
		}
		else
			System.out.println("Location claim identifier " + claimIdentifier + "not found.");
	}
	
	private void verifyLocationClaim(ClaimIdentifier claimIdentifier) {
		ClaimData claimData;
		synchronized (_claimsData) {
			claimData = _claimsData.get(claimIdentifier);
		}
		
		int score = (getMostSimilarObservation(claimData._claim) != null) ? A_RSU_ENDORSEMENT_SCORE : 0;
		for (LocationEndorsement endorsement: claimData._endorsements) {
			EntityData entityData = endorsement.getEntityData();
			Coordinates coordinates = entityData.getCoordinates();
			
			SmartVehicle observation = new SmartVehicle(entityData.getId(), coordinates.getX(), coordinates.getY(), endorsement.getTimestep());
			score += (getDifference(observation, claimData._claim) <= MAX_DIFFERENCE) ? WITNESS_ENDORSEMENT_SCORE : 0;
		}

		System.out.println("Score for verification of claim " + claimIdentifier + ":");
		System.out.println(score + " out of " + MAX_SCORE);
		System.out.println((2 * score > MAX_SCORE) ? "Location claim approved." : "Location claim rejected.");
		synchronized (_claimsData) {
			_claimsData.remove(claimIdentifier);
		}
	}
}