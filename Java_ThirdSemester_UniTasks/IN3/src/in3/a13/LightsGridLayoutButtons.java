package in3.a13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LightsGridLayoutButtons extends JPanel{
	private static final long serialVersionUID = 1L;
	final int LINE_MAX = 4;
	
	private JButton[] buttons = new JButton[LINE_MAX];
	
	public LightsGridLayoutButtons(){
		buttons[0] = new JButton("Next");
		buttons[1] = new JButton("Stop");
		buttons[2] = new JButton("Reset");;
		buttons[3] = new JButton("Change mode");;
		
		setLayout(new GridLayout(LINE_MAX, 0));
        // add JButtons dynamically
		for (int line = 0; line < LINE_MAX; line++){
			add(buttons[line]);
		}
	}
}
