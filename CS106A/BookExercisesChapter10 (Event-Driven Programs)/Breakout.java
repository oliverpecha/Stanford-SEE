/*
 * File: Breakout.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 10 / Programming Exercise 10
 * -----------------
 */

import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.color.*;

public class Breakout extends GraphicsProgram {
	
/* Instance variables to define state and direction of the movement */
	int turns = 3;
	double dx = 1;
	double dy = 1;
	double x = BALL_START_X;
	double y = BALL_START_Y;

/* Instance Objects */
	Paddle paddle;
	RandomGenerator luck = new RandomGenerator();

/* Operations before program starts */
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		Frame frame = new Frame(SCREEN_WIDTH, SCREEN_HEIGHT);
		add  (frame);
		addBounds();
		addBricks();
		addKeyListeners();

		paddle = new Paddle (SCREEN_TO_PADDLE_X_RATIO * SCREEN_WIDTH);
		paddle.setLocation(SCREEN_WIDTH / 2 - paddle.getWidth() / 2, SCREEN_HEIGHT - BOTTOM_CORRIDOR);
		add(paddle);
	}
	
/* Operations to perform while program is running */
	public void run() {	
		// Local Variables initialized
		Ball ball;
		GPoint ballCenter;
		GPoint ballNorth = new GPoint(), ballEast = new GPoint(), ballSouth = new GPoint(), ballWest = new GPoint();
		GObject collisionNorth, collisionEast, collisionSouth, collisionWest;	
		// ball keeps bouncing until there are no more turns
		while (turns > 0) {
			// Adds a new ball at a random X position using helper ballPositionStarter
			ballPositionStarter();
			ball = new Ball (BALL_RADIUS);
			ball.setLocation(x, y);
			add(ball);
			// ball keeps moving and bouncing until loop is exited and ball position is randomized again
			while (true) {
				// movement direction in x and y axis
				ball.move(dx, dy);
				// at every move, ball Center, North, East, South and West positions are recorded
				ballCenter = ball.getLocation();
				ballNorth.setLocation(ballCenter.getX(), ballCenter.getY() - BALL_RADIUS - 1);
				ballEast.setLocation(ballCenter.getX() + BALL_RADIUS + 1, ballCenter.getY());
				ballSouth.setLocation(ballCenter.getX(), ballCenter.getY() + BALL_RADIUS + 1);
				ballWest.setLocation(ballCenter.getX() - BALL_RADIUS - 1, ballCenter.getY());
				// N, E, S, W positions evaluate if they are bounding with any element
				collisionNorth = getElementAt(ballNorth);
				collisionEast = getElementAt(ballEast);
				collisionSouth = getElementAt(ballSouth);
				collisionWest = getElementAt(ballWest);
				// When ball bounds with an element in any of its points, alters direction accordingly of which point has found an obstacle
				if (collisionNorth != null) {
					dy = 1; 
					if (isBrick(collisionNorth)) remove(collisionNorth);
				}
				if (collisionEast != null) {
					dx = -1; 
					if (isBrick(collisionEast)) remove(collisionEast);
				}
				if (collisionWest != null) {
					dx = 1; 
					if (isBrick(collisionWest)) remove(collisionWest);
				}
				if (collisionSouth != null) {
					dy = -1; 
					if (isBrick(collisionSouth)) remove(collisionSouth);
					// Additionally, Ball South bounding is special, because it might have reached the bottom bound that ends and deducts a 						// turn, then restarts the game
					String elementHelper = "" + collisionSouth;
					if (elementHelper.equals("Breakout$Bound[location=(0.0, 0.0)]")) {
						pause(1000);
						remove(ball);
						turns--;
						dy = 1;
						y = BALL_START_Y;
						pause(1000);
						break;
					}
				}
				pause(BALL_SPEED);
			}
		}
	}

