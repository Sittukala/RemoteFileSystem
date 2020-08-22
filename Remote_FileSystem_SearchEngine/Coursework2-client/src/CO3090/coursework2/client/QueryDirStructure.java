package CO3090.coursework2.client;

import CO3090.coursework2.shared.*;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Vector;

public class QueryDirStructure implements Query {
	String dirstr = "";
	String dirName = "";
	static String root_path_str = "C:\\Distributed\\CW2\\DemoFolders\\";

	public QueryDirStructure(String dirName) {
		super();
		this.dirName = dirName;
	}

	/**
	 * 
	 * Q (2.4) implement the abstract methods you defined in Query.java
	 * 
	 * A query of this type should return all sub-folders (including nesting
	 * folders) as a string formatted according to the specified format:
	 * 
	 * For example:
	 * 
	 * QueryDirStructure q3=new QueryDirectoryStructure (â€œ/Aâ€�)
	 * FileSystemServer should return â€œA{B,C{D,E{F}}}â€�
	 * 
	 * QueryDirStructure q4=new QueryDirectoryStructure (â€œ/A/Bâ€�)
	 * FileSystemServer should return â€œBâ€�.
	 * 
	 * QueryDirStructure q5=new QueryDirectoryStructure (â€œ/A/Câ€�)
	 * FileSystemServer should return â€œC{D,E{F}}â€�
	 * 
	 * 
	 * [Hints: traverse directory recursively ]
	 * 
	 */

	public Object execute() {
		Path parent = Paths.get(dirName).getFileName();
		String newPath = root_path_str.concat(dirName);

		dirstr = dirstr + parent;

		String structure = findstructure(newPath);
		return structure;
	}

	public String findstructure(String path) {
		int depth = 1;

		File root = new File(path);
		File[] list = root.listFiles();
		// System.out.print(root.getName() + "{");
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		};

		for (File l : list) {

			if (l.isDirectory()) {
				dirstr = dirstr + l.getName() + ",";
				if (l.listFiles(filter).length > 0) {
					dirstr = dirstr + "{";
					depth++;
					findstructure(l.getAbsolutePath());
					dirstr = dirstr + "}";

				}
			}
		}
		return dirstr;
	}
}