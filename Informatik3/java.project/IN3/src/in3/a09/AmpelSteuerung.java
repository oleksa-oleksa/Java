package in3.a09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmpelSteuerung implements ActionListener {

	public static final int NUMBER_OF_LIGHTS = 4;

	Ampel[] lights;

	AmpelSteuerung() {
		lights = new Ampel[NUMBER_OF_LIGHTS];
		for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
			lights[i] = new Ampel(150+i*Ampel.CIRCLE_RADIUS, 100);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Ampel a : lights) {
			a.toNextPhase();
		}
	}
	
	
	
}
