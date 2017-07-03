package in3.a13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import in3.a13.gui.ctrl.AmpelSteuerung;
import in3.a13.gui.model.AmpelModel;

public class ManualControlTest {

	final static int NUMBER_OF_LIGHTS = 4;

	public static void main(String[] args) {
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
		label.setText("<html>Berlin, Wedding, U-Bahn Amrumer Strasse</html>");
		label.setFont(new Font ("Serif", 50, 20));
		label.setForeground(Color.BLUE);
		
		container.add(label, BorderLayout.NORTH);
		container.add(new LightsGridLayout(ampelControl), BorderLayout.CENTER);
		container.add(new JLabel("ver. a13"), BorderLayout.SOUTH);
				
		//show
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}

}
