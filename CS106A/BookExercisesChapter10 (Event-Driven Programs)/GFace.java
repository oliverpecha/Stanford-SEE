/*
 * File: GFace.java
 * ----------------
 * This file defines a compound GFace class.
 */

import acm.graphics.*;

public class GFace extends GCompound {

/** Construct a new GFace object with the specified width and height. */
	public GFace(double width, double height) {
		head = new GOval(width, height);
		leftEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		pupilL = new GOval(EYE_WIDTH * width * EYE_IN_SCALE, EYE_HEIGHT * height * EYE_IN_SCALE);
		pupilL.setFilled(true);
		pupilR = new GOval(EYE_WIDTH * width * EYE_IN_SCALE, EYE_HEIGHT * height * EYE_IN_SCALE);
		pupilR.setFilled(true);
		nose = createNosePolygon(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
		double newX = head.getWidth() / 2;
		double newY = head.getHeight() / 2;
		add(head, -newX, -newY);
		add(leftEye, -newX + 0.25 * width - EYE_WIDTH * width / 2,
				-newY + 0.25 * height - EYE_HEIGHT * height / 2);
		add(rightEye, 	-newX + 0.75 * width - EYE_WIDTH * width / 2,
						-newY + 0.25 * height - EYE_HEIGHT * height / 2);
		add(pupilL, -newX + 0.25 * width - EYE_IN_SCALE * EYE_WIDTH * width / 2,
					-newY + 0.25 * height - EYE_IN_SCALE * EYE_HEIGHT * height / 2);
		add(pupilR, -newX + 0.75 * width - EYE_IN_SCALE * EYE_WIDTH * width / 2,
					-newY + 0.25 * height - EYE_IN_SCALE * EYE_HEIGHT * height / 2);
		add(nose, -newX + 0.50 * width, -newY + 0.50 * height);
		add(mouth, -newX + 0.50 * width - MOUTH_WIDTH * width / 2,
				-newY + 0.75 * height - MOUTH_HEIGHT * height / 2);
	}

/* Creates a triangle for the nose */
	private GPolygon createNosePolygon(double width, double height) {
		GPolygon poly = new GPolygon();
		poly.addVertex(0, -height / 2);
		poly.addVertex(width / 2, height / 2);
		poly.addVertex(-width / 2, height / 2);
		return poly;
	}

/* Constants specifying feature size as a fraction of the head size */
	private static final double EYE_IN_SCALE    = 0.5;
	private static final double EYE_WIDTH    = 0.15;
	private static final double EYE_HEIGHT   = 0.15;
	private static final double NOSE_WIDTH   = 0.15;
	private static final double NOSE_HEIGHT  = 0.10;
	private static final double MOUTH_WIDTH  = 0.50;
	private static final double MOUTH_HEIGHT = 0.03;

/* Private instance variables */
	private GOval head;
	private GOval leftEye, rightEye;
	private GOval leftInEye;
	public static GOval pupilR;
	public static GOval pupilL;
	private GPolygon nose;
	private GRect mouth;
}
