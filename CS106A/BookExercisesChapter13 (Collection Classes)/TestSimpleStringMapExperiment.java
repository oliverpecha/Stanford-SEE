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
public class TestSimpleStringMapExperiment extends ConsoleProgram {

	public void run() {
		SimpleStringMapExperiment symbolTable = new SimpleStringMapExperiment();
		while (true) {
			
			String line = readLine("-> ");
			if (line.length() == 0) break;
			// Catches Commands
			int at1 = line.indexOf("@");	
			if (at1 >= 0) {
				int at2 = line.indexOf("@", at1 + 1);
				int hasht = line.indexOf("#");
				String command;
				int bucket = 0;
				if (hasht > 0) command = line.substring(at1 + 1, hasht).trim();
				else {
					command = line.substring(at1 + 1, at2).trim();
					bucket = Integer.parseInt(line.substring(at2 + 1).trim());
				}
				String myCode = line.substring(hasht + 1).trim();
				if (command.equalsIgnoreCase("getArrayLenght")) {
					println("Array is " + symbolTable.getArrayLenght() + " long.");
				}
				else if (command.equalsIgnoreCase("getLink")) {
					println("Link at first element in bucket " + bucket + " is " + symbolTable.getLink(bucket));
				}
				else if (command.equalsIgnoreCase("getInfo")) {
					println(symbolTable.getInfo(myCode));
				}
				else if (command.equalsIgnoreCase("getBucket")) {
					println("Bucket #" + bucket + " has: " + symbolTable.getBucket(bucket));
				}
			}
			// Looks for entries
			else { 
				int equals = line.indexOf("=");
				if (equals == -1) {
					//System.out.println("\nlook for entry " + line);
					String key = line.trim();
					println(key + " = " + symbolTable.get(key));
					
				// Catches new entries
				} else {
					String key = line.substring(0, equals).trim();
					String value = line.substring(equals + 1).trim();
					symbolTable.put(key, value);
					//println("key " + key + " and " + value + " value have been put into the HashMap");
				}
			}
		}
	}

}
