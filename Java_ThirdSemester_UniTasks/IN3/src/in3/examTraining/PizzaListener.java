package in3.examTraining;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PizzaListener extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	protected JButton ordered;
	protected JButton prepared;
	protected JButton dispached;
	protected JButton delivered;
	protected JLabel label;
	protected JPanel panel;
	protected JFrame frame;
	
	public static void main(String[] args){
		//creating a new object of a class PizzaListener
		// making it be visible
		PizzaListener pizzaForEvening = new PizzaListener();
		pizzaForEvening.setVisible(true);
		
	}
	
	public PizzaListener(){
		this.ordered = new JButton("Order");
		this.prepared = new JButton("Prepare");
		this.dispached = new JButton("Sent");
		this.delivered = new JButton("Delivered and paid");
		this.panel = new JPanel();
		this.label = new JLabel();
		this.frame = new JFrame("Pizza Stegliz");
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(5, 1));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		frame.add(ordered).setLocation(1, 1);
		frame.add(prepared).setLocation(2, 1);
		frame.add(dispached).setLocation(3, 1);
		frame.add(delivered).setLocation(4, 1);
		frame.add(label).setLocation(5, 1);;


		// buttons get Listener
		ordered.addActionListener(this);
		prepared.addActionListener(this);
		dispached.addActionListener(this);
		delivered.addActionListener(this);		
		
		// adding buttons to a panel
		panel.add(ordered); // panel.add(button1);
		panel.add(prepared);
		panel.add(dispached);
		panel.add(delivered);
		
		// adding JLabel to a JPanel
		panel.add(label); // panel.add(label)
		frame.add(panel); // this.add(panel);
		frame.setVisible(true);
	}
		
	//Implementation of inherited abstract method
	// Invoked when an action occurs.
	public void actionPerformed(ActionEvent ae){
		label.setFont(new Font ("Serif", 50, 22));
		if(ae.getSource().equals(ordered)){
			label.setForeground(Color.RED);
			label.setText("<html><div style='text-align: center;'>Pizza is ordered!</html>");
		}
		if(ae.getSource().equals(prepared)){
			label.setForeground(Color.ORANGE);
			label.setText("<html><div style='text-align: center;'>Pizza is prepared!</html>");
		}
		if(ae.getSource().equals(dispached)){
			label.setForeground(Color.BLUE);
			label.setText("<html><div style='text-align: center;'>Pizza dispached!</html>");
		}
		if(ae.getSource().equals(delivered)){
			label.setForeground(Color.GREEN);
			label.setText("<html><div style='text-align: center;'>Delivered. <br>We got some profit, yahoo!</html>");
		}
	}
}
