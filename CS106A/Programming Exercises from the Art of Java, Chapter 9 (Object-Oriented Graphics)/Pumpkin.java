
/*
 * File: Pumpkin.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 5
 * -----------------
 * Write a GraphicsProgram that draws a picture of the Halloween pumpkin shown in the following diagram:
 * The head is an orange circle, and the eyes and mouth are filled polygons. The stem is presumably a GRect. 
 * Use named constants in your program to define the sizes of the various features.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Pumpkin extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run() {
		double totalHeight = 2 * PUMPKIN_RADIUS + STEM_EXTRA;
		add(stem(PUMPKIN_RADIUS + STEM_EXTRA, 0.5 * STEM_EXTRA),  SCREEN_WIDTH / 2 - STEM_EXTRA / 4, SCREEN_HEIGHT / 2 - PUMPKIN_RADIUS - STEM_EXTRA);
		add(pumpkin(PUMPKIN_RADIUS),  SCREEN_WIDTH / 2 - PUMPKIN_RADIUS, SCREEN_HEIGHT/ 2 - totalHeight / 2);
		add(triangle(TRIANGLE_SIZE, false), SCREEN_WIDTH / 2 - TRIANGLE_SIZE / 2, SCREEN_HEIGHT / 2);
		add(triangle(TRIANGLE_SIZE, true), SCREEN_WIDTH / 2 - EYE_DISTANCE, SCREEN_HEIGHT / 2 - EYE_DISTANCE - TRIANGLE_SIZE);
		add(triangle(TRIANGLE_SIZE, true), SCREEN_WIDTH / 2 + EYE_DISTANCE + TRIANGLE_SIZE, SCREEN_HEIGHT / 2 - EYE_DISTANCE - TRIANGLE_SIZE);
		add(mouth(10, (double) SCREEN_WIDTH / 2 - 68, SCREEN_HEIGHT / 2 + 0.4 * PUMPKIN_RADIUS));
	}
	
	private GObject stem(double height, double width) {	
		GRect stem = new GRect(width, height);
		stem.setFilled(true);
		return stem;
	}
	
	private GObject pumpkin(double radius) {	
		GOval pumpkin = new GOval(2 * radius, 2 * radius);
		pumpkin.setFilled(true);
		pumpkin.setColor(Color.ORANGE);
		pumpkin.setFillColor(Color.ORANGE);
		return pumpkin;
	}

	private GObject triangle(double width, boolean rotate) {	
		GPolygon tri = new GPolygon();
		tri.addPolarEdge(width, 0);
		tri.addPolarEdge(width, 120);
		tri.addPolarEdge(width, 240);
		tri.setFilled(true);
		if (rotate) tri.rotate(180);
		return tri;
	}
	
	private GCompound mouth(double holeSize, double x, double y) {	
		GCompound mouth = new GCompound();
		for (int i = 1; i < 9; i++) {
			if (i % 2 == 0) add(mouthRect(holeSize, true), x + i * (holeSize * 1.5), y);
			else add(mouthRect(holeSize, false), x + i * (holeSize * 1.5), y);
		}
		return mouth;
	}
	
	private GObject mouthRect(double width, boolean clock) {	
		GPolygon mouthRect = new GPolygon();
		mouthRect.addVertex(-width, -width * 2);
		mouthRect.addVertex(width, -width * 2);
		mouthRect.addVertex(width, width * 2);
		mouthRect.addVertex(-width, width * 2);
		if (clock) mouthRect.rotate(-45);
		else mouthRect.rotate(45);
		mouthRect.setFilled(true);
		return mouthRect;
	}
	
	private static final double STEM_EXTRA = 45;
	private static final double EYE_DISTANCE = 30;
	private static final double PUMPKIN_RADIUS = 150;
	private static final double TRIANGLE_SIZE = 50;
	private static final double HOLE_SIZE = 10;

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
}
