/*
 * File: AnimatedSquare.java
 * -------------------------
 * This program animates a square so that it moves from the
 * upper left corner of the window to the lower right corner.
 */

import acm.graphics.*;
import acm.program.*;

public class BouncingBall extends GraphicsProgram {

	public void run() {
		GRect square = new GRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
		square.setFilled(true);
		add(square);
		double dx = (getWidth() - SQUARE_SIZE) / N_STEPS;
		double dy = (getHeight() - SQUARE_SIZE) / N_STEPS;
		for (int i = 0; i < N_STEPS; i++) {
			square.move(dx, dy);
			System.out.println("dx is: " + dx + " dy is: " + dy);
			pause(PAUSE_TIME);
		}
		for (int i = 0; i < N_STEPS; i++) {
			square.move(dx*-1, dy*-1);
			System.out.println("dx is: " + dx*-1 + " dy is: " + dy*-1);
			pause(PAUSE_TIME);
		}
	}

/* Private constants */
	private static final int N_STEPS = 1000;
	private static final int PAUSE_TIME = 20;
	private static final double SQUARE_SIZE = 50;

}
