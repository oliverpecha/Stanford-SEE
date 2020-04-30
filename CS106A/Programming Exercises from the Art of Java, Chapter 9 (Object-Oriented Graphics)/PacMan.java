/*
 * File: PacMan.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 12
 * -----------------
 * The title character in the PacMan series of games is easy to draw in java using a filled GArc. As a first step, write a GraphicsProgram 
 * that ads a PacMan figure at the extreme left edge of the canvas, as follows:
 * Once you have this part working, add the code to make the PacMan figure move rightward until it disappears off the edges of the canvas. 
 * As it moves, change the start and sweep angles so that the mouth appears to open and close as illustrated in the following sequence of images:
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class PacMan extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	public void run() {
		int mouth = MOUTH_MAX;
		GArc pacMan = new GArc (2 * RADIUS, 2 * RADIUS, mouth / 2, 360 - mouth);
		pacMan.setFilled(true);
		pacMan.setFillColor(Color.yellow);
		add(pacMan, -2 * RADIUS, (SCREEN_HEIGHT - 2 * RADIUS) / 2);
		int mouthMove = 30;
		boolean mouthClose = true;
		while (pacMan.getX() < SCREEN_WIDTH) {
			pacMan.move(DISTANCE, 0);
			pause(PAUSE);
			
			if (pacMan.getStartAngle() * 2 >= MOUTH_MAX - mouthMove + 1) mouthClose = true;
			else if (pacMan.getStartAngle() * 2 <= 0 + mouthMove - 1) mouthClose = false;
			
			if (mouthClose) mouth = mouth - mouthMove;
			else mouth = mouth + mouthMove;

			pacMan.setStartAngle(mouth / 2);
			pacMan.setSweepAngle(360 - mouth);
			if (pacMan.getX() >= SCREEN_WIDTH) pacMan.move(- SCREEN_WIDTH - 2 * RADIUS, 0);
		}
	}
	
	private static final int SCREEN_WIDTH = 600;
	private static final int SCREEN_HEIGHT = 150;
	
	private static final int RADIUS = 50;
	private static final int MOUTH_MAX = 90;
	
	private static final int PAUSE = 80;
	private static final int DISTANCE = SCREEN_WIDTH / 140;
}

