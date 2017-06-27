package in3.a11;

import java.io.PrintWriter;
import java.util.Locale;

import lernhilfe2013ss.event.Timer;
import lernhilfe2013ws.graphics.DirtyPainter;

public class EventsTest {

	public static void main(String[] args) throws InterruptedException {
		final int NUMBER_OF_LIGHTS = 4;
		Locale.setDefault(Locale.US);
		
		DirtyPainter painter = new DirtyPainter();
		PrintWriter pw = new PrintWriter(System.out, true);
		ActionPrinter ap = new ActionPrinter(pw);
		
		AmpelModel ampeln[] = new AmpelModel[NUMBER_OF_LIGHTS];
		AmpelView ampel;
		
		//creating Model
		ampeln[0] = new AmpelModel(150, 150, Ampelphase.RED);
		ampeln[1] = new AmpelModel(300, 150, Ampelphase.RED_YELLOW);
		ampeln[2] = new AmpelModel(450, 150, Ampelphase.GREEN);
		ampeln[3] = new AmpelModel(600, 150, Ampelphase.YELLOW);

		//creating View
		for (int i = 0; i < ampeln.length; i++){
			ampel = new AmpelView(ampeln[i], painter);
			ampeln[i].addPropertyChangeListener(ampel);
			ampel.addPainter(painter);
		}
		AmpelSteuerung AmpelControl = new AmpelSteuerung(ampeln);
		
		painter.showDrawing();
		
		Timer switcher = new Timer(2000);
		switcher.addActionListener(AmpelControl);
		switcher.addActionListener(ap);
		switcher.setActionCommand(Command.NEXT_PHASE);
		
		Timer blocker = new Timer(3500);
		blocker.addActionListener(AmpelControl);
		blocker.addActionListener(ap);
		blocker.setActionCommand(Command.STOP_ALL);
		
		Timer resetter = new Timer(4500);
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
