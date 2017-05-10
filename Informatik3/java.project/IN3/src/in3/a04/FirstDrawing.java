package in3.a04;

import java.awt.Color;

import lernhilfe2013ws.graphics.DirtyPainter;
import lernhilfe2013ws.graphics.Line;
import lernhilfe2013ws.graphics.Oval;
import lernhilfe2013ws.graphics.Point;

// TODO public static void paintSomePoints(int basicNumber)
// TODO public static void paintSomeLines(int dx, int dy)
// TODO public static void paintSomeOvals()

public class FirstDrawing {
	public static void main(String[] args){
		
		// Test case
		paintSomePoints(25);
		paintSomePoints(50);
		paintSomePoints(100);
		paintSomeLines(25, 100);
		paintSomeOvals();
	}
	
	public static void paintSomePoints(int basicNumber) {
		
		DirtyPainter paintOut = new DirtyPainter();
		
		
		//checks whether the parameters are correct coordinates
		if (basicNumber < 0 || basicNumber > 500){
			return;
		}
		

		for (int x = basicNumber; x <= 500; x += basicNumber ){
			for (int y = basicNumber; y <= 500; y += basicNumber ){
				Point myPoint = new Point(x, y);
				paintOut.add(myPoint);
				paintOut.showDrawing();
			}
		}
	}
	
	public static void paintSomeLines(int dx, int dy) {
		
		DirtyPainter paintOut = new DirtyPainter();
		
		for (int x = 0; x <= 500; x += dx){
			Point vPoint = new Point(x, 0);
			Point vBorder = new Point (x, 500);
			Line vLine = new Line (vPoint, vBorder);
			
			paintOut.add(vLine);
			paintOut.showDrawing();
		}
		
		for (int y = 0; y <= 500; y += dy) {
			Point hPoint = new Point(0, y);
			Point hBorder = new Point (500, y);
			Line hLine = new Line(hBorder, hPoint);
			
			paintOut.add(hLine);
			paintOut.showDrawing();
			
		}
		
	}

	public static void paintSomeOvals() {
		DirtyPainter paintOut = new DirtyPainter();
		
		int x = 1, y = 1, w = 1, h = 1;
		Color [] Palette = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta, Color.pink, Color.darkGray, Color.lightGray };
		
		for (int i = 0; i < 10; i++ ){
			// Random
			w = 1+(int)(Math.random()*200);
			h = 1+(int)(Math.random()*200);
			x = w/2+(int)(Math.random()*(500-w));
			y = h/2+(int)(Math.random()*(500-h));
			
			Point center = new Point(x, y);
			Oval myOval = new Oval(center, w, h);
			myOval.setColor(Palette[i]);
			
			paintOut.add(myOval);
			paintOut.showDrawing();
		}
	}
}