/* Ball direction and position in the X axis  gets randomized */
	private void ballPositionStarter() {
		x = luck.nextInt(2 * MARGIN_L, SCREEN_WIDTH - 2 * MARGIN_L - 2 * BALL_RADIUS);
		boolean inverse = false;
		inverse = luck.nextBoolean();
		if (inverse) dx = -1;
	}
/* Helper method that converts and objected passed to a String to find out if it is a GRect or an Object from a custom class.
 * When it is custom class, p1 is greater than 0 and and isBrick is turned false, to inform main operation that element needs to be kept */	
	private boolean isBrick(GObject obj) {
		boolean isBrick = true;
		String elementHelper = "" + obj;
		int p1 = elementHelper.indexOf('$');
		if (p1 >= 0) {
			isBrick = false;
		}
		return isBrick;
	}

/* Listens key events and moves paddle left and right within certain boundaries */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: {
				if (paddle.getX() < SCREEN_WIDTH - 2 * MARGIN_L - paddle.getWidth()) {
				paddle.move(PADDLE_SPEED, 0);
				}
				break;
			}
			case KeyEvent.VK_LEFT: {
				if (paddle.getX() > 2 * MARGIN_L) {
					paddle.move(-PADDLE_SPEED, 0); 
				}
				break;
			}
		}
		
	}

/* adds a given amount of bricks horizontally and vertically */
	private void addBricks() {
		double birckWidth = (SCREEN_WIDTH - 4 * MARGIN_L - 9 * MARGIN_M) / X_BRICKS;
		double birckHeight = BRICK_X_RATIO * birckWidth;
		Color brickColor;
		for (int i = 0; i < X_BRICKS; i++) {
			for (int n = 0; n < Y_BRICKS; n++) {
				brickColor = colorAssigner(n);
				GRect brick = new GRect(birckWidth, birckHeight);
				brick.setLocation(i * birckWidth + i * MARGIN_M + 2 * MARGIN_L, 
						n * birckHeight + n * MARGIN_M + MARGIN_L + TOP_CORRIDOR);
				brick.setFilled(true);
				brick.setFillColor(brickColor);
				brick.setColor(brickColor);
				add(brick);
			}
		}
	}
	
/* helps addBricks assign colors in relation to the row it is constructing */
	private Color colorAssigner(int row) {
		Color color = null;
		switch (row) {
			case 0:
			case 1: color = Color.red; break;
			case 2:
			case 3: color = Color.orange; break;
			case 4:
			case 5: color = Color.yellow; break;
			case 6:
			case 7: color = Color.green; break;
			case 8:
			case 9:	color = Color.cyan; break;
		}
		return color;
	}
	
/* adds four bounds around the screen which other methods identify as walls for the ball to bounce from */
	private void addBounds() {
		Bound bound_N = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);
		   	  bound_N.bound.setStartPoint(0 + MARGIN_L, 0 + MARGIN_L);
		   	  bound_N.bound.setEndPoint(SCREEN_WIDTH - MARGIN_L, 0 + MARGIN_L);
		add  (bound_N);
		Bound bound_E = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);	
			  bound_E.bound.setStartPoint(SCREEN_WIDTH - MARGIN_L, 0 + MARGIN_L);
			  bound_E.bound.setEndPoint(SCREEN_WIDTH - MARGIN_L, SCREEN_HEIGHT - MARGIN_L);
		add  (bound_E);
		Bound bound_S = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);	
			  bound_S.bound.setStartPoint(SCREEN_WIDTH - MARGIN_L, SCREEN_HEIGHT - MARGIN_L);
			  bound_S.bound.setEndPoint(0 + MARGIN_L, SCREEN_HEIGHT - MARGIN_L);
		add  (bound_S);
		Bound bound_W = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);	
		  	  bound_W.bound.setStartPoint(0 + MARGIN_L, SCREEN_HEIGHT - MARGIN_L);
		  	  bound_W.bound.setEndPoint(0 + MARGIN_L, 0 + MARGIN_L);
		add  (bound_W);
	}
	
