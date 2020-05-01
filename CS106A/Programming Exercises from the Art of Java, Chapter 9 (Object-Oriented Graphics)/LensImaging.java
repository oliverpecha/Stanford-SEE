/*
 * File: LensImaging.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 16
 * -----------------
 * You can use the GLens class from the preceding exercise to illustrate how lenses form images. Light rays that enter a lens parallel to 
 * its horizontal axis are bent so that they pass through a single point called the focal point of the lens; the distance from the center 
 * of the lens to the focal point is called the focal length. Those light rays continue on and form an upside-down image to an observer 
 * on the far side of the focal point, as shown in the following sample run:
 * -----------------
 * Write a GraphicsProgram that produces this illustration. Assume you have two image files - Candle.gif and InvertedCandle.gif - that 
 * contain the candle image on the right side of this diagram and that and that same image flipped in the vertical direction, but with 
 * the same size as the original. Your program should scale the InvertedCandle.gif image so that it has the correct size, given the 
 * position of the observer. In Chapter 11, you will learn how to invert an image, which will make it possible to use only a single 
 * image file for this problem.
 */

import acm.program.*;
import java.awt.Color;
import acm.graphics.*;

public class LensImaging extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	
	public void run() {
		int x = SCREEN_WIDTH / 2;
		int y = SCREEN_HEIGHT / 2;
		double lensWidth = 30;
		double lensHeight = 90;
		double radius = (lensHeight * lensHeight + lensWidth * lensWidth) / (4 * lensWidth);
		double adjacent = radius - lensWidth / 2;
		double delta = GMath.angle(adjacent, - lensHeight / 2);
		
		GPolygon optic = new GPolygon();
		optic.addArc(2 * radius, 2 * radius, delta, - delta * 2 );
		optic.addArc(2 * radius, 2 * radius, 180 + delta, -delta * 2 );
		optic.setFilled(true);
		optic.setColor(Color.blue);
		add(optic, x, y - lensHeight / 2);
	
	}
	
	
	/* Constants that contain Screen Size value */
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
}

