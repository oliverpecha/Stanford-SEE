/*
 * File: MathQuiz.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 7 / Programming Exercise 3
 * -----------------
 *  Rewrite the Math Quiz program from exercise 6-5 so that it poses its questions in base 8 instead of base 10, 
 *  as shown in the following sample run:
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class MathQuiz extends ConsoleProgram {

	private RandomGenerator luck = RandomGenerator.getInstance();
	
	
		public void run() {
			
			println("Welcome to Math Quiz.");
		
			int questionsLeft = TOTAL_QUESTIONS;
			while (questionsLeft > 0) {
				//local variables
				int answer = 0;
				int chances = CHANCES - 1;
				int n1 = luck.nextInt(1,20);
				int n2 = luck.nextInt(1,20);
				String 	octal_value1 = Integer.toString(n1,8);
				String 	octal_value2 = Integer.toString(n2,8);
				int eight1 = Integer.valueOf(octal_value1, 8);
				int eight2 = Integer.valueOf(octal_value2, 8);
				int phrase = luck.nextInt(1,4);
				boolean operator = luck.nextBoolean();
				String encouragement = null;
				switch (phrase) {
					case 1: 	encouragement = ("That's the answer!"); break;
			        case 2: 	encouragement = ("Correct!"); break;
			        case 3: 	encouragement = ("You got it!"); break;
			        case 4: 	encouragement = ("Great!"); break;
				}
				
				// Two paths below: one for sums of integers and the other for substraction 
				// Path 1 (sum)
				if (operator && n1 + n2 < 20) {	
					System.out.println("questions left " + questionsLeft);
					questionsLeft--;
		
					answer = readInt("\nWhat is " + eight1 + " + " + eight2 + "? ");
					if (eight1 + eight2 == answer) println(encouragement); 
					while (eight1 + eight2 != answer && chances > 0) {
						chances--;
						answer = readInt("That's incorrect - try a different answer: ");
						if (eight1 + eight2 == answer) println(encouragement); 
						if (eight1 + eight2 != answer && chances == 0) println("No, the answer is " + (eight1 + eight2) + "."); 
					}				
				}
				// Path 2 (substraction)
				if (!operator && n1 - n2 > 0) {	
					System.out.println("questions left " + questionsLeft);
					questionsLeft--;
					//eight1 = Integer.toString(n1,8);
					//eight2 = Integer.toString(n2,8);
					answer = readInt("\nWhat is " + eight1 + " - " + eight2 + "? ");
					if (eight1 - eight2 == answer) println(encouragement); 
					while (eight1 - eight2 != answer && chances > 0) {
						chances--;
						answer = readInt("That's incorrect - try a different answer: ");
						if (eight1 - eight2 == answer) println(encouragement); 
						if (eight1 - eight2 != answer && chances == 0) println("No, the answer is " + (eight1 - eight2) + "."); 
					}				
				} 
			}
			println("\nNo more questions...\nYou have completed the Quiz... Wohoa!");
		}
		
	/* Constant values that control how many questions the student must answer to pass the exercise and how many chances or tries for each
	 * question the student gets. */
		private final static int TOTAL_QUESTIONS = 5;	
		private final static int CHANCES = 3;
	
}
