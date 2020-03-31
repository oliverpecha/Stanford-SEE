/*
 * File: FindLargest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise 15
 * -----------------
 * This was abandoned and solution was found in BouncingBallOwn
 */

import acm.graphics.*;
import acm.program.*;

public class AnimatedSquare extends GraphicsProgram {

	/* Parameters that define size of the Theoretical Screen Size */
	private static final int xScreenSize = 300;
	private static final int yScreenSize = 200;
	
	/* Private constants */
	private static final int BALL_SIZE = 50;
	private static final int X_START = 0;
			//xScreenSize / 2 - BALL_SIZE;
	private static final int Y_START = 0;
			// yScreenSize / 2 - BALL_SIZE;
	
	/* Parameters for speed of the movement */
	private static final int N_STEPS = 300;
	private static final int PAUSE_TIME = 150;

	/* Parameters that define direction of the movement */
	double dx = 1;
	double dy = 1;
	
	double x = 0;
	double y = 0;
	
	boolean xLimits = x < xScreenSize - BALL_SIZE;
	boolean yLimits = y < yScreenSize - BALL_SIZE;
	
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
			System.out.println(" ");
			System.out.println("####### [ X is: " + x + " ] [ Y is: " + y + " ] #######");
			
			//1
			if      (x >= 0 && x <= 100 && y >= 0 && y <= 50) {
				ball.move(dx, dy);
				x += dx;
				y += dy;
				System.out.println("     #1 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
			//#2
			else if (x >= 100 && x <= 250 && y >= 0 && y <= 50) {
				ball.move(dx, dy);
				x += dx;
				y += dy;
				System.out.println("     #2 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
			//#3
			else if (x >= 0 && x <= 100 && y >= 50 && y <= 150) {
				ball.move(dx, -dy);
				x += dx;
				y += dy;
				System.out.println("     #3 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
			//#4
			else if (x >= 100 && x <= 250 && y >= 50 && y <= 150) {
				ball.move(dx, dy);
				x += dx;
				y += dy;
				System.out.println("     #4 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
		
			
			
			
			pause(PAUSE_TIME);
		}
		
	}

	private void screenLimits() {
		/* Representation of the Theoretical Screen Size */
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
	}


}

/*
 * 
 
 ball bouncing at the top
			
			//1
			if (x >= 0 && x <= 150 && y > 0 && y < 100) {
				ball.move(dx, -dy);
				x += dx;
				y += dy;
				System.out.println("#1 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
			//#2
			else if 		(x >= 150 && x <= 300 && y >= 0 && y <= 100) {
				ball.move(dx, dy);
				x += -dx;
				y += -dy;
				System.out.println("#2 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
			//#3
			else if 		(x >= 0 && x <= 150 && y >= 100 && y <= 200) {
				ball.move(dx, dy);
				x += dx;
				y += dy;
				System.out.println("#3 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
			//#4
			else if 		(x >= 150 && x <= 300 && y >= 100 && y <= 200) {
				ball.move(dx, dy);
				x += dx;
				y += dy;
				System.out.println("#4 [ X is: " + x + " ] [ Y is: " + y + " ]");
			}
		
			
 
 
 */
