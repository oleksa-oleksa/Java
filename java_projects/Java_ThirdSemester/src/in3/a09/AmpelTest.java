package in3.a09;

import lernhilfe2013ss.event.Timer;
import lernhilfe2013ws.graphics.DirtyPainter;

public class AmpelTest {

	public static void main(String[] args) {
		DirtyPainter dp = new DirtyPainter();
		
		Ampel ampel1 = new Ampel(150, 100);
		ampel1.toNextPhase();
		dp.add(ampel1);
		
		Ampel ampel2 = new Ampel(250, 100);
		ampel2.toNextPhase(); 
		ampel2.toNextPhase();
		dp.add(ampel2);
		dp.showDrawing();
		
		AmpelSteuerung steuerung = new AmpelSteuerung();
		
		Timer timer = new Timer(1000);
		timer.addActionListener(steuerung);
		timer.start();
	}

}
