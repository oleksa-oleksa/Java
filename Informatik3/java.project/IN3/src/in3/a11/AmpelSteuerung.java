package in3.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import in3.a10.Ampel;

public class AmpelSteuerung implements ActionListener {

	public static final int NUMBER_OF_LIGHTS = 4;

	private AmpelModel[] lights;
	private boolean is_stopped;

	public AmpelSteuerung() {
		lights = new AmpelModel[NUMBER_OF_LIGHTS];
		for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
			lights[i] = new AmpelView(150+i*AmpelView.CIRCLE_RADIUS, 100);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		
		if (cmd == Command.RESET_ALL) {
			for (AmpelModel a : lights) {
				a.resetCycle();
			}
			is_stopped = false;
		} else if (cmd.equals(Command.STOP_ALL)) {
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
