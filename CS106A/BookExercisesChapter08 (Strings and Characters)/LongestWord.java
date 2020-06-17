/*
 * File: LongestWord.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 15
 * -----------------
 * Implement a method
 * 	private String longestWord(string line)
 * that returns the longest word in line, where a word is defined as a consecutive string of letters as in the PigLatin program. Test your 
 * implementation by writing a ConsoleProgram that can duplicate this sample run:
 * -----------------
 * Enter a line: All mimsy were the borogoves.
 * The longest word is “borogoves”.
 * -----------------
 */

import java.util.StringTokenizer;

import acm.program.*;

public class LongestWord extends ConsoleProgram {
	
	public void run() {
		
		String testStr = "All mimsy were the borogoves";
		println("Longest string is \"" + longestWord(testStr) + "\"");
	}
	
	private String longestWord(String line) {
		String longestString = null; 
		String currentToken = null;
		int testingToken = 0;
		int longestToken = 0;
		StringTokenizer currentLine = new StringTokenizer(line);

		while (currentLine.hasMoreTokens()) {
			currentToken = currentLine.nextToken();
			testingToken = currentToken.length();
			if (testingToken > longestToken) {
				longestToken = testingToken;
				longestString = currentToken;
			}
		}
		
		return longestString;
	}
}
