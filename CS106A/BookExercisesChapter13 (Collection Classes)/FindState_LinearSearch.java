/*
 * File: FindState_LinearSearch.java
 * ---------------------------------
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.  This implementation uses linear
 * search to find the abbreviation in O(N) time.
 */

import acm.program.*;

/**
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.
 */
public class FindState_LinearSearch extends ConsoleProgram {

	public void run() {
		println("This program looks up two-letter state abbreviations.");
		String abbreviation = readLine("Abbreviation: ");
		println(abbreviation + " -> " + getStateName(abbreviation));
	}

/* Finds the state name given an abbreviation */
	private String getStateName(String code) {
		int index = linearSearch(code, STATE_CODES);
		if (index == -1) {
			return null;
		} else {
			return STATE_NAMES[index];
		}
	}

/*
 * Finds the first instance of the specified key in the array
 * and returns its index.  If key does not appear in the array,
 * linearSearch returns -1.
 */
	private int linearSearch(String key, String[] array) {
		for (int i = 0; i < array.length; i++) {
			if (key.equals(array[i])) return i;
		}
		return -1;
	}

/* Define the abbreviation and state arrays */
	private static final String[] STATE_CODES = {
		"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC",
		"FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
		"LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
		"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
		"OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX",
		"UT", "VT", "VA", "WA", "WV", "WI", "WY"
	};

	private static final String[] STATE_NAMES = {
		"Alabama", "Alaska", "Arizona", "Arkansas", "California",
		"Colorado", "Connecticut", "Delaware", "District of Columbia",
		"Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
		"Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi",
		"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
		"New Jersey", "New Mexico", "New York", "North Carolina",
		"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
		"Puerto Rico", "Rhode Island", "South Carolina", "South Dakota",
		"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
		"West Virginia", "Wisconsin", "Wyoming"
	};

}
