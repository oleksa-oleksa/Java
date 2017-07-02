package in3.examTraining;

import java.io.PrintWriter;

public class PrintTextTestClass {

	public static void main(String[] args) {
		
		PrintWriter out = new PrintWriter(System.out, true);
		
		// testcases
		printText("Hello my beautiful Java Program", 50, out);
		printText("Hello my beautiful Java Program", 4, out);
		printText("Hello my beautiful Java Program", 2, out);
		printText("Hello my beautiful Java Program", 10, out);
	}
	
	// solution using substring-Method from java.lang.String
	public static void printText(String text, int max, PrintWriter out){
		
		if (text.length() <= max || max <= 3){
			out.println(text);
		}
		else {
			out.printf("%s ..%n", text.substring(0, max-3));
		}
	}

}
