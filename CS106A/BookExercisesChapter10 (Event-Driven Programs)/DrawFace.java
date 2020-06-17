/*
 * File: DrawFace.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 3
 * -----------------
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.Point;
import java.awt.event.*;

public class DrawFace extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addMouseListeners();
	}

	public void run() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		face = new GFace(FACE_WIDTH, FACE_HEIGHT);
		add(face, x, y);
		// Records initial position of pupils
		pupilRstart = face.pupilR.getLocation();
		pupilLstart = face.pupilL.getLocation();
	}
			
/* Called on mouse move to move inner eyes accordingly */
	public void mouseMoved(MouseEvent e) {
		// Sets where the current Mouse Location
		GPoint mouseAt = face.getLocalPoint(new GPoint(e.getPoint()));
		// Defines the center of pupils
		GPoint pupilRStartCenter = new GPoint(pupilRstart.getX() + face.pupilR.getWidth() / 2, 
												pupilRstart.getY() + face.pupilR.getHeight() / 2);
		GPoint pupilLStartCenter = new GPoint(pupilLstart.getX() + face.pupilL.getWidth() / 2, 
				pupilLstart.getY() + face.pupilL.getHeight() / 2);
		// Calculates the distance between pupil center and location of mouse
		GPoint distanceToL = new GPoint(mouseAt.getX() - pupilLStartCenter.getX(), 
									  mouseAt.getY() - pupilLStartCenter.getY());
		GPoint distanceToR = new GPoint(mouseAt.getX() - pupilRStartCenter.getX(), 
				  mouseAt.getY() - pupilRStartCenter.getY());
		// Defines how much the pupil should move given the above measurements
		GPoint movingPositionL = new GPoint(0.97 * pupilLstart.getX() + 0.017 * distanceToR.getX(), 
				   pupilLstart.getY() + 0.017 * distanceToL.getY());
		GPoint movingPositionR = new GPoint(0.97 * pupilRstart.getX() + 0.017 * distanceToR.getX(), 
												   pupilRstart.getY() + 0.017 * distanceToR.getY());	
		// Applies movement
		face.pupilL.setLocation(movingPositionL);
		face.pupilR.setLocation(movingPositionR);
	}	

/* Private constants */
	private static final double FACE_WIDTH = 200;   /* Width of the face  */
	private static final double FACE_HEIGHT = 300;  /* Height of the face */

/* Private instance variables */
	private GPoint pupilLstart;	/* The initial location or Left pupil  */
	private GPoint pupilRstart; /* The initial location or Right pupil  */
	private GFace face;			/* The base object where face elements are contained  */

	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
}
