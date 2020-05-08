/*
 * File: BouncingBall.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 4 / Programming Exercise 7 & 8
 * -----------------
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BouncingBall extends GraphicsProgram {

	/* Ball size */
	private static final int BALL_SIZE = 30;

	/* Speed of the movement */
	private static final int N_STEPS = 300;
	private static final int INITIAL_PAUSE_TIME = 20;
	private static final int MIN_PAUSE_TIME = 10;
	private static final int MAX_PAUSE_TIME = 50;
	
	/* Size of the Screen Size */
	private static final int SCREEN_WIDTH = 400;
	private static final int SCREEN_HEIGHT = 300;
	
	
	/* Private constants */
	private static final int X_START = SCREEN_WIDTH / 2 - BALL_SIZE / 2;
	private static final int Y_START = SCREEN_HEIGHT / 2 - BALL_SIZE / 2;
	private static final int LEFT_LIMIT = 0;
	private static final int RIGHT_LIMIT = SCREEN_WIDTH - BALL_SIZE;
	private static final int TOP_LIMIT = 0;
	private static final int BOTTOM_SOUTH = 40;
	private static final int BOTTOM_LIMIT = SCREEN_HEIGHT - BALL_SIZE - BOTTOM_SOUTH;
	

	/* Parameters that define state and direction of the movement */
	double dx = 1;
	double dy = 1;
	double x = X_START;
	double y = Y_START;
	boolean runFlag = false;
	JSlider speedSlider;
	GOval ball;
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		add(new JButton("Start"), SOUTH);
		add(new JButton("Stop"), SOUTH);
		add(new JLabel("Slow"), SOUTH);
		speedSlider = new JSlider(MIN_PAUSE_TIME, MAX_PAUSE_TIME, INITIAL_PAUSE_TIME);
		speedSlider.setInverted(true);
		add(speedSlider, SOUTH);
		add(new JLabel("Fast"), SOUTH);
		addActionListeners();
	}
	
	public void run() {
		ball = new GOval(X_START, Y_START, BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		add(ball);
		while (true) {
			if (runFlag) {
				startBall();
			}
			else ball.setLocation(x,y);
		}
	}

	private void startBall() {			
		while (runFlag) {
			System.out.println("BOTTOM_LIMIT is " + BOTTOM_LIMIT);
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
			pause(getCurrentSpeed());
		}
	}
	
	public double getCurrentSpeed() {
		return speedSlider.getValue();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			runFlag = true;
		}
		else if (e.getActionCommand().equals("Stop")) {
			runFlag = false;
		}
	}
}
