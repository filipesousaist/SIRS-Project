package proj_client.entities;

import java.util.Set;

import com.google.protobuf.ByteString;

import proj_client.interfaces.IWitness;
import proj_contract.proto.EncryptedLocationEndorsement;
import proj_contract.proto.EncryptedLocationEndorsementRequest;
import proj_contract.proto.EncryptedLocationEndorsementWithId;
import proj_contract.proto.LocationEndorsement;
import proj_contract.proto.LocationEndorsementRequest;
import proj_contract.services.ServerResponse;

public class NonAuthoritativeRSU extends Entity implements IWitness {

	public NonAuthoritativeRSU(int id, int x, int y, int timestep) {
		super(id, x, y, timestep);
	}
	
	@Override 
	public String getType() {
		return "NA-RSU";
	}
	
	@Override
	protected String[] getTypesToConnectTo() {
		return new String[] {"A-RSU"};
	}
	
	@Override
	public void sendLocationEndorsement(EncryptedLocationEndorsementRequest request) {
		Set<Integer> clientIds;
		synchronized(_clientsData) {
			clientIds = _clientsData.keySet();
		}
		for (int senderId: clientIds) {
			ClientData clientData;
			synchronized(_clientsData) {
				clientData = _clientsData.get(senderId);
			}
			if (clientData.secretKey != null) {	
				byte[] locationEndorsementRequestBytes = decrypt(
					request.getData().toByteArray(),
					clientData.secretKey,
					request.getInitializationVector().toByteArray());
				if (locationEndorsementRequestBytes != null) {
					LocationEndorsementRequest locationEndorsementRequest =
						(LocationEndorsementRequest) convertBytesToObject(locationEndorsementRequestBytes);
					LocationEndorsement locationEndorsement = getLocationEndorsement(locationEndorsementRequest);
					if (locationEndorsement != null) {
						byte[] initializationVector = createInitializationVector();
						byte[] encryptedLocationEndorsementBytes = encrypt(
							convertObjectToBytes(locationEndorsement),
							clientData.secretKey,
							initializationVector
							);
						EncryptedLocationEndorsement encryptedLocationEndorsement = EncryptedLocationEndorsement.newBuilder()
							.setData(ByteString.copyFrom(encryptedLocationEndorsementBytes))
							.setInitializationVector(ByteString.copyFrom(initializationVector))
							.build();
						EncryptedLocationEndorsementWithId encryptedLocationEndorsementWithId = EncryptedLocationEndorsementWithId.newBuilder()
							.setEncryptedLocationEndorsement(encryptedLocationEndorsement)
							.setReceiverId(senderId)
							.build();
						ServerResponse response = _serverStub.sendLocationEndorsement(encryptedLocationEndorsementWithId);
						System.out.println(response.getResponseMessage());
						return;
					}	
				}
			}
		}
	}
}
