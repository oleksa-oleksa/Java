package in3.a03;
import java.io.PrintWriter;
import java.io.File;
import java.util.Arrays;

// TODO static void test(File[] paths);
// TODO public static void printAll(File path);
// TODO public static void printAll(String path);
// TODO public static void printFilesOnly(File path);
// TODO public static void printDirsOnly(File path);

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
	
	// Method with the same name 
	// could be used if the method call will be made
	// with a String instead the File
	public static void printAll(String path) {
		printAll(new File("path"));
	}
	
	public static void printFilesOnly(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		File listOfSortedData[] = getSortedFileList(path);
		
		// goes through array in alphabetic order
		// and checks whether the current item is a file 
		// by success prints the file information
		for (int i = 0; i < listOfSortedData.length; i++) {
			if(listOfSortedData[i].isFile()){
				out.println("Datei                " + listOfSortedData[i].getName());
			}
		}
	}
	
	
	public static void printDirsOnly(File path) {
		PrintWriter out = new PrintWriter(System.out, true);
		File listOfSortedData[] = getSortedFileList(path);

		// goes through array in alphabetic order
		// and checks whether the current item is a directory 
		// by success prints the file information
		for (int i = 0; i < listOfSortedData.length; i++) {
			if(listOfSortedData[i].isDirectory()){
				out.println("Unterverzeichnis     " + listOfSortedData[i].getName());
			}
		}
	}
	
	public static File[] getSortedFileList(File path){
		File listOfData[] = path.listFiles();
		Arrays.sort(listOfData);
		return listOfData;
	}
}