/* 
 ******************************************************************************************************
 * Constant variables
 ******************************************************************************************************
 */
	
/* Size of the Screen Size */
	private static final int SCREEN_WIDTH = 400;
	private static final int SCREEN_HEIGHT = 500;

/* Margins of element separation */	
	private static final int MARGIN_S = 1;
	private static final int MARGIN_M = 4;
	private static final int MARGIN_L = 10;
	
/* Measure for Elements */	
	private static final int X_BRICKS = 10;
	private static final int Y_BRICKS = 10;
	private static final double BRICK_X_RATIO = 0.25;
	private static final double SCREEN_TO_PADDLE_X_RATIO = 0.25;
	private static final double PADDLE_Y_RATIO = 0.15;
	private static final double TOP_CORRIDOR = 0.15 * SCREEN_HEIGHT;
	private static final double BOTTOM_CORRIDOR = 0.15 * SCREEN_HEIGHT;
	
/* Size & starting position for Ball*/
	private static final int BALL_RADIUS = 10;
	private static final int BALL_START_X = SCREEN_WIDTH / 2 - BALL_RADIUS;
	private static final int BALL_START_Y = SCREEN_HEIGHT / 2 - BALL_RADIUS;
	
/* Speed of the movement for Ball and Padle */
	private static final int BALL_SPEED = 8;
	private static final int PADDLE_SPEED = 10;

/* 
 ******************************************************************************************************
 * Local classes that define Frame, Ball, Bounds and Paddle 
 ******************************************************************************************************
 */

	class Ball extends GCompound {
		
		public Ball(int radius) {
			GOval ball = new GOval(2 * radius, 2 * radius);
			ball.setFilled(true);
			add(ball, -radius, -radius);
		}
	}
	
	class Bound extends GCompound {
		GLine bound;
		public Bound(int screen_width, int screen_height) {
			bound = new GLine(0,0,0,0);
			add(bound);
		}
	}
	
	class Paddle extends GCompound {
		
		public Paddle(double width) {
			GRect paddle = new GRect(width, PADDLE_Y_RATIO * width);
			paddle.setFilled(true);
			add(paddle);
		}
	}
	
	class Frame extends GCompound{
		
		public Frame() {
			
		}
			
		public Frame(int screen_width, int screen_height) {
			Frieze friezeWest = new Frieze ();
				friezeWest.friezeBase.setSize(0.3 * MARGIN_L, screen_height - MARGIN_L);
				add(friezeWest, 0.4 * MARGIN_L, 0.4 * MARGIN_L);		
			Frieze friezeEast = new Frieze ();
				friezeEast.friezeBase.setSize(0.3 * MARGIN_L, screen_height - MARGIN_L);
				add(friezeEast, SCREEN_WIDTH - 0.4 * MARGIN_L - friezeEast.getWidth() + 1, 0.4 * MARGIN_L);	
			Frieze friezeNorth = new Frieze ();
				friezeNorth.friezeBase.setSize(screen_width - 4 * 0.3 * MARGIN_L + 1, 0.3 * MARGIN_L);
				add(friezeNorth, 0.4 * MARGIN_L, 0.4 * MARGIN_L);
			Frieze friezeSouth = new Frieze ();
				friezeSouth.friezeBase.setSize(screen_width - 3 * 0.3 * MARGIN_L + 1, 0.3 * MARGIN_L);
				add(friezeSouth, 0.4 * MARGIN_L, screen_height - 0.4 * MARGIN_L - friezeSouth.getHeight() + 1);
		}
	}
	
	class Frieze extends Frame{
		
		public GRect friezeBase;

		public Frieze() {
			super();
			friezeBase = new GRect (0,0);
			friezeBase.setFillColor(Color.lightGray);
			friezeBase.setColor(Color.lightGray);
			friezeBase.setFilled(true);
			add(friezeBase);			
		}
	}
	
}
