package in3.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lernhilfe2013ws.graphics.DirtyPainter;

public class AmpelSteuerung implements ActionListener {

	public static final int NUMBER_OF_LIGHTS = 4;

	private AmpelModel[] model;
	private AmpelView[] view;
	private boolean is_stopped;
	private DirtyPainter dp;

	public AmpelSteuerung(AmpelModel model[], AmpelView view[]) {
		this.model = new AmpelModel[NUMBER_OF_LIGHTS];
		this.view = new AmpelView[NUMBER_OF_LIGHTS];
		this.is_stopped = false;
		for (int i = 0; i < NUMBER_OF_LIGHTS; i++) {
			model[i] = new AmpelModel();
			view[i] = new AmpelView(dp, model[i], 150, y);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		
		if (cmd == Command.RESET_ALL) {
			for (AmpelModel a : model) {
				a.resetCycle();
			}
			is_stopped = false;
			
		} else if (cmd.equals(Command.STOP_ALL)) {
			for (AmpelModel a : model) {
				a.forceRedLight();
			}
			is_stopped = true;

		} else if (cmd == Command.NEXT_PHASE && !is_stopped) {
			for (AmpelModel a : model) {
				a.toNextPhase();
			}
		}
	}	
}
