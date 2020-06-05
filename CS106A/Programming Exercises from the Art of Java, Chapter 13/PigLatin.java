/*
 * File: PigLatin.java
 * -------------------
 * This file takes a line of text and converts each word
 * into Pig Latin.  The rules for forming Pig Latin words
 * are as follows:
 *
 * o  If the word begins with a vowel, add "way" to the
 *    end of the word.
 *
 * o  If the word begins with a consonant, extract the set
 *    of consonants up to the first vowel, move that set
 *    of consonants to the end of the word, and add "ay".
 */

import acm.program.*;
import java.util.*;

public class PigLatin extends ConsoleProgram {

	public void run() {
		println("This program translates a line into Pig Latin.");
		String line = readLine("Enter a line: ");
		println(translateLine(line));
	}

/* Translates a line to Pig Latin, word by word */
	private String translateLine(String line) {
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
	  DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/~`|\\ ";

}
