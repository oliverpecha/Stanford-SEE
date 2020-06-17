/*
 * File: SentencePalindrome.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 7
 * -----------------
 * The concept of a palindrome introduced in exercise xxx is often extended to full sentences by ignoring punctuation and differences in the case of 
 * letters. For example, the sentence
 * 				Madam, I’m Adam.
 * is a sentence palindrome, because if you only look at the letters and ignore any distinction between uppercase and lowercase letters, it reads 
 * identically backward and forward. Write a predicate method isSentencePalindrome(str) that returns true if the string str fits this definition of 
 * a sentence palindrome. For example, you should be able to use your method to write a main program capable of producing the following sample run:
 * -----------------
 * This program checks for sentence palindromes. 
 * Indicate the end of the input with a blank line. 
 * Enter a string: Madam, I'm Adam.
 * That string is a palindrome.
 * Enter a string: A man, a plan, a canal: Panama! That string is a palindrome.
 * Enter a string: Not a palindrome.
 * That string is not a palindrome.
 * Enter a string:
 * -----------------
 */

import acm.program.*;

public class SentencePalindrome extends ConsoleProgram {

	public void run() {
		println("A list of sentences are tested below");
		println("\nThis are Palindromes");
		println(TEST_ONE + isPalindrome(TEST_ONE));
		println(TEST_TWO + isPalindrome(TEST_TWO));
		println(TEST_FOUR + isPalindrome(TEST_FOUR));
		println(TEST_NINE + isPalindrome(TEST_NINE));	
		println(TEST_THREE + isPalindrome(TEST_THREE));
		println("\nThis are NOT :(");
		println(TEST_FIVE + isPalindrome(TEST_FIVE));
		println(TEST_SIX + isPalindrome(TEST_SIX));
		println(TEST_SEVEN + isPalindrome(TEST_SEVEN));
		println(TEST_EIGHT + isPalindrome(TEST_EIGHT));
	
	}

	// Method that tests for equality in opposing letters when they are both letters and keeps moving positions when symbols are found
	// until all opposing characters have been found equal to conclude that the String is a Palindrome. If along the way, letters are not 
	// found equal, it is concluded that the String is not a Palindrome.
	private String isPalindrome(String str) {
		str = str.toLowerCase();
		String answer = null;
		boolean isPalindrome = false;
		int strLenght = str.length();
		int currentIncreasingPosition = 0;
		int currentDecreasingPosition = strLenght -1;
		char currentIncreasingChar = str.charAt(currentIncreasingPosition);
		char currentDecreasingChar = str.charAt(currentDecreasingPosition);
			
			while (currentIncreasingPosition != currentDecreasingPosition) {	
				// To make sure only alphabet char are tested, call methods that skip symbols until letters are found
				currentIncreasingPosition = skipIncresingSymbols(str, currentIncreasingPosition, currentDecreasingPosition);
				currentDecreasingPosition = skipDecresingSymbols(str, currentIncreasingPosition, currentDecreasingPosition);

				// Find out if returned chars are the same by updating char to be tested using returned position
				currentIncreasingChar = str.charAt(currentIncreasingPosition);				
				currentDecreasingChar = str.charAt(currentDecreasingPosition);
				isPalindrome = currentIncreasingChar == currentDecreasingChar;
				
				
				if (!isPalindrome) {
					// If last characters are not the same, String won't be a Palindrome, then exit the loop to conclude testing
					break; 
				}
				// If loop hasn't been exited, it means last characters tested were the same. :) this might be a palindrome, 
				// but there are still more char to check once the loop restarts. To test new characters in the new loop,
				// positions will be moved as long as increasing and decreasing doesn't result in crossing beyond the middle of the String
				if (!(currentIncreasingPosition + 1 >= currentDecreasingPosition )) {
					currentIncreasingPosition++;
					currentDecreasingPosition--;
					currentIncreasingChar = str.charAt(currentIncreasingPosition);
					currentDecreasingChar = str.charAt(currentDecreasingPosition);
								}
				// If positions can move further, it means all characters have been tested and found the same, therefore, it is a Palindrome,
				// and the loop needs to be exited in order to return the an answer notifying it is a Palindrome. 
				else {
					break;	
				}
			}
			// Once the testing loop has been exited, if isPalindrome is true, answer will be is a Palindrome, otherwise is NOT a palindrome.
			if (isPalindrome) {
				answer = " <<< is a Palindrome!";
			}
			else answer = " <<< is NOT a Palindrome...";
		return answer;
	}
	
	// Method that checks if Character in current increasing position is a letter and keeps skipping to the next if it finds symbols
	private int skipIncresingSymbols(String str, int currentIncreasingPosition, int currentDecreasingPosition) {
		char currentIncreasingChar = str.charAt(currentIncreasingPosition);
		while (!(currentIncreasingChar >= 'a' && currentIncreasingChar <= 'z')) {
				// P1-> loop to skip increasing symbols entered!
				// P2A-> if, to not pass index limits
				// P3A-> should decrease 1 position
				if (currentIncreasingPosition + 1 != currentDecreasingPosition) {
					currentIncreasingPosition++;
					currentIncreasingChar = str.charAt(currentIncreasingPosition);
				}
				// P2B-> would pass the limit, so should exit loop to skip increasing symbols
				// P3B-> go back on position to test if palindrome against last char known
				else {
					currentIncreasingPosition++;
					currentIncreasingChar = str.charAt(currentIncreasingPosition);
					break;
				}
		}
		return currentIncreasingPosition;
	}
	
	// Method that checks if Character in current decreasing position is a letter and keeps skipping to the next if it finds symbols
	private int skipDecresingSymbols(String str, int currentIncreasingPosition, int currentDecreasingPosition) {
		char currentDecreasingChar = str.charAt(currentDecreasingPosition);
		while (!(currentDecreasingChar >= 'a' && currentDecreasingChar <= 'z')) {
				// P1-> loop to skip decreasing symbols entered!
				// P2A-> if, to not pass index limits
				// P3A-> should decrease 1 position
				if (currentIncreasingPosition != currentDecreasingPosition - 1) {
					currentDecreasingPosition--;
					currentDecreasingChar = str.charAt(currentDecreasingPosition);
				}
				// P2B-> would pass the limit, so exit loop to skip decreasing symbols
				// P3B-> go back on position to test if palindrome against last char known
				else {
					currentDecreasingPosition--;
					currentDecreasingChar = str.charAt(currentDecreasingPosition);
					break;
				}
		}
		return currentDecreasingPosition;
	}
	
	
	// Testing strings as constants
	private static final String TEST_ONE = "Do ,ge$,ese* see God?&*)";
	private static final String TEST_TWO = "Able was I ere I saw Elba";
	private static final String TEST_THREE = "Drab as a fool, aloof as a bard.";
	private static final String TEST_FOUR = "Yo, banana boy!";
	private static final String TEST_FIVE = "Greek root words meaning “back” ";
	private static final String TEST_SIX = "airplane";
	private static final String TEST_SEVEN = "King, are you glad you are king?";
	private static final String TEST_EIGHT = "Some palindromes seem philosophical. ";
	private static final String TEST_NINE = "Al lets Della call Ed “Stella.”";
}