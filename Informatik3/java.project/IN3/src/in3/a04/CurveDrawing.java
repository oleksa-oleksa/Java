package in3.a04;

import lernhilfe2013ws.graphics.DirtyPainter;
import lernhilfe2013ws.graphics.Point;


public class CurveDrawing {

	public static void main(String[] args) {
		// TODO public static void paintSinusCurve(double x0, double y0, double a, double f)
		// TODO public static void paintDampedSinusCurve(double x0, double y0, double a, double f, double d)
		
		paintSinusCurve(0.00, 200, 50.0, 200);
		paintDampedSinusCurve(0.00, 200, 50.0, 200, 5);
	}
	
	public static void paintSinusCurve(double x0, double y0, double a, double f){
		DirtyPainter paintOut = new DirtyPainter();
		 for (int x = 0; x <= 1000; x += 4){
			  int y = (int) (a * Math.sin(f * x + x0) + y0);
			  
			  Point sinNode= new Point(x,y);
			  paintOut.add(sinNode);
			  paintOut.showDrawing();
		 }
	}
	
	public static void paintDampedSinusCurve(double x0, double y0, double a, double f, double d){
		DirtyPainter paintOut = new DirtyPainter();
		 for (int x = 0; x <= 1000; x += 4){
			 int ax = (int) (a * Math.exp(-d*x));
			 int y = (int) (ax * Math.sin(f * x + x0) + y0);
			  
			  Point sinNode= new Point(x,y);
			  paintOut.add(sinNode);
			  paintOut.showDrawing();
		 }
	}

}
