package CO3090.coursework2.client;

import CO3090.coursework2.shared.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

public class QueryDirDepth implements Query {
	/**
	* 
	*/
	private static final long serialVersionUID = -5851031594470505450L;
	static String root_path_str = "C:\\Distributed\\CW2\\DemoFolders\\";
	String dirName = "";
	final List<Integer> array = new ArrayList<Integer>();

	// String param="A\\C\\E";

	public QueryDirDepth(String dirName) {
		super();
		this.dirName = dirName;

	}

	// Path p = Paths.get(param).getFileName();

	/*
	 * Q (2.2) implement the abstract methods you defined in Query.java
	 * 
	 * QueryDirDepth.java - a query of this type should return the maximum
	 * subdirectory depth of a given folder in the directory tree. For example,
	 * given the directory structure in Figure (1),
	 * 
	 * For example:
	 * 
	 * QueryDirDepth q1=new QueryDirDepth (â€œ/Aâ€�)
	 * 
	 * when q1 is executed on the server, FileSystemServer should return 4
	 * because the maximum subdirectory depth from path /A is 4.
	 * 
	 * similarly, if
	 * 
	 * QueryDirDepth q1=new QueryDirDepth (â€œ/A/Eâ€�)
	 * 
	 * the result would be 3.
	 * 
	 * If the directory does not exists on the server, it should return
	 * 
	 */

	public Object execute() {

		String newPath = root_path_str.concat(dirName);

		int i = findDepth(newPath, array, Paths.get(dirName).getFileName());

		return i;

	}

	public int findDepth(String path, List<Integer> array1, Path p) {

		int max = 0;
		String REGEX = p.toString();
		Pattern pattern = Pattern.compile(REGEX);
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		};

		File root = new File(path);
		int len = root.listFiles().length;

		File[] list = root.listFiles();
		for (File l : list) {

			if (l.isDirectory()) {
				findDepth(l.getAbsolutePath(), array1, p);

				try {

					// String newarr[]=l.getCanonicalPath().split("\\\\");
					//

					String[] oldarr = pattern.split(l.getCanonicalPath());
					int c = oldarr.length;
					String arr[] = oldarr[c - 1].split("\\\\");
					for (int i = 0; i < arr.length; i++) {
						// System.out.println(arr[i]);

					}
					// System.out.println(arr.length);
					array1.add(arr.length);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// count++;
			}

		}

		Iterator<Integer> myListIterator = array1.iterator();
		while (myListIterator.hasNext()) {

			Integer val = myListIterator.next();

			if (val > max) {
				max = val;
				// System.out.println("Max" + max);

			}

		}

		return (max);

	}

}