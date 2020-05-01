/*
 * File: Engine.java
 * -----------------
 * This class defines the engine.  This implementation is
 * only a stub; filling in the details is left to the student
 * as an exercise.
 */

import acm.graphics.*;
import java.awt.*;

public class Engine extends TrainCar {

/* Creates the engine */
	public Engine() {
		super(Color.BLACK);
		int x = 0;
		int y = 0;
		drawSmokestack(x, y);
		drawEngineCab(x, y);
		drawCowcatcher(x, y);
	}
	/* Draws the smokestack */ 
	private void drawSmokestack(double x, double y) {
		GRect smokestack = new GRect(x + CONNECTOR + SMOKESTACK_INSET, y - CAR_BASELINE - CAR_HEIGHT - SMOKESTACK_HEIGHT, SMOKESTACK_WIDTH, SMOKESTACK_HEIGHT);
		smokestack.setFilled(true);
		add(smokestack);
	}

	/* Draws the engine cab */
	private void drawEngineCab(double x, double y) {
		GRect engineCab = new GRect(x + CONNECTOR + CAR_WIDTH - CAB_WIDTH, y - CAR_BASELINE - CAR_HEIGHT - CAB_HEIGHT, CAB_WIDTH, CAB_HEIGHT);
		engineCab.setFilled(true);
		add(engineCab);
	}
	
	/* Draws the cowcatcher in the front of the engine */
	private void drawCowcatcher(double x, double y) {
		add(new GLine(x, y - CAR_BASELINE , x + CONNECTOR, y - CAR_BASELINE - CAR_HEIGHT / 2));
		add(new GLine(x + CONNECTOR / 2, y - CAR_BASELINE , x + CONNECTOR, y - CAR_BASELINE - CAR_HEIGHT / 2));
	}
	
	/* Dimensions of the cab on the engine */
	private static final double CAB_WIDTH = 35;
	private static final double CAB_HEIGHT = 8;

	/* Dimensions of the smokestack and its distance from the front */
	private static final double SMOKESTACK_WIDTH = 8;
	private static final double SMOKESTACK_HEIGHT = 8;
	private static final double SMOKESTACK_INSET = 8;
}
