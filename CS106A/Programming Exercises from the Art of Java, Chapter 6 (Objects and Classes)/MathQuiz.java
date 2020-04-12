/*
 * File: MathQuiz.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 5 and 6
 * -----------------
 *  As computers become more common in schools, it is important to find ways to use the machines to aid in the teaching process. 
 *  This need has led to the development of an educational software industry that has produced many programs that help teach concepts 
 *  to children.
 *  As an example of an educational application, write a program that poses a series of simple arithmetic problems for a student to answer, 
 *  as illustrated by the following sample run:
 * -----------------
 *  	Welcome to Math Quiz
 *  	What is 14 + 2? 16
 *  	That's the answer!
 *  	What is 17 - 15? 17
 *  	That's incorrect - try a different answer: 15 That's incorrect - try a different answer: 3 No, the answer is 2.
 *  	What is 20 - 16? 4
 *  	That's the answer!
 *  	What is 9 + 4? 11
 *  	That's incorrect - try a different answer: 13 That's the answer!
 *  	What is 11 - 1? 10 That's the answer!
 * -----------------
 * 	Your program should meet these requirements:
 * 		• It should ask a series of five questions. As with any such limit, the number of questions should be coded as a named constant 
 * 		so that it can easily be changed.
 * 		• Each question should consist of a single addition or subtraction problem involving just two numbers, such as “What is 2 + 3?” 
 * 		or “What is 11 – 7?”. The type of problem—addition or subtraction—should be chosen randomly for each question.
 * 		• To make sure the problems are appropriate for students in the first or second grade, none of the numbers involved, including 
 * 		the answer, should be less than 0 or greater than 20. This restriction means that your program should never ask questions like 
 * 		“What is 11 + 13?” or “What is 4 – 7?” because the answers are outside the legal range. Within these constraints, your program 
 * 		should choose the numbers randomly.
 * 		• The program should give the student three chances to answer each question. If the student gives the correct answer, your program
 *  	should indicate that fact in some properly congratulatory way and go on to the next question. If the student does not get the 
 *  	answer in three tries, the program should give the answer and go on to another problem.
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
					answer = readInt("\nWhat is " + n1 + " + " + n2 + "? ");
					if (n1 + n2 == answer) println(encouragement); 
					while (n1 + n2 != answer && chances > 0) {
						chances--;
						answer = readInt("That's incorrect - try a different answer: ");
						if (n1 + n2 == answer) println(encouragement); 
						if (n1 + n2 != answer && chances == 0) println("No, the answer is " + (n1 + n2) + "."); 
					}				
				}
				// Path 2 (substraction)
				if (!operator && n1 - n2 > 0) {	
					System.out.println("questions left " + questionsLeft);
					questionsLeft--;
					answer = readInt("\nWhat is " + n1 + " - " + n2 + "? ");
					if (n1 - n2 == answer) println(encouragement); 
					while (n1 - n2 != answer && chances > 0) {
						chances--;
						answer = readInt("That's incorrect - try a different answer: ");
						if (n1 - n2 == answer) println(encouragement); 
						if (n1 - n2 != answer && chances == 0) println("No, the answer is " + (n1 - n2) + "."); 
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
