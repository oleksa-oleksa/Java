package easyProblemAlgorithm;
//Write a Java program to display the speed, in meters per second, kilometers per hour and miles per hour.
//User Input : Distance (in meters) and the time was taken (as three numbers: hours, minutes, seconds).
//Note : 1 mile = 1609 meters

import java.io.PrintWriter;
import java.util.Scanner;

public class ShowSpeed {
	public static void main(String[] args) {
		
		PrintWriter out = new PrintWriter(System.out, true);
		Scanner in = new Scanner(System.in);
		double timeInSeconds, mps, kph, mileph;
		
		out.println("Please input distance in meters: ");
		double distance = in.nextDouble();
		out.println("Input the time was taken. Hour:");
		double h = in.nextDouble();
		out.println("Minutes:");
		double m = in.nextDouble();
		out.println("Seconds:");
		double s = in.nextDouble();
		
		// calculating the total time in seconds
		timeInSeconds = h*3600 + m*60 + s;
		mps = distance / timeInSeconds;
		kph = (distance / 1000.0f) / (timeInSeconds / 3600.0f);
		mileph = kph / 1.609f;
		
		out.println("Your speed in meters per second is " + mps);
		out.println("This is equal to a speed " + kph + " km/h");
		out.println("Obwohl wir nicht in den USA sind, vieleicht ist das auch interessant. "
				+ "Deine Geschwindigkeit ist " + mileph + " miles/h");
		in.close();
	}
}