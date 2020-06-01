/*
 * File: SimpleStringMapOwnE2.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 2
 * -----------------
 * This file implements a simplified version of the Map interface
 * that supports only the get and put methods.  This version uses
 * a simple hashing technique in which the entries are assigned to
 * buckets based on their hash code.  When collisions occur that
 * cause keys to hash to the same bucket, the collisions are resolved
 * by linking all the entries belonging to that bucket into a chain.
 */

/** This class implements a simplified version of the Map interface */
public class SimpleStringMapE2 {

/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringMapE2() {
		keyArray = new String[N_BUCKETS];
		valueArray = new String [N_BUCKETS];
	}

/**
 * Sets the value associated with key.  Any previous value for key is lost.
 * @param newKey The key used to refer to this value
 * @param newValue The new value to be associated with key
 */
	public void put(String newKey, String newValue) {
		// Make sure there is space for new entries
		if (lastFilledBucket + 1 > keyArray.length) doubleArray();
		int lp = 0;
		// Consider that not all elements of the array will be filled at all times. so right pointer should always start at lastFilledBucket  not the end of the array
		int rp = lastFilledBucket;
		// First entry is a special case, as to begin with, no buckets are filled and loop comparison below would return null 
		if (rp == 0) {
			keyArray[lastFilledBucket] = newKey;
			valueArray[lastFilledBucket] = newValue;
			lastFilledBucket++;
			System.out.println("stateofArray() " + stateofArray());
		}
		// To determine where to put the newKey/Value a binary search loop is performed while left pointer doesn't cross right pointer, 
		// at a point which position for newKey/Value has been found. A second condition also avoids first key/value entry to enter loop as no buckets have yet been filled and comparison would return null and cause an exception
		while (lp<rp && lastFilledBucket!= 0) {
			// Initialize a pointer in the middle and get result from comparing newKey with key in middle pointer (mid)
			int mid = (lp + rp) / 2;
			int cmp = newKey.compareTo(keyArray[mid]);
			System.out.println("\ncomparing loop, lp: " + lp + ", rp: " + rp + ", mid: " + mid + " which contains " + keyArray[mid] + ", newKey: " + newKey + " is " + cmp);
			// If result equals zero, key has already been entered, thus just update value and exit the loop
			if (cmp == 0) {
				valueArray[mid] = newValue;
				System.out.println("stateofArray() " + stateofArray());
				break;
			}
			// If comparison result is negative, it means newKey comes earlier than middle pointer, thus, "move" right pointer to mid position 
			else if (cmp < 0) {
				System.out.println(newKey + " is minor to " + keyArray[mid] + ". lp: " + lp + ", rp: " + rp + ". thus, rp turns: " + mid);
				rp = mid;
				// Loops keeps approaching position where newKey should be inserted, once length and right pointers are the same, inserts key
				if (lp==rp) insertkey(newKey, newValue, lp);
			}
			// At this point, it means comparison returned a positive result and newKey comes after, thus move left pointer to mid + 1
			else {
				System.out.println(newKey + " is greater to " + keyArray[mid] + ". lp: " + lp + ", rp: " + rp + ". thus, lp turns: " + (mid+1));
				lp =mid + 1;
				// As soon as lp and rp are the same, it's time to insert new variables
				if (lp==rp) insertkey(newKey, newValue, lp);
			}
		}
		System.out.println("comparing loop exited");
	}

/* Inserts a key and it's value into an insertion position, while moving existing elements to the right */
	private void insertkey(String key, String value, int insert) {
		System.out.println("\n++++++ inserKey " + key + " at " + insert);
		// move as many elements that are within desired insertion bucket, one position to the right
		for (int i = lastFilledBucket - 1; i >= insert; i--) {
			keyArray[i + 1] = keyArray[i];
			valueArray[i + 1] = valueArray[i];
		}
		// insert bucket is cleared, thus insert variables and increment filled bucket tracker
		keyArray[insert] = key;
		valueArray[insert] = value;
		lastFilledBucket++;
		System.out.println("stateofArray() " + stateofArray());
	}

/* Returns a representation of the keys inside the array */	
	private String stateofArray() {
		String result = "";
		for (int i = 0; i < lastFilledBucket; i++) {
			result += keyArray[i] + ", ";
		}
		return result + "\n_________________________________________________________________________________ ";
	}

/* Takes a String array, creates a new one with twice it's length, copies the values to second array and replaces first array with the second */
	private void doubleArray(){
		System.out.println("array will be doubled from " + keyArray.length + " to " + keyArray.length * 2);
		int keyArrayLenght = keyArray.length;
		String[] newKeyArray = new String[keyArrayLenght * 2];
		String[] newValueArray = new String[keyArrayLenght * 2];
		for (int i = 0; i < keyArrayLenght; i++) {
			newKeyArray[i] = keyArray[i];
			newValueArray[i] = valueArray[i];
		}
		keyArray = newKeyArray;
		valueArray = newValueArray;	
	}
	
/**
 * Retrieves the value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @return The value associated with key, or null if no such value exists
 */
	public String get(String key) {
		int lp = 0;
		int rp = lastFilledBucket;
		while (lp<=rp) {
			int mid = (lp + rp) / 2;
			int cmp = key.toUpperCase().compareTo(keyArray[mid]);
			if (cmp == 0) 	return valueArray[mid];
			if (cmp < 0) rp = mid - 1;
			else lp = mid + 1;
			}
		return null;
	}

/* Private constants */
	private static final int N_BUCKETS = 4;

/* Private instance variables */
	private String[] keyArray , valueArray;
	private int lastFilledBucket = 0;

}
