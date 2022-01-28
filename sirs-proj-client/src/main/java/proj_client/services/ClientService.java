package proj_client.services;
import io.grpc.stub.StreamObserver;
import proj_client.entities.Entity;
import proj_client.entities.SmartVehicle;
import proj_contract.proto.Coordinates;
import proj_contract.proto.EncryptedLocationClaim;
import proj_contract.proto.EncryptedLocationEndorsement;
import proj_contract.proto.EncryptedLocationEndorsementRequest;
import proj_contract.proto.EntitiesData;
import proj_contract.proto.EntityData;
import proj_contract.proto.TimestepData;
import proj_contract.services.ClientResponse;
import proj_contract.services.ConnectionInfo;
import proj_contract.services.ConnectionInfoResponse;
import proj_contract.services.SecretKeyMessage;
import proj_contract.services.ClientServiceGrpc.ClientServiceImplBase;

public class ClientService extends ClientServiceImplBase {
	private Entity _entity;
	private int _entityId;
	
	public ClientService(Entity entity) {
		_entity = entity;
		_entityId = entity.getId();
	}
	
	@Override
	public void requestConnectionInfo(ConnectionInfo request, StreamObserver<ClientResponse> responseObserver) {		
		_entity.getConnectionInfo(request);
		
		respondToServer(responseObserver, "Get Connection Info");
	}
	
	@Override
	public void sendConnectionInfo(ConnectionInfoResponse request, StreamObserver<ClientResponse> responseObserver) {
		ConnectionInfo connectionInfo = request.getConnectionInfo();
		int id = connectionInfo.getId();
		_entity.storeConnectionInfo(id, connectionInfo.getCertificate(), connectionInfo.getType());
		_entity.sendSecretKey(id);
		
		respondToServer(responseObserver, "Send Connection Info");
	}
	
	@Override
	public void sendSecretKey(SecretKeyMessage request, StreamObserver<ClientResponse> responseObserver) {
		_entity.storeSecretKey(request);
		
		respondToServer(responseObserver, "Send Secret Key");
	}
	
	@Override
	public void updateTimestepData(TimestepData request, StreamObserver<ClientResponse> responseObserver) {
		Coordinates coords = request.getCoordinates();
		_entity.updateTimestepData(request.getTimestep(), coords.getX(), coords.getY());
		
		_entity.clearConnections();
		_entity.broadcastConnectionInfoRequest();
		
		respondToServer(responseObserver, "Timestep Data");
	}

	@Override
	public void collectDataFromSensors(EntitiesData request, StreamObserver<ClientResponse> responseObserver) {
		for (EntityData entData: request.getEntityDataList()){
			if (entData != null) {
				Coordinates coords = entData.getCoordinates();
				SmartVehicle sv = new SmartVehicle(
					entData.getId(), coords.getX(), coords.getY(), _entity.getTimestep()
				);
				_entity.collectDataFromSensors(sv);
			}			
		}
		if (_entity.getType() == "SV")
			_entity.broadcastLocationClaim(_entityId);
		
		respondToServer(responseObserver, "Sensors Data");
	}
	
	@Override
	public void sendLocationClaim(EncryptedLocationClaim request, StreamObserver<ClientResponse> responseObserver) {
		_entity.broadcastLocationEndorsementRequest(request);
		
		respondToServer(responseObserver, "Send Location Claim");
	}
	
	@Override
	public void requestLocationEndorsement(EncryptedLocationEndorsementRequest request, StreamObserver<ClientResponse> responseObserver) {
		_entity.sendLocationEndorsement(request);
		
		respondToServer(responseObserver, "Request Location Endorsement");
	}
	
	@Override
	public void sendLocationEndorsement(EncryptedLocationEndorsement request, StreamObserver<ClientResponse> responseObserver) {
		_entity.storeLocationEndorsement(request);
		
		respondToServer(responseObserver, "Send Location Endorsement");
	}

	
	private void respondToServer(StreamObserver<ClientResponse> responseObserver, String command) {
		ClientResponse response = ClientResponse.newBuilder()
			.setResponseMessage("Client with ID " + _entityId + " executed '" + command + "' successfully.")
			.setResponseCode(0)
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}