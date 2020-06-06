/*
 * File: FilmsSorter.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 8
 * -----------------
 */

import java.io.*;
import java.util.*;

import acm.program.*;
import acm.util.ErrorException;

public class FilmsSorter extends ConsoleProgram implements Comparator<String> {

public void run() {
	BufferedReader wordBuffer = openFileReader("Films.txt");
	List<String> allWords = readLineList(wordBuffer);
	Collections.sort(allWords, this);
	Iterator<String> iterator = allWords.iterator();
	while (iterator.hasNext()) {
		println(iterator.next());
	}
}

/*
 * Implements a string comparison method that ignores case.
 * This method implements the Comparator<String> interface.
 */
	public int compare(String s1, String s2) {
		s1 = removeArticles(s1);
		s2 = removeArticles(s2);
		return s1.compareTo(s2);
	}
	
	private String removeArticles(String line) {
		line = line.toLowerCase();
		int articleLenght = 0;
		String[] articles = {"a ", "an ", "the ",};
		for (int i = 0; i < articles.length; i++) {
			if (line.startsWith(articles[i])) articleLenght = articles[i].length();
		}
		if (articleLenght > 0) return line.substring(articleLenght);
		else return line;
	}

/*
 * Reads all available lines from the specified reader and returns a List<String>
 * containing those lines.  This method closes the reader at the end of the file.
 */
	private List<String> readLineList(BufferedReader rd) {
		List<String> lineList = new ArrayList<String>();
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lineList.add(line);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		return lineList;
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
	
}
