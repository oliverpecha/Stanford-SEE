/*
 * File: SortIgnoringCase.java
 * ---------------------------
 * This program sorts the lines of a file ignoring the case of letters.
 * It reads a file into an ArrayList and then uses the sort method in
 * the Collections class to sort the array.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

/** This program sorts the lines of a file ignoring the case of letters */
public class SortIgnoringCase extends ConsoleProgram implements Comparator<String> {

	public void run() {
		println("This program sorts a file without regard to case.");
		BufferedReader rd = openFileReader("Enter input file: ");
		List<String> lines = readLineList(rd);
		Collections.sort(lines, this);
		Iterator<String> iterator = lines.iterator();
		while (iterator.hasNext()) {
			println(iterator.next());
		}
	}

/*
 * Implements a string comparison method that ignores case.
 * This method implements the Comparator<String> interface.
 */
	public int compare(String s1, String s2) {
		return s1.toUpperCase().compareTo(s2.toUpperCase());
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

/**
 * Requests the name of an input file from the user and then opens
 * that file to obtain a BufferedReader.  If the file does not exist,
 * the user is given a chance to reenter the file name.
 */
	private BufferedReader openFileReader(String prompt) {
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

}
