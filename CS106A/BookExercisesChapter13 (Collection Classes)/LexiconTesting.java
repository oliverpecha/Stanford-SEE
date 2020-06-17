/*
 * File: LexiconTesting.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 6 
 * -----------------
 */

import java.util.Iterator;

import acm.program.*;

public class LexiconTesting extends ConsoleProgram {
	
	public void run() {
		
		Lexicon legalWords = new Lexicon("word7.txt");
		
		println("This program will:\n1- look for word \"airbus\". \n2- Determine how many words loaded Lexicon has. "
				+ "\n3- Display a random word from the Lexicon. \n4- Show 50 words than are 2 characters long.");
		
		println("\n1:");
		if (legalWords.isWord("airbus")) println("airbus exists");
		else println("airbus not found");
		println("\n2:");
		println("lexicon is " + legalWords.getWordCount() + " long");
		println("\n3:");
		println(legalWords.getRandomWord() + " is a random word from the Lexicon");
		println("\n4:");
		print2charWords(legalWords);
	}
	
	private void print2charWords(Lexicon legalWords) {
		Iterator<String> iterator = legalWords.iterator();
		int wordsPrinted = 0;
		while (wordsPrinted < 50 && iterator.hasNext()) {
			String word = iterator.next();
			if (word.length() == 2) {
				println(word);
				wordsPrinted++;
			}
		}
	}
}
