package CO3090.coursework2.shared;

import CO3090.coursework2.client.QueryDirDepth;
import CO3090.coursework2.client.QueryDirStructure;
import CO3090.coursework2.client.QueryFileSearch;
import CO3090.coursework2.shared.Query;

public interface FSQueryInterface extends java.rmi.Remote {

	/*
	 * Q (1.2) Please define your remote interface here
	 * 
	 * [Hints: have a look at Compute.java (Lab 3 - ComputeEngine) and the
	 * surgery exercises (Week 5)]
	 * 
	 * 
	 */

	public Object executeTask(Query q) throws java.rmi.RemoteException;

}
