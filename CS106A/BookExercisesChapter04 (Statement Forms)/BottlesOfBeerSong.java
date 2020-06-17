/*
 * File: BottlesOfBeerSong.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 1 on chapter 4 of Programming Exercises from the Art of Java.
 */

import acm.program.*;

public class BottlesOfBeerSong extends ConsoleProgram {

	
	public void run () {
		
		println("This program creates the lyrics for a silly beer song");
		for (int i = BEERS; i > 0 ; i--) {
			if (i == 1) {
				println( i + " bottle of beer on the wall.");
				println( i + " bottle of beer.");
			} else {
				println( i + " bottles of beer on the wall.");
				println( i + " bottles of beer.");
			}
			println("You take one down, pass it around.");			
			println(" ");			
		}
	}
							
	/* Private constants */
	private static final int BEERS = 99;
	
}