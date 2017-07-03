package in3.a13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.PrintWriter;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;

import in3.a13.gui.ctrl.AmpelSteuerung;
import in3.a13.gui.model.AmpelModel;
import in3.a13.gui.view.AmpelView;
import lernhilfe2013ss.event.Timer;

public class EventsTest {
	final static int NUMBER_OF_LIGHTS = 4;

	public static void main(String[] args) throws InterruptedException {
		Locale.setDefault(Locale.US);
		
		JFrame frame = new JFrame("Traffic light Control Panel");
		Container container = frame.getContentPane(); // top-level container
		
		AmpelModel ampeln[] = new AmpelModel[NUMBER_OF_LIGHTS];
		ampeln[0] = new AmpelModel(50, 50, Ampelphase.RED);
		ampeln[1] = new AmpelModel(50, 50, Ampelphase.RED_YELLOW);
		ampeln[2] = new AmpelModel(50, 50, Ampelphase.GREEN);
		ampeln[3] = new AmpelModel(50, 50, Ampelphase.YELLOW);

		AmpelSteuerung ampelControl = new AmpelSteuerung(ampeln);
		
		
		//Layout and container hierarchy
		container.setLayout(new BorderLayout());
		container.add(new JLabel("Ampeln in Berlin"), BorderLayout.NORTH);
		container.add(new LightsGridLayout(ampelControl), BorderLayout.CENTER);
		container.add(new JLabel("ver. a13"), BorderLayout.SOUTH);
		
		PrintWriter pw = new PrintWriter(System.out, true);
		ActionPrinter ap = new ActionPrinter(pw);
		
		Timer switcher = new Timer(2000, 1000);
		switcher.addActionListener(ampelControl);
		switcher.addActionListener(ap);
		switcher.setActionCommand(Command.NEXT_PHASE);
		switcher.start();
			
		Timer blocker = new Timer(3500);
		blocker.addActionListener(ampelControl);
		blocker.addActionListener(ap);
		blocker.setActionCommand(Command.STOP_ALL);
		blocker.start();
		
		Timer resetter = new Timer(4500, 6000);
		resetter.addActionListener(ampelControl);
		resetter.addActionListener(ap);
		resetter.setActionCommand(Command.RESET_ALL);
		resetter.start();
		
		//show
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}

}
