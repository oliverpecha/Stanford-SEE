/*
 * File: IsPalindrome.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 6
 * -----------------
 * A palindrome is a word that reads identically backward and forward, such as level or noon. Write a predicate method isPalindrome(str) that 
 * returns true if the string str is a palindrome. In addition, design and write a test program that calls isPalindrome to demonstrate that it works. 
 * In writing the program, concentrate on how to solve the problem simply rather than how to you make your solution more efficient.
 */

import acm.program.*;

public class IsPalindrome extends ConsoleProgram {

	
	public void run() {
		println("A list of words are tested below");
		println(TEST_ONE + isPalindrome(TEST_ONE));
		println(TEST_TWO + isPalindrome(TEST_TWO));
		println(TEST_THREE + isPalindrome(TEST_THREE));
		println(TEST_FOUR + isPalindrome(TEST_FOUR));
		println(TEST_FIVE + isPalindrome(TEST_FIVE));
		println(TEST_SIX + isPalindrome(TEST_SIX));
		println(TEST_SEVEN + isPalindrome(TEST_SEVEN));
		println(TEST_EIGHT + isPalindrome(TEST_EIGHT));
		println(TEST_NINE + isPalindrome(TEST_NINE));	
	}
	
	
	private String isPalindrome(String str) {
		String answer = null;
		boolean isPalindrome = false;
		int strLenght = str.length();
		int currentIncreasingPosition = 0;
		int currentDecreasingPosition = strLenght -1;
			// Find out if str is a palindrome
			//*****************************************
				// while conditions apply, extract and compare first char and last char, then move one position into both directions
				while (currentIncreasingPosition != currentDecreasingPosition) {
				// Extract first char and last char and subsequent positions
					String currentIncreasingLetter = "" + str.charAt(currentIncreasingPosition);
					String currentDecreasingLetter = "" + str.charAt(currentDecreasingPosition);
				// compare one into an other to find out if current chars are Palindrome
					isPalindrome = currentIncreasingLetter.equals(currentDecreasingLetter);
				// if current chars are not Palindrome, the word is not a Palindrome, then exit the loop
					if (!isPalindrome) break;
				// if so far characters are equal find out if there is other char to evaluate and prepare the loop to restart
				// move an increasing and decreasing position as long as moving doesn't result in checking past half of the word 
					if (currentIncreasingPosition + 1 != currentDecreasingPosition) {
						currentIncreasingPosition++;
						currentDecreasingPosition--;
					}
				// if last testing of chars was positive and no more characters can be tested because length is odd, exit the loop
					else break;	
				}
			//*****************************************
			// Finish up and assign correct string to answer
				if (isPalindrome) answer = " is a palindrome!";
				else answer = " is not a palindrome...";
		return answer;
	}
	
	
	private static final String TEST_ONE = "kayak";
	private static final String TEST_TWO = "boss";
	private static final String TEST_THREE = "fuzz";
	private static final String TEST_FOUR = "box";
	private static final String TEST_FIVE = "radar";
	private static final String TEST_SIX = "airplane";
	private static final String TEST_SEVEN = "level";
	private static final String TEST_EIGHT = "racecar";
	private static final String TEST_NINE = "deed";

	
}
