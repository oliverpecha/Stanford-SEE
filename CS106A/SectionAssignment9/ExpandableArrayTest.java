/*
 * File: ExpandableArrayTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 9 / Programming Exercise 2
 * -----------------
 */

public class ExpandableArrayTest {
	
	static ExpandableArray myList = new ExpandableArray();
	
	public static void main(String args[]){  
		myList.set(14, "Bob");
		myList.set(21, "Sally");
		printValue(14);
		printValue(3);
		printValue(21);

	}
	
	private static void printValue(int code) {
		String value = (String) myList.get(code);	// Note the cast
		if (value!= null) {
			System.out.println("Got value: " + value);
		}
		else System.out.println("Value is not present");
	}
	
}
