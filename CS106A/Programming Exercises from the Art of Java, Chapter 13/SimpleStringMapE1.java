/*
 * File: SimpleStringMapOwn.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 1
 * -----------------
 * This file implements a simplified version of the Map interface
 * that supports only the get and put methods.  This version uses
 * a simple hashing technique in which the entries are assigned to
 * buckets based on their hash code.  When collisions occur that
 * cause keys to hash to the same bucket, the collisions are resolved
 * by linking all the entries belonging to that bucket into a chain.
 */

/** This class implements a simplified version of the Map interface */
public class SimpleStringMapE1 {

/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringMapE1() {
		keyArray = new String[N_BUCKETS];
		valueArray = new String [N_BUCKETS];
	}

/**
 * Sets the value associated with key.  Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public void put(String key, String value) {
		System.out.println("put");
		int bucket = Math.abs(key.hashCode()) % keyArray.length;
		if (keyArray[bucket] != null) {
			doubleArray();
			bucket = Math.abs(key.hashCode()) % keyArray.length;
		}
		keyArray[bucket] = key;
		valueArray[bucket] = value;
	}
	
	private void doubleArray(){
		System.out.println("array will be doubled from " + keyArray.length + " to " + keyArray.length * 2);
		int keyArrayLenght = keyArray.length;
		String[] newKeyArray = new String[keyArrayLenght * 2];
		String[] newValueArray = new String[keyArrayLenght * 2];
		for (int i = 0; i < keyArrayLenght; i++) {
			if (keyArray[i] != null) {
			int bucket = Math.abs(keyArray[i].hashCode()) % (keyArrayLenght * 2);
			System.out.println("old bucket " + i + " gets new bucket " + bucket);
			newKeyArray[bucket] = keyArray[i];
			newValueArray[bucket] = valueArray[i];
			}
			else System.out.println("old bucket " + i + " was empty");
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
		int bucket = Math.abs(key.hashCode()) % keyArray.length;
		if (valueArray[bucket] == null) {
			return null;
		} else {
			return valueArray[bucket];
		}
	}

/* Private constants */
	private static final int N_BUCKETS = 2;

/* Private instance variables */
	private String[] keyArray , valueArray;

}
