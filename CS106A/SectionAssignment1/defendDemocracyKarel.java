/*
* File: VoteCountingKarel.java
* ----------------------------
* The VoteCountingKarel subclass cleans out the chad from
* a ballot as described in the section handout.
*/
import stanford.karel.*;

public class defendDemocracyKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
		move();
		if (noBeepersPresent()) {
		removeChad();
		}
		move();
		}
	}
	

	private void removeChad() {
				turnLeft();
				checkPunchCorner();
				checkPunchCorner();
				turnRight();				
	}
	

	private void checkPunchCorner() {
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
	}
}
