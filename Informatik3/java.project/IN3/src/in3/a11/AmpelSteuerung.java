package in3.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lernhilfe2013ws.graphics.DirtyPainter;

public class AmpelSteuerung implements ActionListener {
	
	private AmpelModel[] model;
	private boolean is_stopped;
	private DirtyPainter dp;

	public AmpelSteuerung(AmpelModel model[]) {
		this.model = model;
		this.is_stopped = false;
		
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
