package in3.a13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import in3.a13.gui.ctrl.AmpelSteuerung;

public class LightsGridLayoutButtons extends JPanel{
	private static final long serialVersionUID = 1L;
	final int LINE_MAX = 3;
	
	public LightsGridLayoutButtons(AmpelSteuerung as){
		setLayout(new GridLayout(LINE_MAX, 0));

		JButton b1 = new JButton("Next");
		b1.addActionListener(as);
		b1.setActionCommand(Command.NEXT_PHASE);
		add(b1);
		
		JButton b2 = new JButton("Stop");
		b2.addActionListener(as);
		b2.setActionCommand(Command.STOP_ALL);
		add(b2);
		
		JButton b3 = new JButton("Reset");
		b3.addActionListener(as);
		b3.setActionCommand(Command.RESET_ALL);
		add(b3);
	}
}
