
/*
 * File: StIves.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This program calculates how many representatives were coming from St. Ives.
 */

import acm.program.*;

public class StIves extends ConsoleProgram {

	public void run () {
		int man = 1;
		int wives = 7;
		int sacks = wives * 7;
		int cats = sacks * 7;
		int kits = cats * 7;
		int totalRepresentatives = man + wives + sacks + cats + kits;
		println(totalRepresentatives + " representatives were coming from St. Ives.");	
	}
}
