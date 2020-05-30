/*
 * File: ReverseFile.java
 * ----------------------
 * This program reverses the lines in a file.  In this version, the
 * implementation of readLineArray does not use an ArrayList but
 * instead expands the array dynamically as needed.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;

/** This program reverses the lines in a file */
public class ReverseFile extends ConsoleProgram {

	public void run() {
		println("This program reverses the lines in a file.");
		BufferedReader rd = openInputFile("Enter input file: ");
		String[] lines = readLineArray(rd);
		for (int i = lines.length - 1; i >= 0; i--) {
			println(lines[i]);
		}
	}

/*
 * Reads all available lines from the specified reader and returns an array
 * containing those lines.  This method closes the reader at the end of the file.
 *
 * Implementation note:
 *   This version of the implementation uses arrays rather than array lists
 *   to read the lines.  Because you cannot add new elements to an array in
 *   the way you can with an ArrayList, this implementation reallocates the
 *   array whenever it runs out of space.  As a strategy to reduce the
 *   frequency of reallocation for large files, the implementation doubles
 *   rather than adding a constant increment.  As in the original version,
 *   this method requires a second pass to copy the temporary array into
 *   an array with just the right number of elements.
 *
 * @param rd A BufferedReader for the input file
 * @return A string array containing the lines read from the reader
 */
	private String[] readLineArray(BufferedReader rd) {
		String[] lineArray = new String[INITIAL_CAPACITY];
		int nLines = 0;
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				if (nLines + 1>= lineArray.length) {
					lineArray = doubleArraySize(lineArray);
				}
				lineArray[nLines++] = line;
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		String[] result = new String[nLines];
		for (int i = 0; i < nLines; i++) {
			result[i] = lineArray[i];
		}
		return result;
	}

/*
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

/*
 * Creates a string array that contains twice as many elements as the
 * old array, copies the existing elements from the old array to the
 * new array, and then returns the new array.
 */
	private String[] doubleArraySize(String[] oldArray) {
		String[] newArray = new String[2 * oldArray.length];
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		return newArray;
	}

/* Private constants */
	private static final int INITIAL_CAPACITY = 1;

}
