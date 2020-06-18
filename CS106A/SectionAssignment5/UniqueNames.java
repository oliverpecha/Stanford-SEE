/*
 * File: UniqueNames.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 5 / Programming Exercise 3
 * -----------------
 */

import java.util.HashMap;
import java.util.Iterator;

import acm.program.*;

public class UniqueNames extends ConsoleProgram{

	HashMap entries = new HashMap();
	
	public void run() {
		recordList();
		printList();
	}
	
	private void recordList() {
		String input = " ";
		while (input.length() > 0) {
			input = readLine("Enter name: ");
			entries.put(input, null);
		}
	}
	
	private void printList() {
		println("\nUnique name list contains");
		Iterator entryList = entries.entrySet().iterator();
		while (entryList.hasNext()) {
			String entryKey = entryList.next().toString();
			if (entryKey != null) {
				println(entryKey.substring(0, entryKey.indexOf('=')));
			}		
		}
	}
}
