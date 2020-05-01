/*
 * File: PeaceSymbol.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise Bonus 4
 * -----------------
 * In the 1960s, this symbol became universally identified as the peace symbol, and it still shows up from time to time as a motif 
 * for T-shirts or jewelry. The peace symbol took its form from the letters N and D—the initial letters in nuclear disarmament—as 
 * expressed in the international semaphore code:
 * The peace symbol is formed by superimposing the lines in these two diagrams (without the flags) and enclosing them in a circle.
 * Implement a method drawPeaceSymbol with the header line
 * 			void drawPeaceSymbol(double x, double y, double r)
 * that draws a peace symbol centered at the point (x, y) with a circle of radius r. Write a subclass of GraphicsProgram to test your method.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class PeaceSymbol extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run () {
		drawPeaceSymbol(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, RADIUS);
	}
	
	void drawPeaceSymbol(double x, double y, double r) {
		GArc arcL = new GArc(x - r, y - r, 2 * r, 2 * r, 90, 135);
		arcL.setFilled(true);
		arcL.setFillColor(Color.white);
		add(arcL);
		GArc arcR = new GArc(x - r, y - r, 2 * r, 2 * r, 90, -135);
		arcR.setFilled(true);
		arcR.setFillColor(Color.white);
		add(arcR);
		GArc arcCL = new GArc(x - r, y - r, 2 * r, 2 * r, 225, 45);
		arcCL.setFilled(true);
		arcCL.setFillColor(Color.white);
		add(arcCL);
		GArc arcCR = new GArc(x - r, y - r, 2 * r, 2 * r, 270, 45);
		arcCR.setFilled(true);
		arcCR.setFillColor(Color.white);
		add(arcCR);
	}
	
	private static final double RADIUS = 150;

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
}
