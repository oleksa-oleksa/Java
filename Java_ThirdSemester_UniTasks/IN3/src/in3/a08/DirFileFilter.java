package in3.a08;

import java.io.File;
import java.io.FileFilter;

public class DirFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.isDirectory();
	}
	

}
