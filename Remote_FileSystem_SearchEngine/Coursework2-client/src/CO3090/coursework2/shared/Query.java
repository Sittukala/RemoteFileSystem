package CO3090.coursework2.shared;

import java.io.File;
import java.io.Serializable;
import java.util.Vector;

public interface Query extends Serializable {

	/*
	 * Q (1.2) Please define your serializable object
	 * 
	 * [Hints: have a look at Task.java (Lab 3 - ComputeEngine) and the surgery
	 * exercises (Week 5)]
	 * 
	 *
	 */
	public Object execute();
}
