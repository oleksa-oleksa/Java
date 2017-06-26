package in3.a11;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import in3.a10.Ampelphase;
import lernhilfe2013ws.graphics.DirtyPainter;
import lernhilfe2013ws.graphics.Drawable;
import lernhilfe2013ws.graphics.Oval;
import lernhilfe2013ws.graphics.Point;

public class AmpelView implements Drawable, PropertyChangeListener {
	public static final int CIRCLE_RADIUS = 50;

	private int x;
	private int y;
	private AmpelModel model;
	private DirtyPainter dp;
	
	public AmpelView(DirtyPainter dp, AmpelModel m, int x, int y){
		this.model = m;
		this.dp = dp;
		this.x = x;
		this.y = y;
	}
	
	public AmpelView(DirtyPainter dp, AmpelView other){
		this.model = other.model;
		this.dp = dp;
		this.x = other.x;
		this.y = other.y;
	}
	
	public String toString(){
		String s = "State is " + model.getPhase() + ", position is (" + x + ", " + y + ").";
		return s;
	}
	
	@Override
	public void draw(Graphics g){
		int spot_y = y;
		String phase = model.getPhase();
		
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

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName() == AmpelModel.PROPERTY_CHANGE_EVENT_NAME) {
			dp.repaint();
		}
	}
	

}
