/*
 * File: Target.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 6 on chapter 2 of Programming Exercises from the Art of Java.
 */


import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		
		
		int xAxis = xScreenSize / 2 - SIZE / 2;
		int yAxis = yScreenSize / 2 - SIZE / 2;
		
		// Representation of the Theoretical Screen Size
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));

        GOval OuterCircle = new GOval (xAxis, yAxis, SIZE, SIZE);
        OuterCircle.setColor(Color.RED);
        OuterCircle.setFilled(true);
        OuterCircle.setFillColor(Color.RED);
        add(OuterCircle);
	      
        GOval middleCircle = new GOval (xAxis + STROKE / 2, yAxis + STROKE / 2, SIZE / 3 * 2, SIZE / 3 * 2);
        middleCircle.setColor(Color.WHITE);
        middleCircle.setFilled(true);
        middleCircle.setFillColor(Color.WHITE);
        add(middleCircle);
        
        GOval innerCircle = new GOval (xAxis + STROKE, yAxis + STROKE, SIZE / 3 * 1, SIZE / 3 * 1);
        innerCircle.setColor(Color.RED);
        innerCircle.setFilled(true);
        innerCircle.setFillColor(Color.RED);
        add(innerCircle);

	}
	// Parameters that define size of the Target
	private static final int SIZE = 90;
	private static final int STROKE = 30;
	
	// Parameters that define size of the Theoretical Screen Size
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 400;
}
