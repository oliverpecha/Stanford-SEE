/*
 * File: CrossWordGrid.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 14
 * -----------------
 */
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import acm.graphics.*;
import acm.program.*;

public class CrossWordGrid extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		// Get text File that contains a representation of a CrossWord Grid and Turn into a BufferReader
		BufferedReader buffer = fileToBufferReader(CROSSWORD);
		// Keep getting lines and adding every character into an ArrayList until there isn't more lines
		ArrayList<ArrayList<Character>> crossWordArray = bufferToArray(buffer);
		// Adjust each row of the array by adding empty columns. Goal is that a graphical representation will reassemble the aspect of a CrossWord grid
		adjustArray(crossWordArray);
		// Go trough each element of the ArrayList to determine which kind of Square to add and where to place it
		drawCrossWord(crossWordArray);
	}

/*  Turns Characters from multidimensional ArrayList into Square Objects given conditions apply and places them accordingly  */	
	private void drawCrossWord(ArrayList<ArrayList<Character>> array)  {
		int squareSize = (SCREEN_HEIGHT - 2 * MARGIN_Y) / array.size();
		int margin_X = (SCREEN_WIDTH - squareSize * array.size()) / 2;
		int labelCount = 1;
		for (int y = 0; y < array.size(); y++) {
			for (int x = 0; x < array.get(y).size(); x++) {
				Square square = null;
				if (!array.get(y).get(x).equals(' ')) {
					if (array.get(y).get(x).equals('@')) {
						square = new Square(squareSize, 0, Color.BLACK, Color.BLACK);
						add(square, margin_X + x * squareSize, MARGIN_Y + y * squareSize);
					}
					else {
						if (isLead(array, y, x)) {
							square = new Square(squareSize, labelCount, Color.BLACK, null);
							add(square, margin_X + x * squareSize, MARGIN_Y + y * squareSize);
							labelCount++;
						}
						else square = new Square(squareSize, 0, Color.BLACK, null);
						add(square, margin_X + x * squareSize, MARGIN_Y + y * squareSize);
					}		
				}
			}
		}
	}

/* Predicative methods below act together to determine whether the Cell is a lead of a word (either horizontally or vertically) 
 * inside the CrossWord Grid to help drawCrossWord add a label if necessary */	
	private boolean isLead(ArrayList<ArrayList<Character>> array, int y, int x) {
		// If either condition is found true, the cell is a lead of other cells that contain a word
		if (verticalLead(array, y, x) || horizontalLead(array, y, x)) return true;
		else return false;
	}
	
	private boolean verticalLead(ArrayList<ArrayList<Character>> array, int y, int x) {
		if (topIsBound(array, y, x) && bottomIsChar(array, y, x)) return true; 
		else return false;
	}
	
	private boolean horizontalLead(ArrayList<ArrayList<Character>> array, int y, int x) {
		if (leftIsBound(array, y, x) && rightIsChar(array, y, x)) return true; 
		else return false;
	}
	
	private boolean topIsBound(ArrayList<ArrayList<Character>> array, int y, int x) {
		// Adaptor for first column, as there are no elements on top of such row which indicates there are topLimits
		if (y == 0) return true;
		else {
			// Adaptor for cells which have no elements on top which already indicates there are topLimits
			if (x > array.get(y - 1).size() - 1) return true;
			// At this point, it means it has some kind of element on top. Discard 
			else if (array.get(y - 1).get(x).equals(' ') || array.get(y - 1).get(x).equals('@')) return true;
			// If none of the conditions above have met, it means cell has an element containing a character above
			// which points the cell is not a verticalLead
			else return false;
		}
	}
	
	private boolean leftIsBound(ArrayList<ArrayList<Character>> array, int y, int x) {
		if (array.get(y).get(x - 1).equals(' ') || array.get(y).get(x - 1).equals('@')) return true;
		else return false;
	}
	
	private boolean bottomIsChar(ArrayList<ArrayList<Character>> array, int y, int x) {	
		if (x > array.get(y + 1).size() - 1) return false;
		return true;
	}
	
	private boolean rightIsChar(ArrayList<ArrayList<Character>> array, int y, int x) {
		if (x + 1 > array.get(y).size() - 1) return false;
		return true;
	}
	
/* Adds empty spaces to an array when necessary so the multidimensional values have relate to the geometry of a CrossWord Grid  */	
	private void adjustArray( ArrayList<ArrayList<Character>> array)  {
		int evenHalf = array.size() / 2;
		int emptyElementsToAdd;
		// Vertical Dimension
		for (int n = 0; n < array.size(); n++) {
			// Rows before and after half of the grid need opposing numbers of spaces (starting half:  increasing & last half: decreasing)
			if (n < array.size() - evenHalf) emptyElementsToAdd = evenHalf + n - array.get(n).size() + 1; 
			else {
				// Rows after grid's half use a compensation method that mirrors the technique used to determine amount of empty elements to add
				int nMirroing = array.size() - n;
				emptyElementsToAdd = evenHalf + nMirroing - array.get(n).size(); 
			}
			// Fill as many empty elements have been determined in this row and add them to the beginning (index: 0)
			for (int e = 0; e < emptyElementsToAdd; e++) {
				array.get(n).add(0, ' ');
			}
		}
	}

/* Receives a buffer and turns it into a multidimensional ListArray filed with each character found as elements */
	private ArrayList<ArrayList<Character>> bufferToArray(BufferedReader buffer)  {
		// Initializes a multidimensional ArrayList of Characters
		ArrayList<ArrayList<Character>> crossWordArray = new ArrayList<ArrayList<Character>>();
		// Initializes a String containing the first line of the buffer
		String fileLine = nextLine(buffer);
		// Keeps track of how many lines have been received and processed
		int fileLineS = 0;
		while (fileLine != null) {
			// Adds a row to the ArrayList
			crossWordArray.add(new ArrayList<Character>());
			// Turns a line from the buffer into a Tokenizer, as a shortcut to get only characters and skip the spaces
			StringTokenizer tokenizer = new StringTokenizer(fileLine);
			String tokenLine = tokenizer.nextToken();
			// Finds out how long the token is so that it loops extracting each character and adding it to the ArrayList as a column
			int tokenLenght = tokenLine.length();
			for (int i = 0; i < tokenLenght; i++) {
				char tokenChar = tokenLine.charAt(i);
				crossWordArray.get(fileLineS).add(tokenChar);
			}
			// refills fileLine with nextLine from the Buffer and increments the count of lines
			fileLine = nextLine(buffer);
			fileLineS++;
		}
		return crossWordArray;
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

/* Private constants */
	private static final String CROSSWORD = "FirstCrossword.txt";
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
	private static final int MARGIN_Y = SCREEN_HEIGHT / 20 ;


/* 
 * private class that creates GObjects representing different kinds of Squares *********************************** 
 */
	
private class Square extends GCompound {

	// Constructs a square according to arguments that determine final aspect
	public Square(int size, int number, Color bound, Color fill) {
		// If object requires a bound a rectangle is added
		if (bound != null) {
			GRect rect = new GRect(size, size);
			rect.setColor(bound);
			// if a Color is received, the square gets filled in such a color.
			if (fill != null) {
				rect.setFilled(true);
				rect.setFillColor(fill);
			}
			add(rect);
		}
		// If number is greater than 0, a GLabel with such a number gets added
		if (number > 0) {
			GLabel label = new GLabel("" + number);
			add(label, 0.1 * size, label.getHeight() + 0.03 * size);
		}	
	}
}

}
