/*
 * File: DrawMap.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 6
 * -----------------
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class DrawMap extends GraphicsProgram {

	
	public void init() {
		setSize(600, 400);
	}

	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		MapFractal coastLine1 = new MapFractal(EDGE, ORDER);
		add(coastLine1, cx, cy);
	}

/* Private constants */
	private static final int EDGE = 400;
	private static final int ORDER = 5;

/**
 * Private class to Draw a line with a recursive method that mimics a coastline trough fractorial lines	
 * @author oliverpecha
 *
 */
	
private class MapFractal extends GCompound {

	public MapFractal(double lenght, int order) {
		addFractalLine(0 - lenght / 2, 0, lenght, 0, order);
	}
	
	private void addFractalLine(double x, double y, double lenght, int theta, int order) {	
		double edge = lenght / 3;
		double leg = (Math.sqrt(3) / 2) * lenght / 3;
		boolean direction = luck.nextBoolean();
		if (order == 0) {	
			line.drawPolarLine(lenght, theta);
			add(line);	
		} else {
			addFractalLine(x, y, edge, theta, order - 1);
			if (direction) {
				addFractalLine(x + edge, y, edge,   theta + 60, order - 1);
				addFractalLine(x + 1.5 * edge, (y - leg)  , edge,  theta - 60, order - 1);
			}
			else {
				addFractalLine(x + edge, y, edge,   theta - 60, order - 1);
				addFractalLine(x + 1.5 * edge, (y - leg)  , edge,  theta + 60, order - 1);
			}
			addFractalLine(x + edge * 2, y, edge,  theta, order - 1);	
		}
	}
	
	GPen line = new GPen(0 - EDGE / 2, 0);
	RandomGenerator luck = new RandomGenerator();
}
	
}