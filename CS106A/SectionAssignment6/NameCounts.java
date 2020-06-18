/*
 * File: NameCounts.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 6 / Programming Exercise 2
 * -----------------
 */

import java.util.HashMap;
import java.util.Iterator;

import acm.program.*;

public class NameCounts extends ConsoleProgram{

	HashMap entries = new HashMap<String, Integer>();
	
	public void run() {
		recordList();
		printList();
	}
	
	private void recordList() {
		String input = " ";
		while (true) {
			input = readLine("Enter name: ");
			if (input.length() == 0) break;
			input.trim();
			Integer value = (Integer) entries.get(input);
			if (value == null) value = 0;
			entries.put(input, value + 1);
		}
	}
	
	private void printList() {
		println("\nUnique name list contains");
		Iterator entryList = entries.entrySet().iterator();
		while (entryList.hasNext()) {
			String entryKey = entryList.next().toString();
			if (entryKey != null) {
				println("Entry [" + entryKey.substring(0, entryKey.indexOf('=')) + "] has count " + entryKey.substring(entryKey.indexOf('=') + 1));
			}		
		}
	}

}
