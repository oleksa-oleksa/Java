package in3.a13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.PrintWriter;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import in3.a13.gui.ctrl.AmpelSteuerung;
import in3.a13.gui.model.AmpelModel;
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
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("<html>Berlin, U-Bahn Rathaus Stegltz</html>");
		label.setFont(new Font ("Serif", 50, 20));
		label.setForeground(Color.MAGENTA);
		
		container.add(label, BorderLayout.NORTH);
		container.add(new ButtonsAmpelnPanel(ampelControl), BorderLayout.CENTER);
		container.add(new JLabel("ver. a13"), BorderLayout.SOUTH);
		
		PrintWriter pw = new PrintWriter(System.out, true);
		ActionPrinter ap = new ActionPrinter(pw);
					
		startSwitcher(2000, ampelControl, ap);
		startBlocker(8000, ampelControl, ap);
		startResetter(6000, ampelControl, ap);
				
		//show
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
	
	public static void startSwitcher(int a, AmpelSteuerung ampelControl, ActionPrinter ap){
		Timer switcher = new Timer(a);
		switcher.addActionListener(ampelControl);
		switcher.addActionListener(ap);
		switcher.setActionCommand(Command.NEXT_PHASE);
		switcher.start();
	}
	
	public static void startBlocker(int a, AmpelSteuerung ampelControl, ActionPrinter ap){
		Timer blocker = new Timer(a);
		blocker.addActionListener(ampelControl);
		blocker.addActionListener(ap);
		blocker.setActionCommand(Command.STOP_ALL);
		blocker.start();
	}
	public static void startResetter(int a, AmpelSteuerung ampelControl, ActionPrinter ap){
		Timer resetter = new Timer(a);
		resetter.addActionListener(ampelControl);
		resetter.addActionListener(ap);
		resetter.setActionCommand(Command.RESET_ALL);
		resetter.start();
	}
}
	
