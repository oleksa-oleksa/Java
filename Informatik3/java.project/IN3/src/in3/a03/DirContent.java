package in3.a03;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.io.File;

// TODO static void test(File[] paths);
// TODO public static void printAll(File patch);
// TODO public static void printAll(String patch);
// TODO public static void printFilesOnly(File patch);
// TODO public static void printDirsOnly(File patch);

public class DirContent {
	
	// Main Program
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
	// First Method that we expect to work with
	public static void printAll(File patch) {
		PrintWriter out = new PrintWriter(System.out, true);
		
	}
	
	// Method with the same name just calls the same function with a correct parameter 
	public static void printAll(String patch) {
		
		printAll(new File("patch"));
	}
		
	
}
