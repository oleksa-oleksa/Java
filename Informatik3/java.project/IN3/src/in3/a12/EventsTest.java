package in3.a12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.PrintWriter;
import java.util.Locale;

import javax.swing.JFrame;

import in3.a12.gui.ctrl.AmpelSteuerung;
import in3.a12.gui.model.AmpelModel;
import in3.a12.gui.view.AmpelView;
import lernhilfe2013ss.event.Timer;

public class EventsTest {

	public static void main(String[] args) throws InterruptedException {
		final int NUMBER_OF_LIGHTS = 4;
		Locale.setDefault(Locale.US);
		
		JFrame frame = new JFrame("Traffic light");
		Container c = frame.getContentPane(); // top-level container
		
		//Layout and container hierarchy
		c.setLayout (new BorderLayout ());
		
		PrintWriter pw = new PrintWriter(System.out, true);
		ActionPrinter ap = new ActionPrinter(pw);
		
		AmpelModel ampeln[] = new AmpelModel[NUMBER_OF_LIGHTS];
		
		//creating Model
		ampeln[0] = new AmpelModel(150, 150, Ampelphase.RED);
		ampeln[1] = new AmpelModel(300, 150, Ampelphase.RED_YELLOW);
		ampeln[2] = new AmpelModel(450, 150, Ampelphase.GREEN);
		ampeln[3] = new AmpelModel(600, 150, Ampelphase.YELLOW);

		//creating View
		for (int i = 0; i < ampeln.length; i++){
			AmpelView ampel = new AmpelView(ampeln[i]);
			ampeln[i].addPropertyChangeListener(ampel);
			c.add(ampel);
		}
		
		//show frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 450);
		frame.setVisible(true);
		
		AmpelSteuerung AmpelControl = new AmpelSteuerung(ampeln);
				
		Timer switcher = new Timer(2000, 1000);
		switcher.addActionListener(AmpelControl);
		switcher.addActionListener(ap);
		switcher.setActionCommand(Command.NEXT_PHASE);
		

		
		Timer blocker = new Timer(3500);
		blocker.addActionListener(AmpelControl);
		blocker.addActionListener(ap);
		blocker.setActionCommand(Command.STOP_ALL);
		
		Timer resetter = new Timer(4500, 6000);
		resetter.addActionListener(AmpelControl);
		resetter.addActionListener(ap);
		resetter.setActionCommand(Command.RESET_ALL);
		
		switch(switcher.getActionCommand()) {
		case(Command.NEXT_PHASE):
			switcher.start();
			blocker.start();
			resetter.start();
			break;
		case(Command.PREV_PHASE):
			switcher.start();
			blocker.start();
			resetter.start();
			break;
		case(Command.STOP_ALL):
			switcher.start();
			blocker.start();
			resetter.start();
			break;
		case(Command.RESET_ALL):
			switcher.start();
			blocker.start();
			resetter.start();
			break;
	
		}
	}

}
