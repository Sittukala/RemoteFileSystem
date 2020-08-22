package CO3090.coursework2.shared;

import java.io.File;
import java.io.Serializable;
import java.util.Vector;

public interface Query extends Serializable {

	/*
	 * Q (1.2)
	 * Please define the serializable object here
	 * [Hints: have a look at Task.java (Lab 3) and the surgery exercises (Week 5)]
	 * 
	*/
   
	public Object execute();
	

}
