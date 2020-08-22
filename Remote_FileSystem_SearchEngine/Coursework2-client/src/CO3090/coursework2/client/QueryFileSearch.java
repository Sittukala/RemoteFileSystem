package CO3090.coursework2.client;

import CO3090.coursework2.shared.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Vector;

public class QueryFileSearch implements Query {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3652925158658358109L;
	final String root_path_str = "C:\\Distributed\\CW2\\DemoFolders\\";
	String fileName;
	Vector<String> v = new Vector<String>();

	public QueryFileSearch(String filename) {

		super();

		this.fileName = filename;

	}
	// String newPath = "C:\\Distributed\\CW2\\DemoFolders\\A";

	/*
	 * (2.3) implement abstract methods you defined in Query.java
	 * 
	 * A query of this type should search for file and return the full paths
	 * (absolute path to your root directory) of the file if it is found. If
	 * more than one file with the given name was found in different locations
	 * then the query should return all paths (using appropriate Java collection
	 * types i.e. Vector).
	 * 
	 * For example, given the directory structure in Figure (1),
	 * 
	 * QueryFileSearch q2=new QueryFileSearch(â€œFile1â€�), when q2 is executed
	 * on the server. The server should return â€œ/A/B/File1.txtâ€� and
	 * â€œ/A/C/D/File1.txtâ€�
	 * 
	 * 
	 * 
	 */
	public Object execute() {
		fileName = fileName.concat(".txt");

		Vector<String> v1 = findFile(fileName, root_path_str);
		return v1;

	}

	public Vector<String> findFile(String file, String path) {

		File root = new File(path);
		File[] list = root.listFiles();
		// System.out.print(root.getName() + "{");

		for (File l : list) {
			// System.out.println(l);
			// System.out.println(l.getName());
			if (l.getName().matches(file)) {
				// System.out.println(l.getAbsolutePath());
				v.add(l.getAbsolutePath());
			}
			if (l.isDirectory()) {
				// System.out.println(l);
				if (l.listFiles().length > 0) {
					// System.out.println(l.getAbsolutePath());
					findFile(file, l.getPath());
				}
			}

		}
		return v;
	}
}
