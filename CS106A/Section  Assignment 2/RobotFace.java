/*
 * File: RobotFace.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 2 on CS 106A, Section Handout #2.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {	
	
	int xAxis = xScreenSize / 2;
	int yAxis = yScreenSize / 2;
	
	public void run() {
		
		screenOn();
		head();
		eyes();
		nose();
		mouth();
		
	}
	

	//head
	private void head() {	
	GRect head = new GRect (xAxis - HEAD_WIDTH / 2, yAxis - HEAD_HEIGHT /2, HEAD_WIDTH, HEAD_HEIGHT);
	head.setColor(Color.BLACK);
	head.setFilled(true);
	head.setFillColor(Color.LIGHT_GRAY);
    add(head);
	}
	
	//eyes
	private void eyes() {	
		GOval rightEye = new GOval (xAxis - MOUTH_WIDTH / 2, yAxis - NOSE_HEIGHT * 2, EYE_RADIUS, EYE_RADIUS);
		rightEye.setColor(Color.ORANGE);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.ORANGE);
		add(rightEye);
		GOval leftEye = new GOval (xAxis + MOUTH_WIDTH / 2 - EYE_RADIUS, yAxis - NOSE_HEIGHT * 2, EYE_RADIUS, EYE_RADIUS);
		leftEye.setColor(Color.ORANGE);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.ORANGE);
		add(leftEye);
	}
	
	//nose
	private void nose() {	
		GRect nose = new GRect (xAxis - NOSE_WIDTH / 2, yAxis - NOSE_HEIGHT /2, NOSE_WIDTH, NOSE_HEIGHT);
		nose.setColor(Color.BLACK);
		nose.setFilled(true);
		nose.setFillColor(Color.BLACK);
		add(nose);
	}

	//nose
	private void mouth() {	
		GRect mouth = new GRect (xAxis - MOUTH_WIDTH / 2, yAxis + MOUTH_HEIGHT * 3 / 2, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		add(mouth);
	}
	
	// Representation of the Theoretical Screen Size
	private void screenOn() {
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
	}
	
	private static final int HEAD_WIDTH = 100;
	private static final int HEAD_HEIGHT = 150;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 60;
	private static final int MOUTH_HEIGHT = 20;
	private static final int NOSE_WIDTH = 10;
	private static final int NOSE_HEIGHT = 20;
	
	
	// Parameters that define size of the Theoretical Screen Size
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 400;
	
}
