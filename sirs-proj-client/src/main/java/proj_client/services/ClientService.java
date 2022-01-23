package proj_client.services;
import io.grpc.stub.StreamObserver;
import proj_client.EntityServer;
import proj_client.SmartVehicle;
import proj_contract.proto.Coordinates;
import proj_contract.proto.EntitiesData;
import proj_contract.proto.EntityData;
import proj_contract.proto.LocationClaim;
import proj_contract.proto.TimestepData;
import proj_contract.services.ClientResponse;
import proj_contract.services.ClientServiceGrpc.ClientServiceImplBase;

public class ClientService extends ClientServiceImplBase {
	private EntityServer _entityServer;
	private int _entityId;
	
	public ClientService(EntityServer entityServer) {
		_entityServer = entityServer;
		_entityId = entityServer.getEntityId();
	}
	
	@Override
	public void receiveLocationClaim(LocationClaim request, StreamObserver<ClientResponse> responseObserver) {
		System.out.println("Location claim received.");
		
		respondToServer(responseObserver, "Location Claim");
	}

	@Override
	public void collectDataFromSensors(EntitiesData request, StreamObserver<ClientResponse> responseObserver) {
		for (EntityData entData: request.getEntityDataList()){
			if (entData != null) {
				Coordinates coords = entData.getCoordinates();
				SmartVehicle sv = new SmartVehicle(
					entData.getId(), coords.getX(), coords.getY()
				);
				_entityServer.collectDataFromSensors(sv);
			}			
		}
		
		respondToServer(responseObserver, "Sensors Data");
	}

	@Override
	public void updateTimeStep(TimestepData request, StreamObserver<ClientResponse> responseObserver) {
		Coordinates coords = request.getCoordinates();
		_entityServer.updateTimestepData(request.getTimestep(), coords.getX(), coords.getY());
		
		respondToServer(responseObserver, "Timestep Data");
	}
	
	private void respondToServer(StreamObserver<ClientResponse> responseObserver, String message) {
		ClientResponse response = ClientResponse.newBuilder()
			.setResponseMessage("Client with ID " + _entityId + " received \"" + message + "\" successfully.")
			.setResponseCode(0)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}