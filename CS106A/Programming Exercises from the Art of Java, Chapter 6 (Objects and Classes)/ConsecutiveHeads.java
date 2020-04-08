/*
 * File: ConsecutiveHeads.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 2
 * -----------------
 *  Heads. . . . 
 *  Heads. . . . 
 *  Heads. . . .
 *  A weaker man might be moved to re-examine his faith, if in nothing else at least in the law of probability.
 *  —Tom Stoppard, Rosencrantz and Guildenstern are Dead, 1967
 *  Write a program that simulates flipping a coin repeatedly and continues until three consecutive heads are tossed. 
 *  At that point, your program should display the total number of coin flips that were made. 
 *  The following is one possible sample run of the program:
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class ConsecutiveHeads extends ConsoleProgram {

	private RandomGenerator luck = RandomGenerator.getInstance();
	
	public void run() {
		
		boolean thisFlip = luck.nextBoolean();
		int heads = 0;
		int totalFlips = 0;
		
		while (heads < CONSECUTIVE_HEADS) {
			thisFlip = luck.nextBoolean();
			if (thisFlip == true) {
				println("Heads.");
				heads++;
				totalFlips++;
			}
			else {
				println("Tails.");
				heads = 0;
				totalFlips++;
			}
		}
		
		println("It took " + totalFlips + " flips to get " + CONSECUTIVE_HEADS + " consecutive heads.");
	}

	private static final int CONSECUTIVE_HEADS = 3;
}
