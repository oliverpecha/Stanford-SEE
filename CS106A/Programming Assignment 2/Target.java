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

        GOval OuterCircle = new GOval (300, 200, 90, 90);
        OuterCircle.setColor(Color.RED);
        OuterCircle.setFilled(true);
        OuterCircle.setFillColor(Color.RED);
        add(OuterCircle);
	      
        GOval middleCircle = new GOval (315, 215, 60, 60);
        middleCircle.setColor(Color.WHITE);
        middleCircle.setFilled(true);
        middleCircle.setFillColor(Color.WHITE);
        add(middleCircle);
        
        GOval innerCircle = new GOval (330, 230, 30, 30);
        innerCircle.setColor(Color.RED);
        innerCircle.setFilled(true);
        innerCircle.setFillColor(Color.RED);
        add(innerCircle);

	}
}
