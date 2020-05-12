/*
 * File: BouncingILoveJava.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 09 / Programming Exercise Bonus 15
 * -----------------
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class BouncingILoveJava extends GraphicsProgram{
	
	/* Instance variables to define state and direction of the movement */
	double dx = 1;
	double dy = 1;
	double x = 0;
	double y = 0;

	/* Instance Objects */
	RandomGenerator luck = new RandomGenerator();
	Label label;
	/* Operations before program starts */
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addBounds();
	}
	
	/* Operations to perform while program is running */
	public void run() {	
		// Local Variables initialized
		GPoint label_at;
		GPoint label_1 = new GPoint(), label_2 = new GPoint(), label_3 = new GPoint(), label_4 = new GPoint();
		GObject collision_1, collision_2, collision_3, collision_4;	
		// label keeps bouncing until there are no more turns
		while (true) {
			// Adds a new label at a random X position using helper labelPositionStarter
			
			// label keeps moving and bouncing until loop is exited and label position is randomized again
			label = new Label ();
			labelPositionStarter();
			label.setLocation(x, y);
			add(label);
			// movement direction in x and y axis
			label.move(dx, dy);
			// at every move, label Center, North, East, South and West positions are recorded
			label_at = label.getLocation();
			label_1.setLocation(label_at.getX() - 1, label_at.getY() - label.getHeight() - 1);
			label_2.setLocation(label_at.getX() + label.getWidth() + 1,  label_at.getY() - label.getHeight() - 1);
			label_3.setLocation(label_at.getX() - 1, label_at.getY() + 1);
			label_4.setLocation(label_at.getX() + label.getWidth() + 1, label_at.getY() + 1);
			// N, E, S, W positions evaluate if they are bounding with any element
			collision_1 = getElementAt(label_1);
			collision_2 = getElementAt(label_2);
			collision_3 = getElementAt(label_3);
			collision_4 = getElementAt(label_4);
			// When label bounds with an element in any of its points, alters direction accordingly of which point has found an obstacle
			if (collision_1 != null && collision_2 != null) {
				dy = 1; 
			}
			if (collision_2 != null && collision_4 != null) {
				dx = -1; 
			}
			if (collision_4 != null && collision_3 != null) {
				dy = -1;
			}
			if (collision_3 != null && collision_1 != null) {
				 dx = 1; 
			}
			pause(LABEL_SPEED);
		}
	}
	
	/* label direction and position in the X axis  gets randomized */
	private void labelPositionStarter() {
		x = luck.nextInt(0, SCREEN_WIDTH - (int) label.getWidth());
		y =  luck.nextInt((int) label.getHeight(), SCREEN_HEIGHT - (int) label.getHeight());
		boolean inverse = false;
		inverse = luck.nextBoolean();
		if (inverse) dx = -1;
		inverse = luck.nextBoolean();
		if (inverse) dy = -1;
	}
	
	/* adds four bounds around the screen which other methods identify as walls for the label to bounce from */
	private void addBounds() {
		Bound bound_N = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);
		   	  bound_N.bound.setStartPoint(0, 0);
		   	  bound_N.bound.setEndPoint(SCREEN_WIDTH, 0);
		add  (bound_N);
		Bound bound_E = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);	
			  bound_E.bound.setStartPoint(SCREEN_WIDTH, 0);
			  bound_E.bound.setEndPoint(SCREEN_WIDTH, SCREEN_HEIGHT);
		add  (bound_E);
		Bound bound_S = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);	
			  bound_S.bound.setStartPoint(SCREEN_WIDTH, SCREEN_HEIGHT);
			  bound_S.bound.setEndPoint(0, SCREEN_HEIGHT);
		add  (bound_S);
		Bound bound_W = new Bound(SCREEN_WIDTH, SCREEN_HEIGHT);	
		  	  bound_W.bound.setStartPoint(0, SCREEN_HEIGHT);
		  	  bound_W.bound.setEndPoint(0, 0);
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

		
	/* Speed of the movement for Label */
		private static final int LABEL_SPEED = 8;

	class Label extends GCompound {
		
		public Label() {
			GLabel label = new GLabel("I Love Java");
			label.setFont((String)"OldLondon-36");
			add(label);
		}
	}
	
	class Bound extends GCompound {
		GLine bound;
		public Bound(int screen_width, int screen_height) {
			bound = new GLine(0,0,0,0);
			add(bound);
		}
	}
}
