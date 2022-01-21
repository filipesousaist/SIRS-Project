package Proj.Services;
import Proj.Proto.LocationClaim;
import Proj.Services.ClientServiceGrpc.ClientServiceImplBase;
import Proj.Services.ServerServiceGrpc.ServerServiceImplBase;
import io.grpc.stub.StreamObserver;

public class ClientService extends ClientServiceImplBase {

	@Override
	public void receiveLocationClaim(LocationClaim request, StreamObserver<ClientResponse> responseObserver) {
		System.out.println("Location claim Received ");
		// TODO Auto-generated method stub
		super.receiveLocationClaim(request, responseObserver);
	}
	
}