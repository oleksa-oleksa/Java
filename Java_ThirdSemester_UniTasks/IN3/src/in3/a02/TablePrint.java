package in3.a02;

import java.io.PrintWriter;

public class TablePrint {

	public static void main(String[] args) {
		// TODO printTable
		// TODO printHeader
		// TODO printBody
		// TODO printLine
		
		printTable(-1.0, 0.20, 15);
	}

	
	public static double f (double x) {
		
		double y = (x -  17) * (x + 12) / (x * x + 0.1);
		return y;
	}
	
	
	public static double g (double x) {
		
		double y = x * Math.sin(x);
		return y;
	}
	
	
	// calls others functions to draw a beautiful table
	public static void printTable(double xMin, double xMax, int width){
		
		printHeader(width);
		printBody(xMin, xMax, width);
		
		}
	
	protected static void printHeader(int width){
		
		PrintWriter out = new PrintWriter(System.out, true);
		
		out.printf("%29s%29s%29s\n", "x", "f(x)", "g(x)");
		}
	
	protected static void printBody(double xMin, double xMax, int width){
		
		printSign(45, '-');
		for (double i = xMin; i <= xMax; i += 0.1) {
			printLine(i, width);
		}
		printSign(45, '-');
		
	}
	
	protected static void printLine(double x, int width){
		double xF, xG;
		xF = f(x);
		xG = g(x);
		System.out.printf("%29.2f%29.7f%29.7f\n", x, xF, xG);
		}
	
	// separate function to print horizontal line of selected sign with white spaces
	protected static void printSign(int n, char c){
		for (int i = 0; i < n - 1; i++) {
		System.out.printf("%c ", c);	
		}
		System.out.println();
		
	}
	
}
