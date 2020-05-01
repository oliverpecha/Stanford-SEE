/*
 * File: Caboose.java
 * ------------------
 * This class defines a caboose.  This implementation is
 * only a stub; filling in the details is left to the student
 * as an exercise.
 */

import acm.graphics.*;
import java.awt.*;

public class Caboose extends TrainCar {

/* Create the caboose */
	public Caboose() {
		super(Color.RED);
		GRect cupola = new GRect(0 + CONNECTOR + (CAR_WIDTH - CUPOLA_WIDTH) / 2, 0 - CAR_BASELINE - CAR_HEIGHT - CUPOLA_HEIGHT, CUPOLA_WIDTH, CUPOLA_HEIGHT);
		cupola.setFilled(true);
		cupola.setFillColor(Color.RED);
		add(cupola);	
		}
	
	/* Dimensions of the cupola on the caboose */
	private static final double CUPOLA_WIDTH = 35;
	private static final double CUPOLA_HEIGHT = 8;
}