/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run () {
		while  (frontIsClear()) {
			horizontalRowA ();
			goBack();
			scaleUp();
			horizontalRowB ();
			goBack();
			scaleUp();
		}
		verticalRow ();	
	
	}
	
	private void horizontalRowA () {
		putBeeper();
		while (frontIsClear()) {
			move ();
			if (frontIsClear()) {
				move ();
				putBeeper();
			}	
		}
	}

	private void horizontalRowB () {
		if (frontIsClear()) {
			move ();
			putBeeper();
		}
		while (frontIsClear()) {
			move ();
			if (frontIsClear()) {
				move ();
				putBeeper();
			}	
		}
	}
	
	private void goBack () {
		turnAround();
		while (frontIsClear()) {
			move ();
		}
	}
	
	private void scaleUp () {
		turnRight();
		if (frontIsClear()) {
			move ();
			turnRight();
		}		
	}

	private void verticalRow () {
		if (frontIsBlocked()) {
			turnLeft();
		}
		if (facingNorth()) {
			putBeeper();
		}
		while (frontIsClear()) {
			move ();
			if (frontIsClear()) {
				move ();
				putBeeper();
			}	
		}
	}

}
