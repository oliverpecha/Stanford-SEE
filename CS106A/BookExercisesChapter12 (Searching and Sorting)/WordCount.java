/*
 * File: WordCount.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 11
 * -----------------
 * Complete the implementation of the radix sort algorithm that will sort an array of nonnegative integers up to ten digits in length. 
 * A pseudocode version of the algorithm appears on page 480.
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class WordCount extends ConsoleProgram {

	int lines = 0;
	int words = 0;
	int chars = 0;
	
	public void run() {
		println("This program counts lines, words and characters contained in a text file.");
		String input = "\nEnter the name of a file. ";
		BufferedReader file = openInputFile(input);
		try {
			count(file);
		} catch (IOException e) {
			println("Something is wrong :(");
			e.printStackTrace();
		}
		printResult();

	}
	
	private void count(BufferedReader file) throws IOException {
		String line = file.readLine();
		while (line != null) {
			lines++;
			StringTokenizer tokenizer = new StringTokenizer(line);
			words += tokenizer.countTokens();
			chars += line.length();
			line = file.readLine();
		}
	}
	
	/**
	 * Requests the name of an input file from the user and then opens
	 * that file to obtain a BufferedReader.  If the file does not exist,
	 * the user is given a chance to reenter the file name.
	 *
	 * @param prompt The string to print as a prompt to the user
	 * @return A BufferedReader open to the file specified by the user
	 */
		private BufferedReader openInputFile(String prompt) {
			BufferedReader rd = null;
			while (rd == null) {
				try {
					String name = readLine(prompt);
					rd = new BufferedReader(new FileReader(name));
				} catch (IOException ex) {
					println("Can't open that file.");
				}
			}
			return rd;
		}

	private void printResult() {
		println("");
		println("Number of lines = " + lines);
		println("Number of words = " + words);
		println("Number of characters = " + chars);
	}
}
