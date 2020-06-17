/*
 * File: TrainCar.java
 * -------------------
 * This file defines the TrainCar class, which is the abstract
 * superclass for all train cars.
 */

import acm.graphics.*;
import java.awt.*;

/**
 * This abstract class defines what is common to all train cars.
 */
public abstract class TrainCar extends GCompound {

/**
 * Creates the frame of the car using the specified color.
 * @param color The color of the new boxcar
 */
	public TrainCar(Color color) {
		double xLeft = CONNECTOR;
		double yBase = -CAR_BASELINE;
		add(new GLine(0, yBase, CAR_WIDTH + 2 * CONNECTOR, yBase));
		addWheel(xLeft + WHEEL_INSET, -WHEEL_RADIUS);
		addWheel(xLeft + CAR_WIDTH - WHEEL_INSET, -WHEEL_RADIUS);
		double yTop = yBase - CAR_HEIGHT;
		GRect r = new GRect(xLeft, yTop, CAR_WIDTH, CAR_HEIGHT);
		r.setFilled(true);
		r.setFillColor(color);
		add(r);
	}

/* Adds a wheel centered at (x, y) */
	private void addWheel(double x, double y) {
		GOval wheel = new GOval(x - WHEEL_RADIUS, y - WHEEL_RADIUS,
		                        2 * WHEEL_RADIUS, 2 * WHEEL_RADIUS);
		wheel.setFilled(true);
		wheel.setFillColor(Color.GRAY);
		add(wheel);
	}

/* Dimensions of the frame of a train car */
	public static final double CAR_WIDTH = 75;
	public static final double CAR_HEIGHT = 36;

/* Width of the connector, which overlaps between successive cars */
	public static final double CONNECTOR = 6;

/* Distance that the bottom of a train car rides about the track */
	public static final double CAR_BASELINE = 10;

/* Radius of the wheels on each car */
	private static final double WHEEL_RADIUS = 8;

/* Distance from the edge of the frame to the center of the wheel */
	private static final double WHEEL_INSET = 16;

}
