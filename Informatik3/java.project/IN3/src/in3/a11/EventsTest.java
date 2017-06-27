package in3.a11;

import java.io.PrintWriter;
import lernhilfe2013ss.event.Timer;

public class EventsTest {

	public static void main(String[] args) throws InterruptedException {

		PrintWriter pw = new PrintWriter(System.out, true);
		
		ActionPrinter ap = new ActionPrinter(pw);
		AmpelSteuerung AmpelControl = new AmpelSteuerung();
		
		Timer switcher = new Timer(1000);
		switcher.addActionListener(AmpelControl);
		switcher.addActionListener(ap);
		switcher.setActionCommand(Command.NEXT_PHASE);
		
		Timer blocker = new Timer(1200);
		blocker.addActionListener(AmpelControl);
		blocker.addActionListener(ap);
		blocker.setActionCommand(Command.STOP_ALL);
		
		Timer resetter = new Timer(1400);
		resetter.addActionListener(AmpelControl);
		resetter.addActionListener(ap);
		resetter.setActionCommand(Command.RESET_ALL);
		
		switcher.start();
		blocker.start();
		resetter.start();
		
		// wait 10 seconds to see timer
		Thread.sleep(10000);
		switcher.stop();
		blocker.stop();
		resetter.stop();

	}

}
