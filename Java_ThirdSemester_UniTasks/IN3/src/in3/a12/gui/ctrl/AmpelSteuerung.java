package in3.a12.gui.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import in3.a12.Command;
import in3.a12.gui.model.AmpelModel;

public class AmpelSteuerung implements ActionListener {
	
	private AmpelModel[] model;
	private boolean is_stopped;

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
