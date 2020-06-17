/*
 * File: TableLayoutExample.java
 * -----------------------------
 * This file illustrates the TableLayout manager.
 */

import acm.gui.*;
import acm.program.*;
import javax.swing.*;

/**
 * This program illustrates the operation of the TableLayout manager
 * by adding six buttons to the program window.
 */
public class TableLayoutExample extends Program {

	public void init() {
		setLayout(new TableLayout(2, 3));
		add(new JButton("Button 1"));
		add(new JButton("Button 2"));
		add(new JButton("Button 3"));
		add(new JButton("Button 4"));
		add(new JButton("Button 5"));
		add(new JButton("Button 6"));
	}

/* Define the dimensions of the window */
	public static final int APPLICATION_WIDTH = 300;
	public static final int APPLICATION_HEIGHT = 100;

}
