/*
 * File: WordGame.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 5
 * -----------------
 *  In most word games, each letter in a word is scored according to its point value, which is inversely proportional to its frequency in English 
 *  words. In ScrabbleTM, the points are allocated as follows:	
 *  	1		A,E,I,L,N,O,R,S,T,U
 *  	2		D,G
 *  	3		B,C,M,P
 *  	4		F,H,V,W,Y
 *  	5		K
 *  	8		J,X
 *  	10		Q,Z
 *  For example, the Scrabble word "FARM" is worth 9 points: 4 for the F, 1 each for the A and the R, and 3 for the M. 
 *  Write a ConsoleProgram that reads in words and prints out their score in Scrabble, not counting any of the other bonuses that occur in the game. 
 *  You should ignore any characters other than uppercase letters in computing the score. In particular, lowercase letters are assumed to represent 
 *  blank tiles, which can stand for any letter but which have a score of 0.
 */


public class WordGame {

	public WordGame(String input) {
		word = input;
	}
	
	public void setPoints() {
		// 1. for as long as the number of words
		int wordLenght = word.length();
		for (int i = 0; i < wordLenght; i++) {
			// 2. isolate character
			char letter = word.charAt(i);
			// 3. compute individual value
			// 4. add value to points
			individualValue(letter);
		}
	}
	
	// 3. compute individual value
	private int individualValue(char letter) {
		int value = 0;
		switch (letter) {
			case 'A': 
			case 'E': 
			case 'I':
			case 'L': 
			case 'N': 
			case 'O':
			case 'R':
			case 'S': 
			case 'T':
			case 'U':
				value = 1; break;
			case 'D': 
			case 'G': 
				value = 2; break;
			case 'B': 
			case 'C': 
			case 'M':
			case 'P': 
				value = 3; break;
			case 'F': 
			case 'H': 
			case 'V':
			case 'W': 
			case 'Y': 
				value = 4; break;
			case 'K': 
				value = 5; break;
			case 'J': 
			case 'X': 
				value = 8; break;
			case 'Q': 
			case 'Z': 
				value = 10; break;
		}
		// 4. add value to points
		return points += value;
	}
	
	public String toString() {
		return word + " is worth " + points + " points.";
	}
	
	public String word;
	public int points;
}
