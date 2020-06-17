/*
 * File: LineGraph.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 7.
 * -----------------
 * When you are trying to represent the behavior of some quantity that varies over time, one of the usual tools is the line graph, 
 * in which a set of data values are plotted on an x-y grid with each pair of adjacent points connected by a straight line. 
 * For example, given the following set of 10 points:
 * (0.0, 0.67) 
 * (0.4, 0.68) 
 * (0.8, 0.71) 
 * (1.2, 0.86) 
 * (1.6, 0.86) 
 * (2.0, 1.04) 
 * (2.4, 1.30) 
 * (2.8, 1.81) 
 * (3.2, 1.46) 
 * (3.6, 1.86)
 * the line graph that represents them looks like this:
 * -----------------
 * Write a method DrawLineGraph that generates a line graph given an array of x-coordinate values and a second array of 
 * the corresponding y-coordinate values.
 */

import acm.program.*;
import acm.graphics.*;
	
public class LineGraph extends GraphicsProgram {
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	
	public void run() {
		int [] dau = {
				999,
				2499,
				3401,
				5210,
				8600,
				8223,
				8758,
				10844,
				11980,
				11979,
				15591,
				16784,
				18941,
		};
		drawGraphBase();
		drawLineGraph(dau);
	}
	
	private void drawGraphBase() {
		add(new GLine(MARGIN_SIDES - MARGIN_PLUS, SCREEN_HEIGHT - MARGIN_BOTTOM, SCREEN_WIDTH - MARGIN_SIDES + MARGIN_PLUS, SCREEN_HEIGHT - MARGIN_BOTTOM));
	}
	
	private void drawLineGraph (int [] array) {
		int arrayLenght = array.length;
		double separation = (SCREEN_WIDTH - MARGIN_SIDES) / arrayLenght;
		double verticalAvailable = SCREEN_HEIGHT - MARGIN_TOP - MARGIN_BOTTOM;
		double maxValue = maxValue(array);
		double previousHeight = 0;
		for (int i = 0; i < array.length; i++) {
			double valueHeight = (array [i] * verticalAvailable) / maxValue;
			DataPoint current = new DataPoint(previousHeight);
			if (current.line != null) current.line.setEndPoint(-separation, valueHeight - previousHeight);
			add(current, i * separation + MARGIN_SIDES, SCREEN_HEIGHT - MARGIN_BOTTOM - valueHeight);
			previousHeight = valueHeight;
		}
	}
	
	private int maxValue (int [] array) {
		int maxValue = array [0];
		for (int i = 0; i < array.length; i++) {
			if (array [i] > maxValue) maxValue = array [i];
		}
		return maxValue;
	}
	
	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 220;
	private static final double MARGIN_SIDES = 0.05 * SCREEN_WIDTH;
	private static final double MARGIN_PLUS = 0.01 * SCREEN_WIDTH;
	private static final double MARGIN_TOP = 0.09 * SCREEN_HEIGHT;
	private static final double MARGIN_BOTTOM = 0.06 * SCREEN_HEIGHT;
	private static final double DOT_RADIUS = 0.01 * SCREEN_HEIGHT;


	private class DataPoint extends GCompound {
		
		public DataPoint() {
			GOval dot = new GOval(2 * DOT_RADIUS, 2 * DOT_RADIUS);
			dot.setFilled(true);
			add(dot, -DOT_RADIUS, -DOT_RADIUS);
		}
		
		public DataPoint(double previousY) {	
			this();
			if (previousY > 0) {
				line = new GLine(0,0,60,60);
				add(line);
			}

		}
		GLine line;
	}
}
