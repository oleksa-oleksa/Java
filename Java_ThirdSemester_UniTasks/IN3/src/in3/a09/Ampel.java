package in3.a09;

import java.awt.Color;
import java.awt.Graphics;

import lernhilfe2013ws.graphics.Drawable;
import lernhilfe2013ws.graphics.Oval;
import lernhilfe2013ws.graphics.Point;

public class Ampel implements Drawable {
	String phase;
	int x, y;
	
	public static final int CIRCLE_RADIUS = 50;
	
	public Ampel(int x, int y){
		this.x = x;
		this.y = y;
		phase = Ampelphase.RED;
	}
	
	public Ampel(int x, int y, String phase){
		this.phase = phase;
		this.x = x;
		this.y = y;
	}
	
	public Ampel(Ampel other){
		this.x = other.x;
		this.y = other.y;
		this.phase = other.phase;
	}
	
	public String toString(){
		String s = "The colour is " + phase + " and position is (" + x + ", " + y + ").";
		return s;
	}
	
	public void toNextPhase(){
		switch (phase) {
		 case Ampelphase.RED: 
			 					phase = Ampelphase.RED_YELLOW;
			 					break;
		 case Ampelphase.RED_YELLOW:
			 					phase = Ampelphase.GREEN;
			 					break;
		 case Ampelphase.GREEN: 
			 					phase = Ampelphase.YELLOW;
			  					break;
		 case Ampelphase.YELLOW:
			 					phase = Ampelphase.RED;
			 					break;
		}
	}
	
	@Override
	public void draw(Graphics g){
		int spot_y = y;
		
		Point p = new Point(x, spot_y);
		Oval red = new Oval(p, CIRCLE_RADIUS, CIRCLE_RADIUS);
		if (phase == Ampelphase.RED || phase == Ampelphase.RED_YELLOW) {
			red.setColor(Color.RED);
		} else {
			red.setColor(Color.BLACK);
		}
		red.draw(g);
		
		spot_y += CIRCLE_RADIUS;
		p = new Point(x, spot_y);
		Oval yellow = new Oval(p, CIRCLE_RADIUS, CIRCLE_RADIUS);
		
		if (phase == Ampelphase.YELLOW || phase == Ampelphase.RED_YELLOW) {
			yellow.setColor(Color.YELLOW);
		} else {
			yellow.setColor(Color.BLACK);
		}
		yellow.draw(g);
		
		
		spot_y += CIRCLE_RADIUS;
		p = new Point(x, spot_y);
		Oval green = new Oval(p, CIRCLE_RADIUS, CIRCLE_RADIUS); 
		if (phase == Ampelphase.GREEN) {
			green.setColor(Color.GREEN);
		} else {
			green.setColor(Color.BLACK);
		}
		green.draw(g);
	}
	

}
