/*
 * File: RandomCard.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 1
 * -----------------
 * Write a program that displays the name of a card randomly chosen from a complete deck of 52 playing cards. 
 * Each card consists of a rank (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King) 
 * and a suit (Clubs, Diamonds, Hearts, Spades). Your program should display the complete name of the card, 
 * as shown in the following sample run:
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class RandomCard extends ConsoleProgram {

	private RandomGenerator luck = RandomGenerator.getInstance();

	public void run() {

		int rankInt = luck.nextInt(13);
		int suitInt = luck.nextInt(4);
		String rank = null;
		String suit = null;
		switch (rankInt) {
			case 1: 	rank = ("Ace"); break;
	        case 2: 	rank = ("Two"); break;
	        case 3: 	rank = ("Three"); break;
	        case 4: 	rank = ("Four"); break;
	        case 5: 	rank = ("Five"); break;
	        case 6: 	rank = ("Six"); break;
	        case 7: 	rank = ("Seven"); break;
	        case 8: 	rank = ("Eight"); break;
	        case 9: 	rank = ("Nine"); break;
	        case 10: 	rank = ("Ten"); break;
	        case 11:	rank = ("Jack"); break;
	        case 12:	rank = ("Queen"); break;
	        case 13: 	rank = ("Jack"); break; 	 
		}
		switch (suitInt) {
			case 1: 	suit = ("Clubs"); break;
	        case 2: 	suit = ("Diamonds"); break;
	        case 3: 	suit = ("Hearts"); break;
	        case 4: 	suit = ("Spades"); break;
		}
		println("This program displays a randomly chosen card.");
		println(rank + " of " + suit);
		
		
	}
	
	
	
}
