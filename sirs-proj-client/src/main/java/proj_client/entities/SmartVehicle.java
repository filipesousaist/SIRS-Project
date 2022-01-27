package proj_client.entities;

import proj_client.interfaces.IProver;
import proj_client.interfaces.IWitness;
import proj_contract.proto.Coordinates;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.LocationClaimWithId;
import proj_contract.proto.LocationEndorsementRequest;
import proj_contract.services.ServerResponse;

public class SmartVehicle extends Entity implements IProver, IWitness {
	private int _speed;
	private int _claimId;
	
	public SmartVehicle(int id, int x, int y, int timestep, int initialSpeed) {
		super(id, x, y, timestep);
		_speed = initialSpeed;
		_claimId = 0;
	}
	
	public SmartVehicle(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
		_speed = 0;
		_claimId = 0;
	}
	
	@Override
	public int getSpeed() {
		return _speed;
	}
	
	@Override 
	public String getType() {
		return "SV";
	}
	
	@Override
	protected String[] getTypesToConnectTo() {
		return new String[] {"A-RSU"};
	}
	
	@Override
	public String toString() {
		return super.toString() + 
			(_speed > 0 ? ("\n  - Speed: " + _speed) : "");
	}
	
	
	// Send location claim to all nearby A-RSUs
	@Override
	public void broadcastLocationClaim(int observedId) {
		SmartVehicle obs = (observedId == _id) ? this : getObservation(observedId);
		
		if (obs == null) 
			System.out.println("No observations found for entity with id " + observedId + ".");
		else
		{	
			Coordinates coordinates = obs.getLocation().toCoordinates();
			
			EntityData entityData = EntityData.newBuilder()
				.setType(obs.getType())
				.setCoordinates(coordinates)
				.setId(observedId)
				.build();
			
			LocationClaim locationClaim = LocationClaim.newBuilder()				
				.setClaimId(++ _claimId)
				.setProverId(_id)
				.setTimestep(obs.getTimestep())
				.setEntityData(entityData)
				.build();
			
			LocationClaimWithId.Builder builder = LocationClaimWithId.newBuilder()
				.setLocationClaim(locationClaim);
			for (int receiverId: _clientsData.keySet()) {
				LocationClaimWithId locationClaimWithId = builder
					.setReceiverId(receiverId)
					.build();
				ServerResponse response = _serverStub.sendLocationClaim(locationClaimWithId);			
				System.out.println(response.getResponseMessage());				
			}
		}	
	}
	
	@Override
	public void broadcastLocationClaims() {
		for (SmartVehicle sv: getObservations()) {
			if (sv.getTimestep() == _timestep)
				broadcastLocationClaim(sv.getId());
		}
	}
	
	@Override
	public void sendLocationEndorsement(LocationEndorsementRequest request) {
		_serverStub.sendLocationEndorsement(getLocationEndorsement(request));
	}
}
