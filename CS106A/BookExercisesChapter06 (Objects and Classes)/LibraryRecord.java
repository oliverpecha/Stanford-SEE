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


public class LibraryRecord {

/**
 * Creates a new LibraryRecord object with the specified parameters below and sets it to non circulating by default.
 * @param title The book title as a String
 * @param author The author's name as a String
 * @param publisher The publisher's name as a String
 * @param catalogNumber The catalog ID number as an int
 * @param yearOfPublication The year of publication as an int
 */	
	public LibraryRecord(String title, String author, String publisher, int catalogNumber, int yearOfPublication) {
		recordTitle = title; 
		recordAuthor = author; 
		recordPublisher = publisher;
		recordCatalogNumber = catalogNumber;
		recordYearOfPublication = yearOfPublication;
		recordCirculating = false;
	}
	
/**
 * Creates a new LibraryRecord object with the specified parameters in the inherited constructor plus a new one for circulating status.
 * @param circulating The book circulating status as a boolean
 */	
	public LibraryRecord(String title, String author, String publisher, int catalogNumber, int yearOfPublication, boolean circulating) {
		this(title, author, publisher, catalogNumber, yearOfPublication);
		recordCirculating = circulating;
	}
	
	public String getTitle() {
		return recordTitle;
	}
	
	public String getAuthor() {
		return recordAuthor;
	}

	public String getPublisher() {
		return recordPublisher;
	}
	
	public int getCatalog() {
		return recordCatalogNumber;
	}
	
	public int getYearOfPublication() {
		return recordYearOfPublication;
	}
	
	public void setCirculating(boolean circulating) {
			recordCirculating = circulating;
	}
	
	public boolean isAvailable() {
		return recordCirculating;
	}

	
	public String toString() {
		return recordTitle + " by " + recordAuthor + ", published in " + recordCatalogNumber + " by " + recordPublisher;
	}
	
	private String recordTitle;
	private String recordAuthor;
	private String recordPublisher;
	private int recordCatalogNumber;
	private int recordYearOfPublication;
	private boolean recordCirculating;
		
}
