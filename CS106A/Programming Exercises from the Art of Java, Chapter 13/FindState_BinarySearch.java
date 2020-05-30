/*
 * File: FindState_BinarySearch.java
 * ---------------------------------
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.  This implementation uses binary
 * search to find the abbreviation in O(log N) time.
 */

import acm.program.*;

/**
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.
 */
public class FindState_BinarySearch extends ConsoleProgram {

	public void run() {
		println("This program looks up two-letter state abbreviations.");
		String abbreviation = readLine("Two-letter code: ");
		println(abbreviation + " -> " + getStateName(abbreviation));
	}

/* Finds the state name given an abbreviation */
	private String getStateName(String code) {
		int index = binarySearch(code, STATE_CODES);
		if (index == -1) {
			return null;
		} else {
			return STATE_NAMES[index];
		}
	}

/* Method: binarySearch(key, array) */
/**
 * Finds an instance of the specified key in the array, which must
 * be sorted in lexicographic order.  If the key exists, the method
 * returns an index at which that key appears, but this index will
 * not necessarily be the first if the same key appears multiply.
 * If key does not appear in the array, binarySearch returns -1.
 *
 * This implementation uses the "binary search" algorithm.  At
 * each stage, the function computes the midpoint of the remaining
 * range and compares the element at that index position to the
 * key.  If there is a match, the function returns the index.
 * If the key is less than the string at that index position, the
 * function searches in the first half of the array; if the key is
 * larger, the function searches in the second half of the array.
 */
	private int binarySearch(String key, String[] array) {
		int lh = 0;
		int rh = array.length - 1;
		while (lh <= rh) {
			int mid = (lh + rh) / 2;
			int cmp = key.compareTo(array[mid]);
			if (cmp == 0) return mid;
			if (cmp < 0) {
				rh = mid - 1;
			} else {
				lh = mid + 1;
			}
		}
		return -1;
	}

/* Define the abbreviation and state arrays */
	private static final String[] STATE_CODES = {
		"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE",
		"FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY",
		"LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT",
		"NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH",
		"OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX",
		"UT", "VA", "VT", "WA", "WI", "WV", "WY"
	};

	private static final String[] STATE_NAMES = {
		"Alaska", "Alabama", "Arkansas", "Arizona", "California",
		"Colorado", "Connecticut", "District of Columbia",
		"Delaware", "Florida", "Georgia", "Hawaii", "Iowa",
		"Idaho", "Illinois", "Indiana", "Kansas", "Kentucky",
		"Louisiana", "Massachusetts", "Maryland", "Maine",
		"Michigan", "Minnesota", "Missouri", "Mississippi",
		"Montana", "North Carolina", "North Dakota", "Nebraska",
		"New Hampshire", "New Jersey", "New Mexico", "Nevada",
		"New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
		"Puerto Rico", "Rhode Island", "South Carolina",
		"South Dakota", "Tennessee", "Texas", "Utah", "Virginia",
		"Vermont", "Washington", "Wisconsin", "West Virginia",
		"Wyoming"
	};

}
