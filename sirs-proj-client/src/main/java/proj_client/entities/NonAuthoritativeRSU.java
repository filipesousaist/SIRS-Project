package proj_client.entities;

import proj_client.interfaces.IWitness;

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
}
