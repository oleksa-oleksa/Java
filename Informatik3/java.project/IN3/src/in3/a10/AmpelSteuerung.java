package in3.a10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import in3.a11.AmpelModel;

public class AmpelSteuerung implements ActionListener {

	public static final int NUMBER_OF_LIGHTS = 4;

	private AmpelModel[] lights;
	boolean is_stopped;

	AmpelSteuerung() {
		lights = new AmpelModel[NUMBER_OF_LIGHTS];
		for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
			lights[i] = new AmpelModel();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		
		if (cmd == Command.RESET_ALL) {
			is_stopped = false;
			for (AmpelModel a : lights) {
				a.resetCycle();
			}
		} else if (cmd == Command.STOP_ALL) {
			is_stopped = true;
			for (AmpelModel a : lights) {
				a.forceRedLight();
			}
		} else if (cmd == Command.NEXT_PHASE && !is_stopped) {
			for (AmpelModel a : lights) {
				a.toNextPhase();
			}
		}
	}	
	
	
}
