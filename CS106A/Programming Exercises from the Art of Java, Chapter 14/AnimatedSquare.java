/*
 * File: AnimatedSquare.java
 * -------------------------
 * This class implements a square that executes its own thread.
 */

import acm.graphics.*;
import acm.util.*;

/**
 * This class creates an animated square that has its own thread of control.
 * Once started, the square moves in a random direction every time step.
 * After CHANGE_TIME time steps, the square picks a new random direction.
 */
public class AnimatedSquare extends GRect implements Runnable {

/** Creates a new AnimatedSquare of the specified size */
	public AnimatedSquare(double size, AnimatedSquare master) {
		super(size, size);
		link = master;
	}

/** Runs when this object is started to animate the square */
	public void run() {
		if (link == null) {
			for (int t = 0; true; t++) {
				if (t % CHANGE_TIME == 0) {
					direction = rgen.nextDouble(0, 360);
				}
				movePolar(DELTA, direction);
				pause(PAUSE_TIME);
			}
		}
		else {
			double distance = this.getLocation().getX() - link.getLocation().getX();
			while (true) {				
				setLocation(link.getLocation().getX() + distance, link.getLocation().getY());
				pause(PAUSE_TIME);
			}
		}
	}

/* Private constants */
	private static final double DELTA = 2;     /* Pixels to move each cycle       */
	private static final int PAUSE_TIME = 20;  /* Length of time step             */
	private static final int CHANGE_TIME = 50; /* Steps before changing direction */

/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private double direction;
	private AnimatedSquare link;

}
