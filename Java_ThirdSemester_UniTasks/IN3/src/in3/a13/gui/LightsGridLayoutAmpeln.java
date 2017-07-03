package in3.a13.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import in3.a13.gui.model.AmpelModel;
import in3.a13.gui.view.AmpelView;

public class LightsGridLayoutAmpeln extends JPanel{
	private static final long serialVersionUID = 1L;
	
	AmpelView ampelViews[];
	
	public LightsGridLayoutAmpeln(AmpelModel[] ampeln){	
		ampelViews = new AmpelView[ampeln.length];
		//creating views
		for (int i = 0; i < ampeln.length; i++){
			ampelViews[i] = new AmpelView(ampeln[i]);
			ampeln[i].addPropertyChangeListener(ampelViews[i]);
		}
	
		setLayout(new GridLayout(1, 0));
		
		// add Street Lights dynamically
		for (int view = 0; view < ampelViews.length; view++){
			add(ampelViews[view]);			
		}
	}
}