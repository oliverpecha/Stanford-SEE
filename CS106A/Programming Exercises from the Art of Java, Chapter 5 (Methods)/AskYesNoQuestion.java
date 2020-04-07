/*
 * File: AskYesNoQuestion.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 7
 * -----------------
 * Write a predicate method askYesNoQuestion(str) that prints out the string str as a question for the user and then waits for a response. 
 * If the user enters the string "yes", the askYesNoQuestion method should return true; if the user enters "no", the method should 
 * return false. If the user enters anything else, askYesNoQuestion should remind the user that it is seeking a yes-or-no answer 
 * and then repeat the question. For example, if the program includes the statement
 * 			if (askYesNoQuestion("Would you like instructions")) . . .
 * the interaction with the user might look like this:
 * 			Would you like instructions? maybe 
 * 			Please answer yes or no.
 * 			Would you like instructions? no
 */

import acm.program.*;

public class AskYesNoQuestion extends ConsoleProgram {

	public void run() {
		String str = readLine("Would you like instructions? ");
		while (!(str.equals("yes")) || !(str.equals("no"))) {
			if (str.equals("yes")) {
				println("Loading instructions..."); 
				break;
			}
			else if (str.equals("no")) {
				println("Skipping instrucctions...");
				break;
			}
			else if (true) str = readLine("Would you like instructions? ");
			
		}
	}
	
}
