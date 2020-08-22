package CO3090.coursework2.server;

import CO3090.coursework2.shared.*;
import CO3090.coursework2.shared.Query;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class FileSystemServer extends UnicastRemoteObject implements FSQueryInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3949383568307499073L;
	/*
	 * root_path_str: the root directory of the file system Please change the
	 * path to your local directory accordingly
	 */
	final String root_path_str = "C:\\Distributed\\CW2\\DemoFolders\\";

	/**
	 * Q (2.1) Please complete the constructor.
	 * 
	 */

	public FileSystemServer() throws RemoteException {
		super();
		// ...
	}

	/**
	 * Q (2.1)
	 * 
	 * Please provide an implementation of the remote method defined in
	 * Query.java. [Hints: have a look at ComputeEngine.java in Lab 3]
	 * 
	 */
	public Object executeTask(Query q) throws RemoteException {
		return q.execute();
	}

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		String name = "rmi://localhost/FileSystemSearch";

		try {
			FSQueryInterface engine = new FileSystemServer();
			Naming.rebind(name, engine);
			System.out.println("FileSystemSearch Engine bound");

		} catch (Exception e) {
			System.err.println("FileSystemSearch exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
