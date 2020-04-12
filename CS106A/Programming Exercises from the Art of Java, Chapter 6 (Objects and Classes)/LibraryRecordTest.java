/*
 * File: LibraryRecord.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 9
 * -----------------
 * Using the Student class from Figure 6-5 as a model, implement a new class called LibraryRecord that keeps track of the following 
 * information for a library book:
 * 			The title
 * 			The author
 * 			The Library of Congress catalog number
 * 			The publisher
 * 			The year of publication
 * 			Whether the book is circulating or noncirculating
 * Your class should export the following entries:
 * 		A constructor that takes all six of these values and creates a new LibraryRecord object with them.
 * 		A second version of the constructor that takes only the first five values and initializes the book to be circulating.
 * 		Suitably named getter methods for each of the six fields
 * 		A setter method for the circulating/noncirculating flag
 * 		An appropriate implementation of the toString method.
 */

import acm.program.*;

public class LibraryRecordTest extends ConsoleProgram{

	
	LibraryRecord theCoach = new LibraryRecord("Silicon Valley Coach", "Eric Smith", "Williams", 2016, 345255);
	
	public void run() {
		theCoach.setCirculating(false);
		println(theCoach.toString() + availability() + "available at the Library.");
		theCoach.setCirculating(true);
		println(theCoach.toString() + availability() + "available at the Library.");
	}
	
	private String availability() {
		String availability = null;
		if (!theCoach.isAvailable()) availability = " is ";
		else if (theCoach.isAvailable()) availability = " is not ";
		return availability;
	}
}
