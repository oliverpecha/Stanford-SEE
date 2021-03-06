/*
 * File: DrawStarMap_RadioButtons.java
 * -----------------------------------
 * This program creates a five-pointed star every time the
 * user clicks the mouse on the canvas.  This version includes
 * a set of radio buttons to set the size.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawStarMap_RadioButtons extends GraphicsProgram {

/* Initialize the background and mouse listeners */
	public void init() {
		add(new JButton("Clear"), SOUTH);
		smallButton = new JRadioButton("Small");
		mediumButton = new JRadioButton("Medium");
		largeButton = new JRadioButton("Large");
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(smallButton);
		sizeGroup.add(mediumButton);
		sizeGroup.add(largeButton);
		mediumButton.setSelected(true);
		add(smallButton, SOUTH);
		add(mediumButton, SOUTH);
		add(largeButton, SOUTH);
		addMouseListeners();
		addActionListeners();
	}

/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e) {
		GStar star = new GStar(getCurrentSize());
		star.setFilled(true);
		add(star, e.getX(), e.getY());
	}

/* Called whenever an action event occurs */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Clear")) removeAll();
	}

/* Returns the current size */
	private double getCurrentSize() {
		if (smallButton.isSelected()) return SMALL_SIZE;
		if (largeButton.isSelected()) return LARGE_SIZE;
		return MEDIUM_SIZE;
	}

/* Private constants */
	private static final double SMALL_SIZE = 8;
	private static final double MEDIUM_SIZE = 16;
	private static final double LARGE_SIZE = 24;

/* Private instance variables */
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;

}
