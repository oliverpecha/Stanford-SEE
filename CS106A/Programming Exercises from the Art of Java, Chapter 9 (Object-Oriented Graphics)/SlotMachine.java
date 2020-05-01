/*
 * File: SlotMachine.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 14
 * -----------------
 * The slot machine program introduced as exercise 5 in Chapter 6 becomes much more exciting of you change it from a ConsoleProgram to a 
 * GraphicsProgram. Suppose that you have the following image files:
 * In addition to these six images, it is also useful to have a image file called Empty.gif that is simply an empty box of the same size.
 * Rewrite the slot machine program so that it uses these images along with a few GLabel objects to display the outcome of each spin of the 
 * machine. Your program should begin by putting up three boxes containing the Empty.gif image to create a display that looks like this:
 * When you click the mouse (which you can detect by calling the waitforClick method introduced in Figure 9-2), you should generate three 
 * random symbols and install them in the boxes, updating the GLabels to keep the user informed of the progress of the game. For example, 
 * after clicking the mouse, you might see the following configuration:
 * You can add suspense to the game by resetting the boxes to the empty symbol before each spin and then calling pause after displaying 
 * each symbol.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.RandomGenerator;
import java.awt.Color;

public class SlotMachine extends GraphicsProgram {

	private RandomGenerator luck = RandomGenerator.getInstance();

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	
	public void run() {
		int balance = INITIAL_BUDGET;
		/* Graphics */
		int margin = (SCREEN_WIDTH - SLOT_WIDTH * 3) / 4;
		GRect background = new GRect(SCREEN_WIDTH, SCREEN_HEIGHT);
			background.setFilled(true);
			background.setColor(Color.lightGray);
			background.setFillColor(Color.lightGray);
			add(background);	
		GImage firstSlot = new GImage("empty.gif");
			firstSlot.setSize(SLOT_WIDTH, SLOT_WIDTH);
			add(firstSlot, margin, margin);
		GImage secondSlot = new GImage("empty.gif");
			secondSlot.setSize(SLOT_WIDTH, SLOT_WIDTH);
			add(secondSlot, margin * 2 + SLOT_WIDTH, margin);
		GImage thirdSlot = new GImage("empty.gif");
			thirdSlot.setSize(SLOT_WIDTH, SLOT_WIDTH);
			add(thirdSlot, margin * 3 + SLOT_WIDTH * 2, margin);
		GLabel dialogOne = new GLabel("Welcome to the slot \nmachine!");
			dialogOne.setFont("-20");
			add(dialogOne, margin, margin * 2.5 + firstSlot.getHeight());
		GLabel dialogTwo = new GLabel("You now have $" + balance + ".");
			dialogTwo.setFont("-20");
			add(dialogTwo, margin, margin * 3.5 + firstSlot.getHeight());
		GLabel dialogThree = new GLabel("Click to play.");
			dialogThree.setFont("-20");
			add(dialogThree, margin, margin * 4.5 + firstSlot.getHeight());
			
		int windowFirst = 0;
		int windowSecond = 0;
		int windowThird = 0;
		int roundBalance = 0;
		while (balance > COST_TO_PLAY) {	
			waitForClick();
			balance -= COST_TO_PLAY;
			roundBalance = balance;
			windowFirst = symbolReset();
			windowSecond = symbolReset();
			windowThird = symbolReset();
			balance = symbolConversion(balance, windowFirst, windowSecond, windowThird);
			pause(PAUSE_SHORT);
			firstSlot.setImage(toResource(windowFirst));
			firstSlot.setSize(SLOT_WIDTH, SLOT_WIDTH);
			pause(PAUSE);
			secondSlot.setImage(toResource(windowSecond));
			secondSlot.setSize(SLOT_WIDTH, SLOT_WIDTH);
			pause(PAUSE_LONG);
			thirdSlot.setImage(toResource(windowThird));
			thirdSlot.setSize(SLOT_WIDTH, SLOT_WIDTH);
			if (balance == roundBalance) dialogOne.setLabel("You loose.");
			else dialogOne.setLabel("You win $" + (balance - roundBalance) + "."); 
			dialogTwo.setLabel("You now have $" + balance + ".");
		}	
		// user doesn't have enough funds to continue play
		if (balance < COST_TO_PLAY)
			dialogTwo.setLabel("You only have $" + balance + ".");
			dialogThree.setColor(Color.red);
			dialogThree.setLabel("To play, you need at least $" + COST_TO_PLAY + ".");
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
		private String toResource(int cases) {
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
		private static final String CHERRY = "cherry.gif";
		private static final String LEMON = "lemon.gif";
		private static final String ORANGE = "orange.gif";
		private static final String PLUM = "plum.gif";
		private static final String BELL = "bell.gif";
		private static final String BAR = "bar.gif";

	/* Constants that contain Screen Size value */
		private static final int SLOT_WIDTH = 100;
	
		/* Constants that contain Screen Size value */
		private static final int PAUSE_LONG = 900;
		private static final int PAUSE = 500;
		private static final int PAUSE_SHORT = 200;
		
	/* Constants that contain Screen Size value */
		private static final int SCREEN_WIDTH = 400;
		private static final int SCREEN_HEIGHT = 250;
	
}


