/*
 * File: Greek.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 13
 * -----------------
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.program.*;
import acm.util.RandomGenerator;

public class Greek extends ConsoleProgram {
	
	public void init() {
		// Open text file and turn it into a buffer reader
		BufferedReader buffer = fileToBufferReader(CASSIUS);
		// Transform buffer into a multidimensional ArrayList of Characters
		ArrayList<ArrayList<Character>> textAsArray = bufferToArray(buffer);
		// Randomize each element from the ArrayList and print it 
		randomizeAndPrint(textAsArray);
	}
	
/*  Turns Characters from multidimensional ArrayList into Square Objects given conditions apply and places them accordingly  */	
	private void randomizeAndPrint(ArrayList<ArrayList<Character>> array)  {
		int labelCount = 1;
		for (int y = 0; y < array.size(); y++) {
			String line = "";
			for (int x = 0; x < array.get(y).size(); x++) {
				char randomized = randomizeLetters(array.get(y).get(x));
				line += randomized;
			}
			println(line);
		}
	}
	
/* Gets a char, checks if it's an uppercase or lowercase letters and randomizes it, leaving all other remaining symbols unchanged */
	private char randomizeLetters(char symbol) {
		RandomGenerator luck =  new RandomGenerator(); 
		if (symbol > 'a' && symbol < 'z') {
			return (char) luck.nextInt('a', 'z');
		}
		else if (symbol > 'A' && symbol < 'Z') {
			return (char) luck.nextInt('A', 'Z');
		}
		else return symbol;
	}
	
/* With the a name of a file, it opens it and returns it as a BufferReader */
	private BufferedReader fileToBufferReader(String fileName) {
		BufferedReader bReader = null;
		while (bReader == null) {
			try {
				bReader = new BufferedReader(new FileReader(fileName));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return bReader;
	}
	
/* Receives a buffer and turns it into a multidimensional ListArray filed with each character found as elements */
	private ArrayList<ArrayList<Character>> bufferToArray(BufferedReader buffer)  {
		// Initializes a multidimensional ArrayList of Characters
		ArrayList<ArrayList<Character>> textAsArray = new ArrayList<ArrayList<Character>>();
		// Initializes a String containing the first line of the buffer
		String fileLine = nextLine(buffer);
		// Keeps track of how many lines have been received and processed
		int fileLineS = 0;
		while (fileLine != null) {
			// Adds a row to the ArrayList
			textAsArray.add(new ArrayList<Character>());
			for (int i = 0; i < fileLine.length(); i++) {
				char tokenChar = fileLine.charAt(i);
				textAsArray.get(fileLineS).add(tokenChar);
			}
			// refills fileLine with nextLine from the Buffer and increments the count of lines
			fileLine = nextLine(buffer);
			fileLineS++;
		}
		return textAsArray;
	}

	/* Extracts the next line of a buffer and returns it as a String */
	private String nextLine(BufferedReader buffer) {
		String fileLine = null;
		try {
			fileLine = buffer.readLine();
		} catch (IOException e) {
			System.out.println("An error was found while reading a line from the file");
			e.printStackTrace();
		}
		return fileLine;
	}
	
/* Private constants */
	private static final String CASSIUS = "CassiusCasca.txt";
}
