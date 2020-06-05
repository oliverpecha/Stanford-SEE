/*
 * File: PigLatinTesting.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 7
 * -----------------
 */

import acm.program.*;
import java.util.*;

public class PigLatinTesting extends ConsoleProgram {
	
	public void run() {
		Lexicon legalWords = new Lexicon("word7.txt");
		println("This program will print all the words that after being translated to Pig Latin, they still are an English equivalent.");
		printPigLatinEnglishWords(legalWords);
	}
	
	private void printPigLatinEnglishWords(Lexicon legalWords) {
		Iterator<String> iterator = legalWords.iterator();
		while (iterator.hasNext()) {
			String word = iterator.next();
			if (isPigLatinAndEnglish(word, legalWords).length() > 0) {
				println(word + " which translates to " + inPigLatinDialect(word));
			}
		}
	}
	
	private void printPigLatinEnglishWordsTester(Lexicon legalWords) {	
		String fakeIterator = "erodes trash obvious plunder";
		StringTokenizer iterator = new StringTokenizer(fakeIterator);
		while (iterator.hasMoreTokens()) {
			String word = iterator.nextToken();
			if (isPigLatinAndEnglish(word, legalWords).length() > 0) {
				println(word + " which translates to " + inPigLatinDialect(word));
			}
		}
	}
	
	private String isPigLatinAndEnglish(String wordEnglish, Lexicon legalWords) {
		String wordPigLatin = inPigLatinDialect(wordEnglish);
		if (legalWords.isWord(wordPigLatin)) return wordPigLatin;
		else return "";
	}
	
	private String inPigLatinDialect(String wordEnglish) {
		String first = "";
		String second = "";
		if (!isEnglishVowel(wordEnglish.charAt(0))) {
			System.out.println("@@@ " + wordEnglish +  " starts with a consonant!!: " + wordEnglish + " which is " + wordEnglish.length() + " long");
			int firstVowel = 1;
			while (firstVowel < wordEnglish.length() - 1) {
				if (isEnglishVowel(wordEnglish.charAt(firstVowel))) break;
				firstVowel++;
			}
			first = wordEnglish.substring(0, firstVowel);
			second = wordEnglish.substring(firstVowel);
			return second + first + "ay";
		}
		else return "";
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
	
}
