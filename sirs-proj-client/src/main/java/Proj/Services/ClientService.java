package Proj.Services;
import Proj.Proto.Entities;
import Proj.Proto.Entity;
import Proj.Proto.LocationClaim;
import Proj.Proto.Position;
import Proj.Services.ClientServiceGrpc.ClientServiceImplBase;
import Proj.Services.ServerServiceGrpc.ServerServiceImplBase;
import Proj.core.Client;
import Proj.core.SmartVehicle;
import io.grpc.stub.StreamObserver;

public class ClientService extends ClientServiceImplBase {
	private Client _client;
	@Override
	public void receiveLocationClaim(LocationClaim request, StreamObserver<ClientResponse> responseObserver) {
		System.out.println("Location claim Received ");
		// TODO Auto-generated method stub
		super.receiveLocationClaim(request, responseObserver);
	}

	@Override
	public void collectDataFromSensor(Entities request, StreamObserver<ClientResponse> responseObserver) {
		for(int i = 0; i < request.getEntityCount();i++){
			Entity ent = request.getEntity(i);
			if(ent!=null) {
				int x = ent.getX();
				int y = ent.getY();
				String id = ent.getId();
				SmartVehicle smart = new SmartVehicle(id,x,y);
				_client.collectedDatafromSensors(smart);
			}			
		}
	}

	@Override
	public void updateTimeStep(Position request, StreamObserver<ClientResponse> responseObserver) {
		int x = request.getX();
		int y = request.getY();
		int timestep = request.getTimestep();
		this._client.setTimeStep(timestep);
		this._client.setLocation(x,y);		
	}
	
	public void setClient(Client client){
		_client = client;
		
	}
}