package in3.a13;

import java.awt.GridLayout;

import javax.swing.JPanel;

import in3.a13.gui.LightsGridLayoutAmpeln;
import in3.a13.gui.ctrl.AmpelSteuerung;

public class LightsGridLayout extends JPanel{
	private static final long serialVersionUID = 1L;
	public LightsGridLayout(AmpelSteuerung s){
		setLayout(new GridLayout(2, 1));
		add(new LightsGridLayoutAmpeln(s.getAmpeln()));
		add(new LightsGridLayoutButtons());
	}
}
