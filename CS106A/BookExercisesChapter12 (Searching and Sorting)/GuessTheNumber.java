/*
 * File: GuessTheNumber.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 1
 * -----------------
 * Write a program GuessTheNumber that plays a number-guessing game with its user, who is presumably an elementary-school child. 
 * The child thinks of a number and then answers a series of questions from the computer until it correctly guesses the number. 
 * The following sample run shows what happens when the number is 17:
 * -----------------
 * Think of a number between 1 and 100 and I'll guess it
 * Is it 50? no
 * Is it less than 50? yes
 * Is it 25? no
 * Is it less than 25? yes 
 * Is it 12? no
 * Is it less than 12? no 
 * Is it 18? no
 * Is it less than 18? yes 
 * Is it 15? no
 * Is it less than 15? no 
 * Is it 16? no
 * Is it less than 16? no 
 * Is it 17? yes
 * I guessed the number!
 */

import acm.program.*;

public class GuessTheNumber extends ConsoleProgram {
	
	int numberGuessed, lr, hr; 
	int[] allNumbers;
	Boolean lessThanGuess, rightNumber;
	
	public void run() {
		// create an array with 100 elements
		int [] allNumbers = new int [101];
		// fill it
		allNumbers = fillArray(allNumbers);
		println("Think of a number between 1 and 100 and I'll guess it");
		rightNumber = false;
		lessThanGuess = null;
		// While rightNumber is false, keep choosing a number from the middle of the array and display it
		numberGuessed = 100;
		lr = allNumbers[0];
		hr = allNumbers[100];
		while (!rightNumber) {
			numberGuessed = guessNumber();
			String userAnswer = readLine("Is it " + allNumbers[numberGuessed] + " ? ");
			if (userAnswer.contentEquals("Yes") || userAnswer.contentEquals("yes")) rightNumber = true;
			else if (userAnswer.contentEquals("No") || userAnswer.contentEquals("no")) {
				lessThanGuess = null;
				// If not right, ask if it is less than guessed number
				while (lessThanGuess == null) {
					userAnswer = readLine("Is it less than " + numberGuessed + " ? ");
					// keep guessing a new number from the middle of the target block until righnumber is found and loop is exited
					if (userAnswer.contentEquals("Yes") || userAnswer.contentEquals("yes")) lessThanGuess = true;
					else if (userAnswer.contentEquals("No") || userAnswer.contentEquals("no")) lessThanGuess = false;
					else println("You may only answer Yes or No");
				}
			}
			else println("You may only answer Yes or No");
		}
		println("I guessed the number!");	
	}
	
	private int[] fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) 	array[i] = i; 
		return array;
	}
	
	private int guessNumber() {
		if (lessThanGuess != null) {
			if (lessThanGuess) hr = numberGuessed;
			else lr = numberGuessed;
		}	
		return ((hr - lr) / 2) + lr;
	}
}
