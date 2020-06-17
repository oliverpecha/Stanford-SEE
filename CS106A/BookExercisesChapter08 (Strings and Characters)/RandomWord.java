/*
 * File: RandomWord.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 2
 * -----------------
 *  Write a method randomWord that returns a randomly constructed “word” consisting of randomly chosen letters. The number of letters in the word 
 *  should also be chosen randomly by picking a number between the values of the named constants MIN_LETTERS and MAX_LETTERS. 
 *  Write a ConsoleProgram that tests your method by displaying five random words.
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class RandomWord extends ConsoleProgram {

	private RandomGenerator luck = RandomGenerator.getInstance();
	
	public void run(){
		for (int i = 0; i < EXAMPLES; i++) {
			println(randomword());
		}
	}
	
	private String randomword() {
		int wordNumber = luck.nextInt(MIN_LETTERS, MAX_LETTERS);
		String randomWord = "";
		for (int n = 0; n < wordNumber; n++) {
			char letter = (char) luck.nextInt('a','z');
			randomWord += letter; 
		}
		return randomWord;
	}
	
	private static final int MIN_LETTERS = 3;
	private static final int MAX_LETTERS = 5;
	private static final int EXAMPLES = 5;
	
}
