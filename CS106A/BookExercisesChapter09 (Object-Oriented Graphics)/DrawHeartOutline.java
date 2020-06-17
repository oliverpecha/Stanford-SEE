/*
 * File: DrawHeartOutline.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 7
 * -----------------
 * One way to draw a heart-shaped figure is by drawing two semicircles on top of a square that is positioned so that its sides 
 * run diagonally, as illustrated by the following diagram:
 * -----------------
 * Write a GraphicsProgram that uses this construction to draw a heart on the screen using the classes GArc and GLine. Your 
 * program should display the heart without drawing the interior lines that form the top of the square, so the output looks like this:
 */


import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class DrawHeartOutline extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run() {
		double hypotenuse = 2 * RADIUS;
		double adjacent = hypotenuse * GMath.sinDegrees(45);
		// x center line
		//add(new GLine(SCREEN_WIDTH / 2, 3000, SCREEN_WIDTH / 2, -3000));

		// V square
		add(new GLine(SCREEN_WIDTH / 2 - adjacent, SCREEN_HEIGHT / 2, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2 + adjacent));
		add(new GLine(SCREEN_WIDTH / 2 + adjacent, SCREEN_HEIGHT / 2, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2 + adjacent));
		
		/*/ A square
		//add(new GLine(SCREEN_WIDTH / 2 + adjacent, SCREEN_HEIGHT / 2, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2 - adjacent));
		add(new GLine(SCREEN_WIDTH / 2 - adjacent, SCREEN_HEIGHT / 2, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2 - adjacent));
		*/

		
		GArc leftHeart = new GArc(2 * RADIUS, 2 * RADIUS, 45, 180);
			add(leftHeart, SCREEN_WIDTH / 2 - adjacent / 2 - RADIUS, SCREEN_HEIGHT / 2 - adjacent / 2 - RADIUS);
		GArc rightHeart = new GArc(2 * RADIUS, 2 * RADIUS, -45, 180);
			add(rightHeart, SCREEN_WIDTH / 2 + adjacent / 2 - RADIUS, SCREEN_HEIGHT / 2 - adjacent / 2 - RADIUS);
			
	}

	private static final int RADIUS = 100;

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
}
