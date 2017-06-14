package in3.a10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmpelSteuerung implements ActionListener {

	public static final int NUMBER_OF_LIGHTS = 4;

	Ampel[] lights;
	boolean is_stopped;

	AmpelSteuerung() {
		lights = new Ampel[NUMBER_OF_LIGHTS];
		for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
			lights[i] = new Ampel(150+i*Ampel.CIRCLE_RADIUS, 100);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		
		if (cmd == Command.RESET_ALL) {
			is_stopped = false;
			for (Ampel a : lights) {
				a.resetCycle();
			}
		} else if (cmd == Command.STOP_ALL) {
			is_stopped = true;
			for (Ampel a : lights) {
				a.forceRedLight();
			}
		} else if (cmd == Command.NEXT_PHASE && !is_stopped) {
			for (Ampel a : lights) {
				a.toNextPhase();
			}
		}
	}	
	
	
}
