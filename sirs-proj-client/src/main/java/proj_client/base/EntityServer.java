package proj_client.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import proj_client.entities.Entity;
import proj_client.entities.SmartVehicle;
import proj_contract.proto.Coordinates;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.services.ServerResponse;
import proj_contract.services.ServerServiceGrpc.ServerServiceBlockingStub;

public class EntityServer implements Runnable {
	private Entity _entity;
	private ServerServiceBlockingStub _serverStub;
	private int _claimId;
	
	private boolean _running;
	
	public EntityServer(Entity entity, ServerServiceBlockingStub serverStub) {
		_entity = entity;
		_serverStub = serverStub;
		_claimId = 0;
	}
	
	public int getEntityId() {
		return _entity.getId();
	}
	
	public int getTimestep() {
		return _entity.getTimestep();
	}
	
	public void updateTimestepData(int timestep, int x, int y) {
		_entity.setTimestep(timestep);
		_entity.setLocation(x, y);
	}
	
	public void collectDataFromSensors(SmartVehicle sv) {
		_entity.collectDatafromSensors(sv);
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			int id = _entity.getId();
			String type = _entity.getType();
			
			_running = true;
			while (_running) {
				System.out.print(type + "_" + id + "$ ");
				List<String> words = Arrays.asList(reader.readLine().split(" "))
					.stream()
					.map(word -> word.toUpperCase())
					.collect(Collectors.toList());
				
				executeCommand(words);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void executeCommand(List<String> words) throws IOException {
		int numWords = words.size();
		if (numWords > 0) {	
			String firstWord = words.get(0);
			if (firstWord.length() > 0)
				switch (firstWord.charAt(0)) {
					case 'I':
						printOwnInformation(); break;
					case 'O':
						printObservations(); break;
					case 'L':
						if (numWords == 1)
							broadcastLocationClaim(_entity.getId());
						else // At least 2 words
							try {
								broadcastLocationClaim(Integer.parseInt(words.get(1)));
							} catch (NumberFormatException e) {
								System.out.println("Invalid ID format. ID must be an integer.");
							}
						break;
					case 'Q':
						_running = false; break;
				}
		}
	}
	
	private void printOwnInformation() {
		System.out.println(_entity);
	}
	
	private void printObservations() {
		for (SmartVehicle sv: _entity.getObservations())
			System.out.println(sv);
	}
	
	private void broadcastLocationClaim(int observedId) {
		int myId = _entity.getId();
		Entity ent = (observedId == myId) ?
			_entity : _entity.getObservation(observedId);
		
		if (ent == null) 
			System.out.println("No observations found for entity with id " + observedId + ".");
		else
		{	
			Coordinates coordinates = ent.getLocation().toCoordinates();
			
			EntityData entityData = EntityData.newBuilder()
				.setType(ent.getType())
				.setCoordinates(coordinates)
				.setId(observedId)
				.build();
			
			LocationClaim locationClaim = LocationClaim.newBuilder()				
				.setClaimId(++ _claimId)
				.setProverId(myId)
				.setTimestep(ent.getTimestep())
				.setEntityData(entityData)
				.build();
		
			ServerResponse response = _serverStub.broadcastLocationClaim(locationClaim);			
			System.out.println(response.getResponseMessage());
		}	
	}
}
