package proj_client.entities;

import java.io.Serializable;

public class KeyAndSignature implements Serializable {

	private static final long serialVersionUID = 7191521203968708199L;
	
	public byte[] secretKeyBytes;
	public byte[] signatureBytes;
}
