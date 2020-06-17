/*
 * File: BorderLayoutExample.java
 * ------------------------------
 * This file illustrates the BorderLayout manager.
 */

import acm.program.*;
import java.awt.*;
import javax.swing.*;

/**
 * This program illustrates the operation of the BorderLayout manager
 * by adding five buttons to the program window and assigning a button
 * to each border.  Note that this example needs to use an interior
 * panel to circumvent the fact that programs redefine the add method
 * so that it forwards the BorderLayout constants to the region panels.
 */
public class BorderLayoutExample extends Program {

	public void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JButton("NORTH"), BorderLayout.NORTH);
		panel.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		panel.add(new JButton("WEST"), BorderLayout.WEST);
		panel.add(new JButton("EAST"), BorderLayout.EAST);
		panel.add(new JButton("CENTER"), BorderLayout.CENTER);
		add(panel);
	}

/* Define the dimensions of the window */
	public static final int APPLICATION_WIDTH = 250;
	public static final int APPLICATION_HEIGHT = 100;

}
