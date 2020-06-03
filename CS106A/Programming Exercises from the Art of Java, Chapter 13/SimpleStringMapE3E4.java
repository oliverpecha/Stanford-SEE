/*
 * File: SimpleStringMapOwnE3.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 3 and 4
 * -----------------
 * This file implements a simplified version of the Map interface
 * that supports only the get and put methods.  This version uses
 * a simple hashing technique in which the entries are assigned to
 * buckets based on their hash code.  When collisions occur that
 * cause keys to hash to the same bucket, the collisions are resolved
 * by linking all the entries belonging to that bucket into a chain.
 */

/** This class implements a simplified version of the Map interface */
public class SimpleStringMapE3E4 {

/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringMapE3E4() {
		bucketArray = new HashEntry[N_BUCKETS];
	}

/**
 * Sets the value associated with key.  Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public void put(String key, String value) {
		// If entering a new key means that totalKeys are more than half the available buckets, double the bucketArray
		if (totalKeys + 1 > bucketArray.length / 2) {
			System.out.println("bucketArray will be doubled as it's " + bucketArray.length + " long, and there is " + totalKeys + " totalKeys");
			doubleArray(bucketArray.length);
		}
		// Hash the key to match it to a bucket, look in such bucket for the key and return the result in the form of an entry
		int bucket = Math.abs(key.hashCode()) % bucketArray.length;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		// If entry is null, such key doesn't exist yet, create a HashEntry with desired key and value, insert it at bucket and increment totalKeys count
		if (entry == null) {
			entry = new HashEntry(key, value);
			entry.setLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
			totalKeys++;
		// In the event the key is already at the bucket, update it's value
		} else {
			entry.setValue(value);
		}
	}
	
	private void doubleArray(int pastSize) {
		// Initialize an array twice the size 
		HashEntry[] doubledArray = new HashEntry[pastSize * 2];
		for (int i = 0; i < bucketArray.length; i++) {
			if (bucketArray[i] != null) {
			// Transfer all linked keys from bucketArray into  an arrayBuffer
			System.out.println("\ncopyLinksFrom " + i + " BucketToArray");		
			HashEntry[] arrayBuffer = copyLinksFromBucketToArray(i);
			// Rehash all the values in bucketArray element i into arrayBuffer
			doubledArray = reHashArray(arrayBuffer, doubledArray);
			}
		}
		bucketArray = doubledArray;
		System.out.println("bucketArray is now " + bucketArray.length + " long");	
	}	

	private HashEntry[] reHashArray(HashEntry[] arrayBuffer, HashEntry[] doubledArray) {
		// Receive an arrayBuffer with all the linked keys in a given bucket, keep moving through doubledArray re-maping entries to a new bucket in doubledArray
		for (int i = 0; i < arrayBuffer.length; i++) {
			HashEntry entry = arrayBuffer[i];			
			int bucket = Math.abs(entry.getKey().hashCode()) % doubledArray.length;
			// Look what's at the defined bucket on doubledArray, if it's empty, reset entry link to null as no linking is necessary at this point
			if (doubledArray[bucket] == null) {
				entry.setLink(null);
			}
			// When a collisions exists, take a temporary entry from the doubledArray bucket and re-map entry to link to to temp entry
			else {
				HashEntry temp = doubledArray[bucket];
				entry.setLink(temp);
			}
			// Regardless, update the bucket with entry found at arrayBuffer[i]
			doubledArray[bucket] = entry;
		}
		return doubledArray;
	}

/**
 * Retrieves the value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @return The value associated with key, or null if no such value exists
 */
	public String get(String key) {
		int bucket = Math.abs(key.hashCode()) % bucketArray.length; //<---------- maybe needs a -1
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
		int bucket = Math.abs(key.hashCode()) % bucketArray.length; //<---------- maybe needs a -1
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
			HashEntry[] arrayOfLinks = copyLinksFromBucketToArray(bucket);
			System.out.println("copyLinksFromBucketToArray returned");
			returnLinksToBucket(arrayOfLinks, bucket, key);
		}
		totalKeys--;
	}
	
	private HashEntry[] copyLinksFromBucketToArray(int bucket) {
		 HashEntry entry = bucketArray[bucket];
		System.out.println("copyLinksFromBucketToArray with " + totalKeys + " totalKeys, first occurrence in " + bucket + " is " + entry);
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
