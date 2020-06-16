/*
 * File: HeadLine.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise 15
 * -----------------
 */


import acm.program.*;
import acm.graphics.*;

public class HeadLine extends GraphicsProgram {

	
	/* Controls text */
	private static final String HEADLINE = "DEWEY DEFEATS TRUMAN";
	private static final String FONT = "Helvetica";
	private static final int FONT_SIZE = 200;
	private static final int HEADLINE_WIDTH = 4000;
	
	/* Controls movement */
	private static final int N_STEPS = 1000;
	private static final int PAUSE_TIME = 20;
	
	/* Size of the Theoretical Screen Size */
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 200;
	
	int xStart = xScreenSize + (xScreenSize /10) * 5; 
	int yStart = (FONT_SIZE / 20) * 17;
	
	double dx = (HEADLINE_WIDTH) / N_STEPS;
	double x = 0;
	
	public void run() {
		
		screenLimits();
		while (true) {
			GLabel label = new GLabel(HEADLINE);
	        label.setFont(FONT + "-" + FONT_SIZE);
	        add(label, xStart, yStart);
	       
	        for (int i = 0; i < N_STEPS; i++) {
	        	label.move(-dx, 0);
	        	x -= dx;
				System.out.println("x is: " + x + ".");
				pause(PAUSE_TIME);
	        }
	        x = 0;
		}
	}
	
	
	private void screenLimits() {
		/* Representation of the Theoretical Screen Size */
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
	}

	
}
