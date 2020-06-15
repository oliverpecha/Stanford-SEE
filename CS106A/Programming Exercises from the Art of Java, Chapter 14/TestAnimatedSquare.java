/*
 * File: TestAnimatedSquare.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 7
 * -----------------
 */

import acm.program.*;
import java.awt.*;

/**
 * This program tests the AnimatedSquare class by putting two squares
 * on the screen and having them move independently.
 */

public class TestAnimatedSquare extends GraphicsProgram {

	public void init() {
		setSize(1200, 400);
	}
	public void run() {
		double x1 = getWidth() / 3 - SQUARE_SIZE / 2;
		double x2 = 2 * getWidth() / 3 - SQUARE_SIZE / 2;
		double y = (getHeight() - SQUARE_SIZE) / 2;
		AnimatedSquare redSquare = new AnimatedSquare(SQUARE_SIZE, null);
		redSquare.setFilled(true);
		redSquare.setColor(Color.RED);
		add(redSquare, x1, y);
		AnimatedSquare greenSquare = new AnimatedSquare(SQUARE_SIZE, redSquare);
		greenSquare.setFilled(true);
		greenSquare.setColor(Color.GREEN);
		add(greenSquare, x2, y);
		Thread redSquareThread = new Thread(redSquare);
		Thread greenSquareThread = new Thread(greenSquare);
		waitForClick();
		redSquareThread.start();
		greenSquareThread.start();
	}

/* Private constants */
	private static final double SQUARE_SIZE = 75;

}
