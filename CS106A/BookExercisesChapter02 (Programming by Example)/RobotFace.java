/*
 * File: RobotFace.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 5 on chapter 2 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {	
	public void run() {

		face();
		eyes();
		nose();
		mouth();
	}
	
	
	//face
	private void face() {	
	GRect face = new GRect (100, 100, 100, 150);
	face.setColor(Color.BLACK);
	face.setFilled(true);
	face.setFillColor(Color.LIGHT_GRAY);
    add(face);
	}
	
	//eyes
	private void eyes() {	
		GOval rightEye = new GOval (115, 125, 20, 20);
		rightEye.setColor(Color.ORANGE);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.ORANGE);
		add(rightEye);
		GOval leftEye = new GOval (165, 125, 20, 20);
		leftEye.setColor(Color.ORANGE);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.ORANGE);
		add(leftEye);
	}
	
	//nose
	private void nose() {	
		GRect nose = new GRect (145, 165, 10, 20);
		nose.setColor(Color.BLACK);
		nose.setFilled(true);
		nose.setFillColor(Color.BLACK);
		add(nose);
	}

	//nose
	private void mouth() {	
		GRect mouth = new GRect (120, 200, 60, 20);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		add(mouth);
	}
	
}
