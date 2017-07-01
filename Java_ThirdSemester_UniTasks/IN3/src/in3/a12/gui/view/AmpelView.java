package in3.a12.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import in3.a10.Ampelphase;
import in3.a12.gui.model.AmpelModel;

public class AmpelView extends JPanel implements PropertyChangeListener  {
	
	private static final long serialVersionUID = 1;

	protected int x;
	protected int y;
	protected String phase;
	
	public AmpelView(AmpelModel m){
		this.x = m.getX();
		this.y = m.getY();
		this.phase = m.getPhase();
	}
	
	public AmpelView(AmpelView other){
		this.x = other.x;
		this.y = other.y;
		this.phase = other.phase;
	}
	
	
	public String toString(){
		String s = "State is " + phase + ", position is (" + x + ", " + y + ").";
		return s;
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x-4, y-4, 58, 158);
		drawLighterCircle(x, y, phase, g);
	}
	
	public void drawLighterCircle(int x, int y, String phase, Graphics g){
		switch(phase){
		// draw one lighter with set coordinates and only red color turned on
		case Ampelphase.RED:
			g.setColor(Color.RED);
			g.fillOval(x, y, 50, 50);
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, y+50, 50, 50);
			g.fillOval(x, y+100, 50, 50);
			break;
		
		//rest uses the same algorithm
		case Ampelphase.RED_YELLOW:
			g.setColor(Color.RED);
			g.fillOval(x, y, 50, 50);
			g.setColor(Color.YELLOW);
			g.fillOval(x, y+50, 50, 50);
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, y+100, 50, 50);
			break;
			
		case Ampelphase.YELLOW:
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, y, 50, 50);
			g.setColor(Color.YELLOW);
			g.fillOval(x, y+50, 50, 50);
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, y+100, 50, 50);
			break;
			
		case Ampelphase.GREEN:
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, y, 50, 50);
			g.fillOval(x, y+50, 50, 50);
			g.setColor(Color.GREEN);
			g.fillOval(x, y+100, 50, 50);
			break;
			
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName() == AmpelModel.PROPERTY_CHANGE_EVENT_NAME) {
			phase = (String) e.getNewValue();
			repaint();
		}
	}

	
	

}
