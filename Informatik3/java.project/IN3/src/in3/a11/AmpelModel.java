package in3.a11;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AmpelModel{
	public static final String PROPERTY_CHANGE_EVENT_NAME = "AMPEL_MODEL_UPDATED";

	private int x;
	private int y;
	private String phase;
	private String initial_phase;
	private PropertyChangeSupport pcs;
	
	public AmpelModel(int x, int y, String phase){
		this.x = x;
		this.y = y;
		this.phase = Ampelphase.RED;
		initial_phase = phase;
		pcs = new PropertyChangeSupport(this);
	}
	
	public AmpelModel(String phase){
		this.phase = phase;
		this.initial_phase = phase;
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public AmpelModel(AmpelModel other){
		this.phase = other.phase;
		this.initial_phase = other.initial_phase;
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public String getPhase(){
		return phase;
	}
	
	public void setPhase (String phase){
		this.phase = phase;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX (int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public String toString(){
		String s = "The colour is " + phase;
		return s;
	}
	
	public void resetCycle() {
		String old_phase = phase;
		phase = initial_phase;
		pcs.firePropertyChange(PROPERTY_CHANGE_EVENT_NAME, old_phase, phase);
	}
	
	public void forceRedLight(){
		String old_phase = phase;
		phase = Ampelphase.RED;
		pcs.firePropertyChange(PROPERTY_CHANGE_EVENT_NAME, old_phase, phase);

	}
	
	public void toNextPhase(){
		String old_phase = phase;
		
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
		if (phase != old_phase) {
			pcs.firePropertyChange(PROPERTY_CHANGE_EVENT_NAME, old_phase, phase);
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(l);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(l);
	}
	
	
}
