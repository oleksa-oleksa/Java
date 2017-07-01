package in3.a08;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class DirContent {
	
	public static void main(String[] args) {
		// test paths 
		File test1 = new File("C:\\ENGINEERING\\LERNPAKET");
		File test2 = new File("C:\\ENGINEERING\\ModelSim\\modelsim_ase");
		File test3 = new File("C:\\ENGINEERING\\Quartus\\uninstall");
		
		// test Array with the paths 
		File[] myPatches = {test1, test2, test3};
				
		test(myPatches);
	}
	 
	// Test Unit Call
	static void test(File[] paths) {
		for (int i = 0; i < paths.length; i++) {
			printAll(paths[i]);
		}
	}
	
	// Learning Method Overloading in Java
	// First Method that we expect to work with files
	public static void printAll(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Verzeichnis   " + path);
		printFilesOnly(path);
		printDirsOnly(path);
		out.printf("\n\n");
	}
	
	public static void printAll(String path) {
		printAll(new File("path"));
	}
	
	public static void printFilesOnly(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		File listOfSortedData[] = getSortedFileList(path, new FileFileFilter());
		
		for (File f : listOfSortedData) {
			out.println("Datei                " + f.getName());
		}
	}
	
	public static void printDirsOnly(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		File listOfSortedData[] = getSortedFileList(path, new DirFileFilter());

		for (File f : listOfSortedData) {
			out.println("Unterverzeichnis     " +f.getName());
		}
	}
	
	public static File[] getSortedFileList(File path, FileFilter filter){
		File listOfData[] = path.listFiles(filter);
		Arrays.sort(listOfData);
		return listOfData;
	}
}
