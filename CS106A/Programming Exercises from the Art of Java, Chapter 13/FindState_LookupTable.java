/*
 * File: FindState_LookupTable.java
 * --------------------------------
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.  This version uses a lookup table
 * consisting of a two-dimensional array in which the indices
 * are the first and second letters of the abbreviation.
 */

import acm.program.*;

/**
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.
 */
public class FindState_LookupTable extends ConsoleProgram {

	public void run() {
		initStateMap();
		println("This program looks up two-letter state abbreviations.");
		String abbreviation = readLine("Abbreviation: ");
		println(abbreviation + " -> " + getStateName(abbreviation));
	}

/* Finds the state name given an abbreviation */
	private String getStateName(String code) {
		char c1 = code.charAt(0);
		char c2 = code.charAt(1);
		return stateMap[c1 - 'A'][c2 - 'A'];
	}

/* Sets the name for a particular state name */
	private void putStateName(String code, String name) {
		char c1 = code.charAt(0);
		char c2 = code.charAt(1);
		stateMap[c1 - 'A'][c2 - 'A'] = name;
	}

/* Initializes the elements of the state name array */
	private void initStateMap() {
		putStateName("AK", "Alaska");
		putStateName("AL", "Alabama");
		putStateName("AR", "Arkansas");
		putStateName("AZ", "Arizona");
		putStateName("CA", "California");
		putStateName("CO", "Colorado");
		putStateName("CT", "Connecticut");
		putStateName("DC", "District of Columbia");
		putStateName("DE", "Delaware");
		putStateName("FL", "Florida");
		putStateName("GA", "Georgia");
		putStateName("HI", "Hawaii");
		putStateName("IA", "Iowa");
		putStateName("ID", "Idaho");
		putStateName("IL", "Illinois");
		putStateName("IN", "Indiana");
		putStateName("KS", "Kansas");
		putStateName("KY", "Kentucky");
		putStateName("LA", "Louisiana");
		putStateName("MA", "Massachusetts");
		putStateName("MD", "Maryland");
		putStateName("ME", "Maine");
		putStateName("MI", "Michigan");
		putStateName("MN", "Minnesota");
		putStateName("MO", "Missouri");
		putStateName("MS", "Mississippi");
		putStateName("MT", "Montana");
		putStateName("NC", "North Carolina");
		putStateName("ND", "North Dakota");
		putStateName("NE", "Nebraska");
		putStateName("NH", "New Hampshire");
		putStateName("NJ", "New Jersey");
		putStateName("NM", "New Mexico");
		putStateName("NV", "Nevada");
		putStateName("NY", "New York");
		putStateName("OH", "Ohio");
		putStateName("OK", "Oklahoma");
		putStateName("OR", "Oregon");
		putStateName("PA", "Pennsylvania");
		putStateName("PR", "Puerto Rico");
		putStateName("RI", "Rhode Island");
		putStateName("SC", "South Carolina");
		putStateName("SD", "South Dakota");
		putStateName("TN", "Tennessee");
		putStateName("TX", "Texas");
		putStateName("UT", "Utah");
		putStateName("VA", "Virginia");
		putStateName("VT", "Vermont");
		putStateName("WA", "Washington");
		putStateName("WI", "Wisconsin");
		putStateName("WV", "West Virginia");
		putStateName("WY", "Wyoming");
	}

/* Private instance variables */
	private String[][] stateMap = new String[26][26];

}
