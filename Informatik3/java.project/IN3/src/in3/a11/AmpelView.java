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

	protected int x;
	protected int y;
	protected String phase;
	private DirtyPainter dp;

	
	public AmpelView(AmpelModel m, DirtyPainter dp){
		this.x = m.getX();
		this.y = m.getY();
		this.phase = m.getPhase();
		this.dp = dp;
		
	}
	
	public AmpelView(AmpelView other, DirtyPainter dp){
		this.x = other.x;
		this.y = other.y;
		this.phase = other.phase;
		this.dp = dp;
	}
	
	public void addPainter(DirtyPainter painter){
		this.dp = painter;
		painter.add(this);
	}
	
	public String toString(){
		String s = "State is " + phase + ", position is (" + x + ", " + y + ").";
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
			phase = (String) e.getNewValue();
			dp.repaint();
		}
	}
	

}
