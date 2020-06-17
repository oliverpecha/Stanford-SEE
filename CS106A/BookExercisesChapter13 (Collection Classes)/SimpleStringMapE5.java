/*
 * File: SimpleStringMapOwnE5.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 5
 * -----------------
 * This file implements a simplified version of the Map interface
 * that supports only the get and put methods.  This version uses
 * a simple hashing technique in which the entries are assigned to
 * buckets based on their hash code.  When collisions occur that
 * cause keys to hash to the same bucket, the collisions are resolved
 * by linking all the entries belonging to that bucket into a chain.
 */

/** This class implements a simplified version of the Map interface */
public class SimpleStringMapE5 {

/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringMapE5() {
		bucketArray = new HashEntry[N_BUCKETS];
	}

/**
 * Sets the value associated with key.  Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public boolean put(String key, String value) {
		if (totalKeys + 1 > bucketArray.length / 2) {
			System.out.println("bucketArray will be doubled as it's " + bucketArray.length + " long, and there is " + totalKeys + " totalKeys");
			doubleArray(bucketArray.length);
		}
		if (placeInBucket(key, value, bucketArray)) {
			totalKeys++;
			System.out.println("after adding " + key + " array is now " + bucketArray.length + " long and totalKeys is " + totalKeys);

			return true;
		}
		else return false;
		
	}
	
	private boolean placeInBucket(String key, String value, HashEntry[] array) {
		int bucket = Math.abs(key.hashCode()) % array.length;
		HashEntry entry = array[bucket];	
				try {
					System.out.println(key + " is supposed to fit in " + bucket + " bucket, which contains: " + entry.getKey());			
				}
				catch (Exception e) {
					System.out.println(key + " is supposed to fit in " + bucket + " bucket, which is null");
				}
		if (entry == null) {
			entry = new HashEntry(key, value);
			array[bucket] = entry;
		} else {		
			if (entry.getKey().compareTo(key) != 0) { // <---------------------------------------- couls also try equals
				int freeBucket = bucket;
				for (int i = bucket + 1; i < array.length; i++) {
					freeBucket = findFreeBucket(i, bucket, array);
					if (freeBucket != bucket) i = array.length;
				}
				if (freeBucket == bucket) {
					for (int i = 0; i < bucket; i++) {
						freeBucket = findFreeBucket(i, bucket, array);
						if (freeBucket != bucket) i = array.length;
					}	
				}
				if (freeBucket != bucket) {
					entry = new HashEntry(key, value);
					array[freeBucket] = entry;					
				}
				else {
					System.out.println("nowhere to fit " + key + " :@");
					return false;
				}
			}
			else entry.setValue(value);
		}
		return true;
	}
	
	
	private int findFreeBucket(int i, int bucket, HashEntry[] array) {
		HashEntry temp = array[i];
		if (temp == null) {
			return i;
		}
		else return bucket;
	}
	
	
	private void doubleArray(int pastSize) {
		HashEntry[] doubledArray = new HashEntry[pastSize * 2];
		for (int i = 0; i < bucketArray.length; i++) {
			HashEntry entry = bucketArray[i];
			if (entry != null) doubledArray[i] = entry;
		}
		bucketArray = doubledArray;
		reHash(-1);
	}
	
	
/**
 * Retrieves the value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @return The value associated with key, or null if no such value exists
 */
	public String get(String key) {
		int bucket = Math.abs(key.hashCode()) % bucketArray.length;
		HashEntry entry = bucketArray[bucket];
		if (entry == null) {
			return null;
		} else {
			if (entry.getKey().compareTo(key) != 0) {
				for (int i = bucket + 1; i < bucketArray.length; i++) {
					entry = bucketArray[i];
					if (entry != null && entry.getKey().compareTo(key) == 0) return bucketArray[i].getValue();
				}
				for (int i = 0; i < bucket; i++) {
					entry = bucketArray[i];
					if (entry != null && entry.getKey().compareTo(key) == 0) return bucketArray[i].getValue();
				}
				return null;
			}
			else return entry.getValue();	
		}
	}

	/**
	 * Retrieves the value associated with key, or null if no such value exists.
	 * @param key The key used to look up the value
	 * @return The value associated with key, or null if no such value exists
	 */
		public boolean delete(String key) {
			int bucket = Math.abs(key.hashCode()) % bucketArray.length;
			HashEntry entry = bucketArray[bucket];
			if (entry == null) {
				return false;
			} else {
				if (entry.getKey().compareTo(key) != 0) {
					for (int i = bucket + 1; i < bucketArray.length; i++) {
						entry = bucketArray[i];
						if (entry != null && entry.getKey().compareTo(key) == 0) {
							emptyBucket(i, key);
							return true;
						}
					}
					for (int i = 0; i < bucket; i++) {
						entry = bucketArray[i];
						if (entry != null && entry.getKey().compareTo(key) == 0) {
							emptyBucket(i, key);
							return true;
						}
					}
				}
				else {
					emptyBucket(bucket, key);
					return true;
				}
			}
			return false;
		}
		
		private void emptyBucket(int bucket, String key) {
			bucketArray[bucket] = null;
			if (totalKeys - 1 < bucketArray.length / 2) {
				System.out.println("bucketArray will be cut to half as it's " + bucketArray.length + " long, and there is " + totalKeys + " totalKeys");
				halfArray(bucketArray.length);
			}
			totalKeys--;
			System.out.println("after removing " + key + " array is now " + bucketArray.length + " long and totalKeys is " + totalKeys);
			reHash(bucket);
			
		}

		private void reHash(int bucket) {
			for (int i = 0; i < bucketArray.length; i++) {
				if (i != bucket) {
					HashEntry entry = bucketArray[i];
					if (entry != null) {
						int properBucket = Math.abs(entry.getKey().hashCode()) % bucketArray.length;
						if (properBucket != i) {
							bucketArray[i] = null;
							placeInBucket(entry.getKey(), entry.getValue(), bucketArray);
						}			
					}
				}
			}
		}
		
		private void halfArray(int pastSize) {
			HashEntry[] halfArray = new HashEntry[pastSize /2];
			int transfered = 0; // <----------------------------------------------- temp
			for (int i = 0; i < bucketArray.length; i++) {
				HashEntry entry = bucketArray[i];
				if (entry != null) {
					transfered++;
					int bucket = Math.abs(entry.getKey().hashCode()) % halfArray.length;
					HashEntry temp = halfArray[bucket];
					if (temp == null) {
						halfArray[bucket] = entry;
					}
					else placeInBucket(entry.getKey(), entry.getValue(), halfArray);
				}
			}
		System.out.println("array has been cut in half and " + transfered + " keys have been tranfered ");
		bucketArray = halfArray;
		reHash(-1);
		}
		
/* Private constants */
	private static final int N_BUCKETS = 2;


/* Private instance variables */
	private HashEntry[] bucketArray;
	private int totalKeys = 0;


}
