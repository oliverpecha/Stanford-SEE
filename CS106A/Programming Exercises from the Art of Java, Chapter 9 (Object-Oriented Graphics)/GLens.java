/*
 * File: GLens.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 15
 * -----------------
 * Define a new Glens class to represent a convex lens that looks something like this:
 * Geometrically, the lens is formed by the intersection of two somewhat larger circles as you cans ee from this diagram:
 * The radius of each circle is a function of the width and height of the lens. You can easily work out the relationship by 
 * using the Pythagorean Theorem along with a little algebra; to save you trouble, the formula for the radius r is:
 * r = h(2) + w(2) / 4w
 * Once you know the radius, you can calculate the location of the center of each circle by using the geometrical relationship 
 * shown in the following diagram:
 * In terms of the implementation, the GLens class should extend GPolygon and use the addArc method to construct the outline. 
 * The Constructor should take the width and height of the lens as parameters. To compute the angle ‘0, you can either use 
 * trigonometry or call the GMath.angle method shown in Figure 9-5. Write a test program that draws several lenses on the display, 
 * using different values for the width and height of each lens.
 */

import acm.program.*;

import java.awt.Color;

import acm.graphics.*;

public class GLens extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	
	public void run() {
		int x = SCREEN_WIDTH / 2;
		int y = SCREEN_HEIGHT / 2;
		double lensHeight = 120;
		double lensWidth = 0.25 * lensHeight;
		double radius = (lensHeight * lensHeight + lensWidth * lensWidth) / (4 * lensWidth);
		double adjacent = radius - lensWidth / 2;
		double delta = GMath.angle(adjacent, - lensHeight / 2);
		
		double candleHeight = 0.95 * lensHeight;
		double candleWidht = 0.13 * lensHeight;
		double candleDistance = 120;
		double candleMargin = 5;
		double candleScaling = 0.7;
		double candleSmall = candleScaling * candleHeight;
		double rayAmount = 6;
		double rayDistance = candleHeight / rayAmount;
		double rayDistanceSmall = candleSmall / rayAmount;

		GPolygon optic = new GPolygon();
		optic.addArc(2 * radius, 2 * radius, delta, - delta * 2 );
		optic.addArc(2 * radius, 2 * radius, 180 + delta, -delta * 2 );
		optic.setFilled(true);
		optic.setColor(Color.blue);
		add(optic, x, y - lensHeight / 2);
		
		GImage candleR = new GImage("Candle.gif");
		candleR.setSize(candleWidht, candleHeight);
		add(candleR, x + candleDistance, y - candleHeight / 2);
		GImage candleL = new GImage("CandleFlipped.gif");
		candleL.setSize(candleScaling * candleWidht, candleScaling * candleHeight);
		add(candleL, x - adjacent - (candleScaling * candleWidht) - candleMargin, y - candleSmall / 2);
		
		for (int i = 0; i <= 6; i++) {
			add(new GLine(x, 
					y + candleHeight / 2 - i * rayDistance,
					x + candleDistance - candleMargin, 
					y + candleHeight / 2 - i * rayDistance));
		}
		for (int i = 0; i <= 6; i++) {
			add(new GLine(x, 
					y + candleHeight / 2 - i * rayDistance,
					x - adjacent, 
					y - candleSmall / 2 + i * rayDistanceSmall));
		}
	
	}
	
	
	/* Constants that contain Screen Size value */
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 300;
}
