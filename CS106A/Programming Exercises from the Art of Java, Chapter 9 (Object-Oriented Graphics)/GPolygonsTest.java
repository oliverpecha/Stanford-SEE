
/*
 * File: GPolygonsTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 4
 * -----------------
 * Using the Gstar class from 9-16 as a model, define new classes GDiamond, GTrapezoid, and GTShape that extend GPolygon to produce 
 * the other polygon examples shown in the margin of page 277. Part of the problem is figuring out what parameters are appropriate 
 * for each of the constructors.
 * 
 */

import acm.program.*;
import acm.graphics.*;

public class GPolygonsTest extends GraphicsProgram {

	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run() {
		int i = 1;
			GPolygon gdiamond = new GDiamond(POLYGON_WIDTH);
			add(gdiamond, i * MARGIN, MARGIN);
			i++;
			GPolygon gtrapezoid = new GTrapezoid(POLYGON_WIDTH);
			add(gtrapezoid, i * MARGIN, MARGIN);
			i++;
			GPolygon gtshape = new GTShape(POLYGON_WIDTH);
			add(gtshape, i * MARGIN, MARGIN);
			i++;
			GPolygon gstar = new GStar(POLYGON_WIDTH);
			add(gstar, i * MARGIN, MARGIN);
	}

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
	
	private static final int POLYGON_WIDTH = 80;
	private static final int MARGIN = 120;
	
}
