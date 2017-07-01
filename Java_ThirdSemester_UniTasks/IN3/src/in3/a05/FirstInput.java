package in3.a05;

import java.awt.Color;
import java.util.Locale;
import java.util.Scanner;

import lernhilfe2013ws.graphics.DirtyPainter;
import lernhilfe2013ws.graphics.Point;
import lernhilfe2013ws.io.ConsolePrinter;
import lernhilfe2013ws.io.DirtyFileReader;

public class FirstInput {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);		
		
		String numberString = "10 10   20 20   30 40.0 ";
		Scanner in = new Scanner(numberString);
		
		ConsolePrinter con = ConsolePrinter.createInstance();
		
		con.printf("Sum of numbers from string: %d%n", countSumOf(in));
		con.printf("Sum of numbers from a file: %d%n", countSumOf("./testfiles/mixedNo.txt"));
		
		paintPointsFrom(in);
		paintPointsFrom("./testfiles/mixedNo.txt");
	}


	public static int countSumOf(Scanner in) {
		int sum = 0;
		while (in.hasNextDouble())	{
			sum += (int) Math.floor(in.nextDouble());
		}
		
		return sum;
	}
	
	public static int countSumOf(String fileName) {
		DirtyFileReader dfr = new DirtyFileReader(fileName);
		Scanner s = new Scanner(dfr);
		int sum = countSumOf(s);
		s.close();
		return sum;
		
	}
	
	public static void paintPointsFrom(Scanner in) {
		DirtyPainter dp = new DirtyPainter();
	
		int x, y;
		boolean hasDouble;
		while (true) {
			hasDouble = false;
			
			if (in.hasNextInt()) {
				x = in.nextInt();
			} else if (in.hasNextDouble()) {
				x = (int)Math.floor(in.nextDouble());
				hasDouble = true;
			} else {
				break;
			}
			
			if (in.hasNextInt()) {
				y = in.nextInt();
			} else if (in.hasNextDouble()) {
				y = (int) Math.floor(in.nextDouble());
				hasDouble = true;
			} else {
				break;
			}
			
			Point myPoint = new Point(x, y);
			if (hasDouble) {
				myPoint.setColor(Color.green);				
			} else {
				myPoint.setColor(Color.blue);
			}
			dp.add(myPoint);
						
		}
		dp.showDrawing();			

	}
	
	public static void paintPointsFrom(String fileName) {
		DirtyFileReader dfr = new DirtyFileReader(fileName);
		Scanner in = new Scanner(dfr);
		paintPointsFrom(in);
	}
}
