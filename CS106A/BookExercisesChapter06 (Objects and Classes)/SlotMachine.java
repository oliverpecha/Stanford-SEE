/*
 * File: SlotMachine.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 5
 * -----------------
 * In casinos from Monte Carlo to Las Vegas, one of the most common gambling devices is the slot machine - the “one-armed bandit.” A typical 
 * slot machine has three wheels that spin around behind a  narrow window. Each wheel is marked with the following symbols: 
 * CHERRY, LEMON, ORANGE, PLUM, BELL, BAR. The window, however, allows you to see only one symbol on each wheel at a time. 
 * For example, the window might show the following configuration:
 * If you put a silver dollar onto a slot machine and pull the handle on its side, the wheels pin around and eventually come to rest in some 
 * new configuration. If the configuration matches one of a set of winning patterns printed on the front of the slot machine, you get back 
 * some money. If not, you’re out a dollar. The following table shows a typical set of winning patterns, along with their associated payoffs:
 * -----------------	
 * 		BAR		BAR		BAR 		pays	$250
 * 		BELL 	BELL 	BELL/BAR 	pays	$20
 * 		PLUM	PLUM	PLUM/BAR	pays	$14
 * 		ORANGE	ORANGE	ORANGE/BAR	pays	$10
 * 		CHERRY	CHERRY	CHERRY		pays	$7
 * 		CHERRY	CHERRY	-			pays	$5
 * 		CHERRY	-		-			pays	$2
 * -----------------
 * The notation BELL/BAR means that either a BELL or a BAR can appear in that position, and the dash means that any symbol at all can appear. 
 * This, getting a CHERRY in the first position is automatically good for two dollars, no matter what appears on the other wheels. 
 * The LEMON symbol never pays off, even if you happen to line up three of them.
 * Write a program that simulates playing a slot machine. Your program should provide the user decides to quit. During each round, your program 
 * should take away a dollar, simulate the spinning of the wheels, evaluate the result, and pay the user an appropriate winnings. For example, 
 * a user might be lucky enough to see the following sample run:
 * -----------------
 * Even though doing so is not realistic (and would make the slot machine unprofitable for the casino), you should assume that each of the six 
 * symbols is equally on each wheel.
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class SlotMachine extends ConsoleProgram {

	private RandomGenerator luck = RandomGenerator.getInstance();

	public void run() {

		int balance = INITIAL_BUDGET;
		
		int windowFirst = 0;
		int windowSecond = 0;
		int windowThird = 0;

		
		/* Begins program by asking if user wants instructions */
		String str = readLine("Would you like instructions? ");
		while (!(str.equals("yes")) || !(str.equals("no"))) {
			if (str.equals("yes")) {
				println("Loading instructions..."); 
				println("You can win up to $" + MAX_WIN + " per play. Every play is $" + COST_TO_PLAY); 

				break;
			}
			else if (str.equals("no")) {
				println("Skipping instrucctions...");
				break;
			}
			else if (true) str = readLine("Would you like instructions? ");		
		}
		while (balance > COST_TO_PLAY) {
			/* Round one */
			if (balance > COST_TO_PLAY) {			
				String play = readLine("\nYou have $" + balance + ". Would you like to play? ");
				while (!(play.equals("yes")) || !(play.equals("no"))) {
					if (play.equals("yes")) {
						/* Where magic happens */
						balance -= COST_TO_PLAY;
						int roundBalance = balance;
						windowFirst = symbolReset();
						windowSecond = symbolReset();
						windowThird = symbolReset();
						balance = symbolConversion(balance, windowFirst, windowSecond, windowThird);
						if (balance == roundBalance) println("   " + toString(windowFirst) + " " + toString(windowSecond) + " " + toString(windowThird) + "     - -     You loose"); 
						else println("   " + toString(windowFirst) + " " + toString(windowSecond) + " " + toString(windowThird) + "     - -   You win $" + (balance - roundBalance));
						break;						
					}
					// withdraws balance and ends play
					else if (play.equals("no")) {
						println("\nSure... Your remaing balance is $" + balance + ".");
						balance = 0;
						break;
					}
					// when user types yes or not incorrectly
					else if (true) play = readLine("You must answer yes or not.\nYou have $" + balance + ". Would you like to play? ");	
				}
			}
		}	
		// user doesn't have enough funds to continue play
		println("\nYou only have $" + balance + ". To play, you need at least $" + COST_TO_PLAY + ".");
	}
	
	/* This method returns a new int representing a symbol. */
	public int symbolReset() {
			int dice = luck.nextInt(1,6);
			return dice;
	}
	
	/* This method handles rules on conversions symbol combination to money. */
		public int symbolConversion(int balance, int windowFirst, int windowSecond, int windowThird) {
			 /* 	BAR		BAR		BAR 		pays	$250
			 * 		BELL 	BELL 	BELL/BAR 	pays	$20
			 * 		PLUM	PLUM	PLUM/BAR	pays	$14
			 * 		ORANGE	ORANGE	ORANGE/BAR	pays	$10
			 * 		CHERRY	CHERRY	CHERRY		pays	$7
			 * 		CHERRY	CHERRY	-			pays	$5
			 * 		CHERRY	-		-			pays	$2 */
			if (windowFirst == 6 && windowSecond == 6 && windowThird == 6) balance += MAX_WIN;
			if (windowFirst == 5 && windowSecond == 5 && windowThird == 5 || windowThird == 6) balance += 20;
			if (windowFirst == 4 && windowSecond == 4 && windowThird == 4 || windowThird == 6) balance += 14;
			if (windowFirst == 3 && windowSecond == 3 && windowThird == 3 || windowThird == 6) balance += 10;
			if (windowFirst == 1 && windowSecond == 1 && windowThird == 1) balance += 7;
			if (windowFirst == 1 && windowSecond == 1) balance += 5;
			if (windowFirst == 1) balance += 2;
			return balance;
		}
	
	
	/* This method handles conversion from int to Strings to display Symbols humans can read. */
		public String toString(int cases) {
			String name = null;
			switch (cases) {
				case 1: 	name = (CHERRY); break;
		        case 2: 	name = (LEMON); break;
		        case 3: 	name = (ORANGE); break;
		        case 4: 	name = (PLUM); break;
		        case 5: 	name = (BELL); break;
		        case 6: 	name = (BAR); break;
			}
			return  name;
		}
		
	/* Constants that define rules on budget to play */
		private static final int INITIAL_BUDGET = 50;
		private static final int COST_TO_PLAY = 15;
		private static final int MAX_WIN = 250;
		
	/* Constants that contain Strings on Symbols */
		private static final String CHERRY = "CHERRY";
		private static final String LEMON = "LEMON";
		private static final String ORANGE = "ORANGE";
		private static final String PLUM = "PLUM";
		private static final String BELL = "BELL";
		private static final String BAR = "BAR";
	
}


