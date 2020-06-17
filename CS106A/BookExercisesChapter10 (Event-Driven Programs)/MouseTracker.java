/*
 * File: RandomColorLabel.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 10 / Programming Exercise 2
 * -----------------
 * 
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;

public class MouseTracker extends GraphicsProgram {
	int xNow = 0;
	int yNow = 0;
	String xAndY = xNow + "," + yNow;
	GLabel currentPosition = new GLabel(xAndY);

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e) {
		xNow = e.getX();
		yNow = e.getY();
		currentPosition.setLabel(xNow + ", " + yNow);
		if (xNow < 50 && yNow < 20) add(currentPosition, xNow + SMALL_MARGIN, yNow + currentPosition.getHeight() + BIG_MARGIN);
		else if (xNow > 50 && yNow < 20) add(currentPosition, xNow - SMALL_MARGIN - currentPosition.getWidth(), yNow + currentPosition.getHeight() + BIG_MARGIN);
		else if (xNow < 50 && yNow > 20) add(currentPosition, xNow + SMALL_MARGIN, yNow - MEDIUM_MARGIN);
		else add(currentPosition, xNow - SMALL_MARGIN - currentPosition.getWidth(), yNow - MEDIUM_MARGIN);
	}

	private static final int SMALL_MARGIN = 2;
	private static final int MEDIUM_MARGIN = 5;
	private static final int BIG_MARGIN = 15;

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 300;
}
