/*
 * File: Lexicon.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 6
 * -----------------
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lexicon {

/**
 * Creates a new lexicon object initialized to contain all the words in the specified file.
 * @param filename
 * @return
 */	
	public Lexicon(String filename) {
		BufferedReader wordBuffer = openFileReader(filename);
		allWords = bufferToHashMap(wordBuffer);
		wordSet = allWords.keySet();
	}
	
	private HashMap<String, String> bufferToHashMap(BufferedReader rd) {
		HashMap<String, String> allLines = new HashMap<String, String>();
		Scanner scanner = new Scanner(rd);
		while (scanner.hasNext()) {
			String line = scanner.next();
			allLines.put(line, null);
			System.out.println(line + " was put.");
		}	
		return allLines;
	}
	
	private BufferedReader openFileReader(String filename) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				System.out.println("Can’t open that file.");
			}
		}
		return rd;
	}
		
/**
 * Returns true if the specified word exist in the lexicon
 * @param word
 * @return
 */
	public boolean isWord(String word) {
		if (allWords.containsKey(word)) return true;
		else return false;
	}

/**
 * Returns the number of words in the lexicon.		
 * @return
 */
	public int getWordCount() {
		return allWords.size();
	}
	
/**
 * Returns a randomly chosen word from the lexicon
 * @return
 */
	public String getRandomWord() {
		Random       random    = new Random();
		List<String> keys      = new ArrayList<String>(wordSet);
		String       randomKey = keys.get( random.nextInt(keys.size()) );
		return randomKey;
	}	
	
/**
 * Returns an iterator that steps through the words in the lexicon (in no predictable order).
 * @return
 */
	Iterator<String> iterator() {	
		Iterator<String> test = wordSet.iterator();
		return test;
	}
	
/*
 * Local instances
 */
	HashMap<String, String> allWords;
	Set<String> wordSet;
	
}
