/*
 * File: DrawStarMap_ColorChooser.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 6
 * -----------------
 */

import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program creates a five-pointed star every time the user clicks the
 * mouse on the canvas.  This version includes a JButton to clear the screen,
 * a JSlider to choose the size, and a JComboBox to choose the color.
 */
public class DrawStarMap_ColorChooser extends GraphicsProgram {

/* Initializes the graphical user interface */
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setBackground(Color.GRAY);
		add(new JButton("Clear"), SOUTH);
		sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, INITIAL_SIZE);
		add(new JLabel("  Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large  "), SOUTH);
		initColorChooser();
		add(colorChooser, SOUTH);
		addMouseListeners();
		addActionListeners();
	}

/* Initializes the color chooser */
	private void initColorChooser() {
		colorChooser = new JComboBox();
		colorChooser.addItem(new LabeledColor(Color.WHITE, "White"));
		colorChooser.addItem(new LabeledColor(Color.RED, "Red"));
		colorChooser.addItem(new LabeledColor(Color.YELLOW, "Yellow"));
		colorChooser.addItem(new LabeledColor(Color.ORANGE, "Orange"));
		colorChooser.addItem(new LabeledColor(Color.GREEN, "Green"));
		colorChooser.addItem(new LabeledColor(Color.BLUE, "Blue"));
		colorChooser.addItem(new LabeledColor(Color.BLACK, "Black"));
		colorChooser.setEditable(false);
		colorChooser.setSelectedItem("White");
	}

/* Returns the current size */
	private double getCurrentSize() {
		return sizeSlider.getValue();
	}

/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e) {
		GStar star = new GStar(getCurrentSize());
		star.setFilled(true);
		star.setColor((Color) colorChooser.getSelectedItem());
		add(star, e.getX(), e.getY());
	}

/* Called whenever an action event occurs */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Clear")) {
			removeAll();
		}
	}

/* Private constants */
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 50;
	private static final int INITIAL_SIZE = 16;
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;

/* Private instance variables */
	private JSlider sizeSlider;
	private JComboBox colorChooser;

	
	class LabeledColor extends Color{
	
		LabeledColor(Color color, String colorName) {
			super(color.getRGB());
			colorString = colorName;
		}
		
		public String toString(){
			return colorString;
		}
		
		String colorString;
	}
}
