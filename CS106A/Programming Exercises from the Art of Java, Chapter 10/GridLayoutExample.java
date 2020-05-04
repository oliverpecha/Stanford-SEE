/*
 * File: GridLayoutExample.java
 * ----------------------------
 * This file illustrates the GridLayout manager.
 */

import acm.program.*;
import java.awt.*;
import javax.swing.*;

/**
 * This program illustrates the operation of the GridLayout manager
 * by adding six buttons to the program window.
 */
public class GridLayoutExample extends Program {

	public void init() {
		setLayout(new GridLayout(2, 3));
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
