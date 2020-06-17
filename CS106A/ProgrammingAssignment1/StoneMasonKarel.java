/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run () {
		while(frontIsClear()) {
			buildColumn ();
			finishColumn ();
			findNextColumn ();
		}
		buildColumn ();
		finishColumn ();
	}

/*
 * Karel goes from bottom up checking whether there is already beepers along the way and filling the gaps
 */

	private void buildColumn () {
		if (noBeepersPresent()) { 
			putBeeper();
		}
		turnLeft();
		while(frontIsClear()) {
			move();
			if (noBeepersPresent()) { 
				putBeeper();
			} 
		}
	}
	
	private void finishColumn () {
		   turnAround();
		   while(frontIsClear()) {
				move();	
			}
		   turnLeft();
	}	
	
	private void findNextColumn () {
			for (int i = 0; i < 4; i++) { 
				move();
			}
		
	}	
	
	
}
