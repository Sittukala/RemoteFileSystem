package CO3090.coursework2.client;

import CO3090.coursework2.shared.*;

import java.rmi.*;
import java.util.HashMap;
import java.util.Vector;

public class FileSystemQueryClient {

	public static void main(String args[]) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			String name = "rmi://" + args[0] + "/FileSystemSearch";
			FSQueryInterface comp = (FSQueryInterface) Naming.lookup(name);

			QueryDirStructure queryDirStructureTask = new QueryDirStructure(args[1]);

			QueryDirDepth queryDirDepth = new QueryDirDepth(args[1]);

			QueryFileSearch queryFile = new QueryFileSearch(args[2]);

			/**
			 * 
			 * Q (2.5)
			 * 
			 * Three instances of query should be created respectively for each
			 * class you implemented in (2.1), (2.2) and (2.3). Queries should
			 * be submitted to the FileSystemServer and subsequently executed.
			 * The results should be returned to the client (extra bonus will be
			 * given to those who execute three queries concurrently using Java
			 * thread).
			 * 
			 * 
			 */

			String directorystructure = ((String) (comp.executeTask(queryDirStructureTask)));
			Integer dirdepth = ((Integer) (comp.executeTask(queryDirDepth)));

			Vector<String> file = ((Vector<String>) (comp.executeTask(queryFile)));

			System.out.println("Driectory Structure  : " + "\t" + directorystructure + "\n" + "Direcrory depth  : "
					+ "\t" + dirdepth + "\n" + "File : " + file);

		} catch (Exception e) {
			System.err.println("exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
