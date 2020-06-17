/*
 * File: RandomCircles.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 3 / Programming Exercise 3
 * -----------------
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class RandomCircles extends GraphicsProgram {	
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		drawCircles();
	}
	
	private void drawCircles() {
		for (int i = 0; i < CIRCLES; i++) {
			int radius = luck.nextInt(5, 80);
			Color appearance = luck.nextColor();
			GOval circles = new GOval(2 * radius, 2 * radius);
			circles.setColor(appearance);
			circles.setFilled(true);
			int xBound = SCREEN_WIDTH - 2 * radius;
			int yBound = SCREEN_HEIGHT - 2 * radius;
			add(circles, luck.nextInt(0, xBound), luck.nextInt(0, yBound));
		}
	}
	
	RandomGenerator luck = new RandomGenerator();
	
	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 300;
	private static final int CIRCLES = 10;
	
}
