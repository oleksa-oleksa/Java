package in3.a05;

import java.io.PrintWriter;
import java.util.Locale;

import lernhilfe2013ws.io.ConsolePrinter;
import lernhilfe2013ws.io.DirtyFileWriter;

public class FirstIO {
	
	public static final int MAX_NUMBER = 1001;
	public static final int MAX_COLUMNS = 10;
	
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		ConsolePrinter con = ConsolePrinter.createInstance();
		PrintWriter out = new PrintWriter(con, true);
		String intName = "./testfiles/integers.txt";
		String doubleName = "./testfiles/mixedNo.txt";
		
		
		writeRandomIntNumbersTo(31, 10, out);
		writeRandomMixedNumbersTo(28, 10, out);
		writeRandomIntNumbersTo(50, 10, intName);
		writeRandomMixedNumbersTo(83, 12, doubleName);
	}

	public static void writeIntNumbers(int numberCount, int width, PrintWriter out){
		String format = "%" + String.valueOf(width)+"d";
		
		for(int i = 1; i <= numberCount; i++){
			int x = (int) Math.floor(Math.random() * MAX_NUMBER);
			out.printf(format, x);
			if (i % MAX_COLUMNS == 0){
				out.printf("%n");
			}
		}
		out.printf("%n"); // separator
		
	}
	
	public static void writeMixedNumbers(int numberCount, int width, PrintWriter out) {		

		String intFormat = "%" + String.valueOf(width)+"d";
		String doubleFormat = "%" + String.valueOf(width)+".2f";
		
		for(int i = 1; i <= numberCount; i++){
			
			// prints integer
			if(Math.random() < 0.5)
			{
				int xd = (int) Math.floor(Math.random() * MAX_NUMBER);
				out.printf(intFormat, xd);
				if (i % MAX_COLUMNS == 0){
					out.printf("%n");
				}
			} else {
				double xf = Math.floor(Math.random() * MAX_NUMBER);
				out.printf(doubleFormat, xf);
				if (i % MAX_COLUMNS == 0){
					out.printf("%n");
				}
			}
		} 
		out.printf("%n"); // separator
	}
	
	public static void writeRandomIntNumbersTo(int numberCount, int width, PrintWriter out){
		
		if (numberCount % 2 != 0){
			numberCount--;
		}
		
		writeIntNumbers(numberCount, width, out);
	}
	
	public static void writeRandomMixedNumbersTo(int numberCount, int width, PrintWriter out){

		if (numberCount % 2 != 0){
			numberCount--;
		}

		writeMixedNumbers(numberCount, width, out);
	}
	
	public static void writeRandomIntNumbersTo(int numberCount, int width, String filename){
		DirtyFileWriter dfw = new DirtyFileWriter(filename);
		PrintWriter fout = new PrintWriter(dfw, true);
			
		writeIntNumbers(numberCount, width, fout);
		fout.close();
		dfw.close();
	}
	
	public static void writeRandomMixedNumbersTo(int numberCount, int width, String filename){
		
		DirtyFileWriter dfw = new DirtyFileWriter(filename);
		PrintWriter fout = new PrintWriter(dfw, true);
		
		writeMixedNumbers(numberCount, width, fout);
		fout.close();
		dfw.close();
	}
	
	
}
