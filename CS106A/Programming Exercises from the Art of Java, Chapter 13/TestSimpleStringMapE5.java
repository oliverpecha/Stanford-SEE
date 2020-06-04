/*
 * File: SimpleStringMapOwnE5.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 5
 * -----------------
 * This program tests the SimpleStringMap class.
 */

import acm.program.*;

/**
 * This program tests the SimpleStringMap class by implementing a
 * simple command-line interface that accepts lines of the form:
 *
 *     key = value
 *
 * or
 *
 *     key
 *
 * The first assigns the value to the map under the specified key;
 * The second looks up the key and displays its value.
 */
public class TestSimpleStringMapE5 extends ConsoleProgram {

	public void run() {
		SimpleStringMapE5 symbolTable = new SimpleStringMapE5();
		while (true) {
			String line = readLine("-> ");
			if (line.length() == 0) break;
			int minus = line.indexOf("-");
			if (minus > 0) {
				String key = line.substring(0, minus).trim();
				if (symbolTable.delete(key)) println(key + " has been removed");
				else println(key + " not entered yet");
			}
			else {
				int equals = line.indexOf("=");
				if (equals == -1) {
					String key = line.trim();
					println(key + " = " + symbolTable.get(key));
				} else {
					String key = line.substring(0, equals).trim();
					String value = line.substring(equals + 1).trim();
					if (!symbolTable.put(key, value)) println("No space for " + key);
				}
			}
		}
	}

}
