/*
 * File: OlympicRings.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 7 and 8 on chapter 2 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class OlympicRings extends GraphicsProgram {	
	public void run() {
		blueRing();
		yellowRing();
		blackRing();
		greenRing();
		redRing();
	}	

		//Blue Ring
		private void blueRing() {	  
	        GOval firstCircle = new GOval (200, 100, 100, 100);
	        firstCircle.setColor(Color.BLUE);
	        add(firstCircle);
	        GOval secondCircle = new GOval (201, 101, 98, 98);
	        secondCircle.setColor(Color.BLUE);
	        add(secondCircle);
	        GOval thirdCircle = new GOval (202, 102, 96, 96);
	        thirdCircle.setColor(Color.BLUE);			        
	        add(thirdCircle);
		}
		
		//Yellow Ring
		private void yellowRing() {	
	        GOval firstCircle = new GOval (250, 160, 100, 100);
	        firstCircle.setColor(Color.YELLOW);
	        add(firstCircle);
	        GOval secondCircle = new GOval (251, 161, 98, 98);
	        secondCircle.setColor(Color.YELLOW);
	        add(secondCircle);
	        GOval thirdCircle = new GOval (252, 162, 96, 96);
	        thirdCircle.setColor(Color.YELLOW);			        
	        add(thirdCircle);
		}

		//Black Ring
		private void blackRing() {	
	        GOval firstCircle = new GOval (310, 100, 100, 100);
	        firstCircle.setColor(Color.BLACK);
	        add(firstCircle);
	        GOval secondCircle = new GOval (311, 101, 98, 98);
	        secondCircle.setColor(Color.BLACK);
	        add(secondCircle);
	        GOval thirdCircle = new GOval (312, 102, 96, 96);
	        thirdCircle.setColor(Color.BLACK);			        
	        add(thirdCircle);
		}
		
		//Green Ring
		private void greenRing() {	
	        GOval firstCircle = new GOval (360, 160, 100, 100);
	        firstCircle.setColor(Color.GREEN);
	        add(firstCircle);
	        GOval secondCircle = new GOval (361, 161, 98, 98);
	        secondCircle.setColor(Color.GREEN);
	        add(secondCircle);
	        GOval thirdCircle = new GOval (362, 162, 96, 96);
	        thirdCircle.setColor(Color.GREEN);			        
	        add(thirdCircle);
		}
		
		//Red Ring
		private void redRing() {	
	        GOval firstCircle = new GOval (420, 100, 100, 100);
	        firstCircle.setColor(Color.RED);
	        add(firstCircle);
	        GOval secondCircle = new GOval (421, 101, 98, 98);
	        secondCircle.setColor(Color.RED);
	        add(secondCircle);
	        GOval thirdCircle = new GOval (422, 102, 96, 96);
	        thirdCircle.setColor(Color.RED);			        
	        add(thirdCircle);
		}

}
