/*
 * File: SimpleStringMapOwnE3.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 3
 * -----------------
 * This file implements a simplified version of the Map interface
 * that supports only the get and put methods.  This version uses
 * a simple hashing technique in which the entries are assigned to
 * buckets based on their hash code.  When collisions occur that
 * cause keys to hash to the same bucket, the collisions are resolved
 * by linking all the entries belonging to that bucket into a chain.
 */

/** This class implements a simplified version of the Map interface */
public class SimpleStringMapE3 {

/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringMapE3() {
		bucketArray = new HashEntry[N_BUCKETS];
	}

/**
 * Sets the value associated with key.  Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public void put(String key, String value) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			entry = new HashEntry(key, value);
			entry.setLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
			totalKeys++;
		} else {
			entry.setValue(value);
		}
	}

/**
 * Retrieves the value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @return The value associated with key, or null if no such value exists
 */
	public String get(String key) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			return null;
		} else {
			return entry.getValue();
		}
	}

/**
 * Removes the key and value associated with key, or null if no such key exists.
 * @param key The key used to look up the value
 * @return The value associated with key, or null if no such value exists
 */
	public void delete(String key) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		// Get first HashEntry element at hashed bucket and find out if it has linked entries <----------------- check what happens if asked to delete a key that doesn't exist
		HashEntry entry = bucketArray[bucket];
		HashEntry entryLink = entry.getLink();
		// If there is no link at first entry, delete key and value by declaring element null
		if (entryLink == null) {
			System.out.println("entry has no link, and will be removed from bucket. " + bucket + " will turn null");
			bucketArray[bucket] = null;
		} 
		// When first element contains an entry with links, copy all the entries to an array except the one with the key to delete and return all the entries to the bucket
		else {
			System.out.println("\n\nminus request to delete >> " + key + " << at bucket " + bucket + " which first contains " + entry.getKey() + " with link to " + entryLink.getKey());
			HashEntry[] arrayOfLinks = copyLinksFromBucketToArray(bucket, entry, entryLink);
			System.out.println("copyLinksFromBucketToArray returned");
			returnLinksToBucket(arrayOfLinks, bucket, key);
		}
		totalKeys--;
	}
	
	private HashEntry[] copyLinksFromBucketToArray(int bucket, HashEntry entry, HashEntry entryLink) {
		System.out.println("copyLinksFromBucketToArray with " + totalKeys + " totalKeys");
		// Initialize and array with more elements than necessary as there is no quick way to know exactly how many linked entries were inside the bucket
		HashEntry[] bufferArray = new HashEntry[totalKeys]; 
		int bufferBucketsFilled = 0;
		// Start a loop that stops as soon as no more linked entries are found
		while (entry != null) {
			// entry object keeps being updated starting at 0 and keeps incrementing as the loop is reentered
			bufferArray[bufferBucketsFilled] = entry;
			try {
				System.out.print("Loop to fill bufferArray, element #" + bufferBucketsFilled + " which contains " + entry.getKey() + " linking to " + entry.getLink().getKey() + "\n");
			}
			catch(Exception e) {
				System.out.print("Loop to fill bufferArray, element #" + bufferBucketsFilled + " which contains " + entry.getKey() + " linking to null \n");
			}
			bufferBucketsFilled++;
			entry = entry.getLink();
		}
		System.out.println("Loop to fill bufferArray exited and will start transfer to adjusted lenght array loop");
		// Once all links are collected into bufferArray, create a new array using the counter as it's optimal size and return as result of the method
		HashEntry[] arrayOfLinks = new HashEntry[bufferBucketsFilled]; // <------ maybe needs -1
		for (int i = 0; i < bufferBucketsFilled; i++) {
			arrayOfLinks[i] = bufferArray[i];

		}
		System.out.println("bufferArray lenght is " + bufferArray.length + ", and arrayOfLinks lenght is " + arrayOfLinks.length);
		System.out.println("last element of arrayOfLinks is " + arrayOfLinks[arrayOfLinks.length - 1].getKey());
		return arrayOfLinks;
	}
	
	private void returnLinksToBucket(HashEntry[] arrayOfLinks, int bucket, String key) {
		// Re-map entry links while excluding target key to remove
		for (int i = arrayOfLinks.length - 1; i >= 0; i--) {
			HashEntry entry = arrayOfLinks[i];
			if (!entry.getKey().equals(key)) {
				if (i - 1 >= 0 && !arrayOfLinks[i - 1].getKey().equals(key)) entry.setLink(arrayOfLinks[i - 1]);
				else if (i - 2 >= 0 && !arrayOfLinks[i - 2].getKey().equals(key)) entry.setLink(arrayOfLinks[i - 2]);
				else entry.setLink(null);
				try {
				System.out.println("returnLinksToBucket, position " + i + " has " + entry.getKey() + " and points to " + entry.getLink().getKey());
				}
				catch(Exception e) {
					System.out.println("returnLinksToBucket, position " + i + " has " + entry.getKey() + " and points to null");
				}
			}
		}
		bucketArray[bucket] = arrayOfLinks[arrayOfLinks.length - 1];
	}
	
/*
 * Scans the entry chain looking for an entry that matches the specified key.
 * If no such entry exists, findEntry returns null.
 */
	private HashEntry findEntry(HashEntry entry, String key) {
		System.out.print("\n");
		while (entry != null) {
			System.out.print("\nfindEntry, current entries key is " + entry.getKey() + " and goal is " + key);
			if (entry.getKey().equals(key)) return entry;
			entry = entry.getLink();
		}
		return null;
	}

	
/* Private constants */
	private static final int N_BUCKETS = 2;

/* Private instance variables */
	private HashEntry[] bucketArray;
	private int totalKeys = 0;

}
