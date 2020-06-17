
/*
 * File: BouncingBallOwn.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise 15
 * -----------------
 */

import acm.graphics.*;
import acm.program.*;

public class BouncingBallOwn extends GraphicsProgram {

	/* Ball size */
	private static final int BALL_SIZE = 30;

	/* Speed of the movement */
	private static final int N_STEPS = 300;
	private static final int PAUSE_TIME = 20;
	
	/* Size of the Theoretical Screen Size */
	private static final int xScreenSize = 60;
	private static final int yScreenSize = 500;
	
	/* Private constants */
	private static final int X_START = xScreenSize / 2 - BALL_SIZE / 2;
	private static final int Y_START = yScreenSize / 2 - BALL_SIZE / 2;
	private static final int LEFT_LIMIT = 0;
	private static final int RIGHT_LIMIT = xScreenSize - BALL_SIZE;
	private static final int TOP_LIMIT = 0;
	private static final int BOTTOM_LIMIT = yScreenSize - BALL_SIZE;
	

	/* Parameters that define direction of the movement */
	double dx = 1;
	double dy = 1;
	
	double x = 0;
	double y = 0;
	

	public void run() {
		screenLimits();
		startBall();
		
	}

	private void startBall() {
		
		GOval ball = new GOval(X_START, Y_START, BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		add(ball);
		
		x = X_START;
		y = Y_START;
		
		while (true) {
			ball.move(dx, dy);
			x += dx; 
			y += dy; 
			System.out.println("     #     [ X is: " + x + " ] [ Y is: " + y + " ]");

			//1 X Left Limit 
			if      (x == LEFT_LIMIT) {
				System.out.println("     #1 X Left Limit [ X is: " + x + " ] [ Y is: " + y + " ]");
				dx = +2;
				if (y == TOP_LIMIT) dy = +2;
			}
			//4 X Right Limit 
			else if      (x == RIGHT_LIMIT) {
				System.out.println("     #4 X Right Limit [ X is: " + x + " ] [ Y is: " + y + " ]");
				dx = -2;
				if (y == BOTTOM_LIMIT) dy = -2;
			}
			//3 Y BOTTOM LIMIT
			else if (y == BOTTOM_LIMIT) {
				System.out.println("     #3 Y BOTTOM LIMIT [ X is: " + x + " ] [ Y is: " + y + " ]");
				dy = -2;
				if (x == LEFT_LIMIT) dx = +2;
			}
			//2 Y TOP LIMIT 
			else if (y == TOP_LIMIT) {
				System.out.println("     #2 Y TOP LIMIT [ X is: " + x + " ] [ Y is: " + y + " ]");
				if (x == RIGHT_LIMIT) dx = -2;
				dy = +2;
			}
		
		
			
			pause(PAUSE_TIME);
		}
		
	}

	private void screenLimits() {
		/* Representation of the Theoretical Screen Size */
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
	}


}
