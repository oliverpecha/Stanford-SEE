/*
 * File: TemperatureConverter.java
 * -------------------------------
 * This program allows users to convert temperatures
 * back and forth from Fahrenheit to Celsius.
 */

import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter extends Program {

/** Initialize the graphical user interface */
	public void init() {
		setSize(300,200);
		setLayout(new TableLayout(2, 3));
		
		add(new JLabel("Degrees Fahrenheit"));
		add(new JButton("F -> C"));
		add(new JLabel("Degrees Celsius"));
		add(new JButton("C -> F"));
		addActionListeners();
	}

/** Listen for a button action */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("F -> C")) {
			int f = fahrenheitField.getValue();
			int c = (int) Math.round( (5.0 / 9.0) * (f - 32) );
			celsiusField.setValue(c);
		} else if (cmd.equals("C -> F")) {
			int c = celsiusField.getValue();
			int f = (int) Math.round( (9.0 / 5.0) * c + 32 );
			fahrenheitField.setValue(f);
		}
	}

/* Private instance variables */
	private IntField fahrenheitField;
	private IntField celsiusField;

/** Set the program dimensions */
	public static final int APPLICATION_WIDTH = 300;
	public static final int APPLICATION_HEIGHT = 200;

}
