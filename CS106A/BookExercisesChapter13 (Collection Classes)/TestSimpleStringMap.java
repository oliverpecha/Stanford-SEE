/*
 * File: TestSimpleStringMap.java
 * ------------------------------
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
public class TestSimpleStringMap extends ConsoleProgram {

	public void run() {
		SimpleStringMap symbolTable = new SimpleStringMap();
		while (true) {
			String line = readLine("-> ");
			if (line.length() == 0) break;
			int equals = line.indexOf("=");
			if (equals == -1) {
				String key = line.trim();
				println(key + " = " + symbolTable.get(key));
			} else {
				String key = line.substring(0, equals).trim();
				String value = line.substring(equals + 1).trim();
				symbolTable.put(key, value);
			}
		}
	}

}
