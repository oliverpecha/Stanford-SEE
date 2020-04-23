/*
 * File: PigLatin.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 17 & 18
 * -------------------
 * 17:  Rewrite the PigLatin program in this chapter so that it uses the algorithmic strategy of going through the line character by character 
 *    	rather than word by word. The pseudocode version of this strategy appears in the section on “Talking spaces and punctuation into account.” 
 * 18:  As written, the PigLatin program in Figure 8-6 behaves somewhat oddly  if you enter a string that includes words that begin with an 
 * 		uppercase letter. For example if you were to capitalize the first word in the sentence and the name of the Pig latin language, you would 
 * 		see the following output:
 * -------------------
 * This program translates a line into Pig Latin.
 * Enter a line: This is Pig Latin.
 * isThay isway igPay atinLay.
 * -------------------
 * 		Rewrite the translateWord method so that any word that begins with a capital letter in the English line still begins with a capital 
 * 		letter in Pig Latin. Thus, after making your changes in the program, the output should look like this:
 * -------------------
 * This program translates a line into Pig Latin. 
 * Enter a line: This is Pig Latin.
 * Isthay isway Igpay Atinlay.
 * -------------------
 */

import acm.program.*;
import java.util.*;

public class PigLatin extends ConsoleProgram {

	public void run() {
		while (true) {
		println("\nThis program translates a line into Pig Latin.");
		
		String line = readLine("Enter a line: (This is Pig Latin.) ");
		println("\"" + translateLine(line) + "\"");
		}
	}

/* Translates a line to Pig Latin, word by word */
	private String translateLine(String line) {
		// Initialize a variable to hold the result and set it to the empty string.
		System.out.println("lenght is: " + line.length());
		String result = "";
		String extractedWord = "";
		int StartingChar = 0;
		for (int i = 0; i < line.length(); i++) {
			System.out.println("i is: " + i + "StartingChar is: " + StartingChar);
			// If the ith character in the line is some kind of separator
			if (isSeparator(line.charAt(i))) {
				//Append that character to the result variable.
				result = result + line.charAt(i);
				System.out.println("if isSeparator, result is: " + result);
				// If not the last char in the String, reset StartingChar for wordExtractor to trim correctly
				if (i + 1 < line.length()) {
				StartingChar = i + 1;
				} 
			}
			// Else If, the ith character is the end of a word
			else if (i + 1 < line.length()) {	
				if (isSeparator(line.charAt(i + 1))) {
					// Extract the word as a substring. 		
					extractedWord = wordExtractor(line, StartingChar, i + 1);
					// Translate the word to Pig Latin.	
					// Append the translated word to the result variable.
					result = result + translateWord(extractedWord);
				}
			}
			// Else If, the ith character is the end of the String Line entered
			else if (i + 1 == line.length()) {
				extractedWord = wordExtractor(line, StartingChar, i + 1);
				result = result + translateWord(extractedWord);
			}
		}
		// Return the value of the result variable to the caller.
		return result;
	}
	
	private String wordExtractor(String line, int StartingChar, int i) {
		String extractedWord = line.substring(StartingChar, i);
		System.out.println("extractedWord is: \"" + extractedWord + "\"");
		return extractedWord;
	}
/* Translates a line to Pig Latin, word by word */
	private String translateLineOld(String line) {
		String result = "";
		StringTokenizer tokenizer =
		  new StringTokenizer(line, DELIMITERS, true);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (isWord(token)) {
				token = translateWord(token);
			}
			result += token;
		}
		return result;
	}
	
	private boolean isSeparator(char currentChar) {
		boolean result = false;
		switch (currentChar) {
		case ',': 
		case '.': 
		case '?':
		case ' ': result = true;
		}
		return result;
	}

/* Returns true if token is a "word" (all character are letters) */
	private boolean isWord(String token) {
		for (int i = 0; i < token.length(); i++) {
			char ch = token.charAt(i);
			if (!Character.isLetter(ch)) return false;
		}
		return true;
	}
/* Translates a word to Pig Latin and returns the translated word */
	private String translateWord(String word) {
		String result = "";
		int vp = findFirstVowel(word);
		if (vp == -1) {
			if (Character.isUpperCase(word.charAt(0))) {
				word = capitalizedWord(word);
			}
			result = word;
		} else if (vp == 0) {
			if (Character.isUpperCase(word.charAt(0))) {
				word = capitalizedWord(word);
			}
			result = word + "way";
		} else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp);
			if (Character.isUpperCase(word.charAt(0))) {
				tail = capitalizedWord(tail);
				head = head.toLowerCase();
			}
			result = tail + head + "ay";
		}
		return result;
	}

/* Returns a word that has been Capitalized, regardless of the previous casing */
	private String capitalizedWord(String word) {
		word = word.toLowerCase();
		String capitalized = null;
		capitalized = "" + word.charAt(0);
		capitalized = capitalized.toUpperCase();
		capitalized = capitalized + word.substring(1);
		return capitalized;
	}
	
/* Translates a word to Pig Latin and returns the translated word */
	private String translateWordOld(String word) {
		int vp = findFirstVowel(word);
		if (vp == -1) {
			return word;
		} else if (vp == 0) {
			return word + "way";
		} else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp);
			return tail + head + "ay";
		}
	}

/* Returns the index of the first vowel in the word (-1 if none) */
	private int findFirstVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (isEnglishVowel(word.charAt(i))) return i;
		}
		return -1;
	}

/* Returns true if the character is a vowel */
	private boolean isEnglishVowel(char ch) {
		switch (Character.toLowerCase(ch)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				return true;
			default:
				return false;
		}
	}

/* Defines the characters that delimit a token */
	private static final String
	  DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/~`|\\";

}
