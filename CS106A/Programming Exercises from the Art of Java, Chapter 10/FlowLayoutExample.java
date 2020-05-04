/*
 * File: FlowLayoutExample.java
 * ----------------------------
 * This file illustrates the FlowLayout manager.
 */

import acm.program.*;
import java.awt.*;
import javax.swing.*;

/**
 * This program illustrates the operation of the FlowLayout manager
 * by adding six buttons to the program window.
 */
public class FlowLayoutExample extends Program {

	public void init() {
		setLayout(new FlowLayout());
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
