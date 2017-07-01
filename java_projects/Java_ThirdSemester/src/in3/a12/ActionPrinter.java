package in3.a12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ActionPrinter implements ActionListener {
	private PrintWriter printer_writer;
	
	public ActionPrinter(PrintWriter pw) {
		printer_writer = pw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		printer_writer.format("%d ms: ActionEvent mit Command \"%s\"\n", e.getWhen(), e.getActionCommand());	
	}
	
	
}
