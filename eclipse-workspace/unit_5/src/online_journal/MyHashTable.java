package online_journal;

/**
 * A hashtable implementation for storing key-value pairs.
 */
class MyHashTable {
	/**
	 * The underlying array of linked lists representing the hashtable.
	 */
	private MyNode[] table;
	/**
	 * The number of key-value pairs stored in the hashtable.
	 */
	private int count;

	/**
	 * Constructs a hashtable with the specified initial capacity.
	 *
	 * @param initialSize The initial capacity of the hashtable.
	 * @throws IllegalArgumentException if the initial size is less than or equal to
	 *                                  0.
	 */
	public MyHashTable(int initialSize) {
		assert initialSize < 0 : "The initial Size must be non-null";
		table = new MyNode[initialSize];
	}

	/**
	 * Inserts a key-value pair into the hashtable. If the key already exists, the
	 * value is updated. If the load factor exceeds 0.75, the hashtable is resized.
	 *
	 * @param key   The key of the entry.
	 * @param value The value associated with the key.
	 */
	public void put(String key, String value) {

		assert key != null : "The key could not be null";
		int hashIndex = key.hashCode();
		MyNode list = table[hashIndex];
		while (list != null) {
			if (list.key.equals(key))
				break;
			list = list.next;
		}
		if (list != null) {
			list.value = value;
		} else {
			if (count >= 0.75 * table.length) {
				resize();
				hashIndex = key.hashCode();
			}
			MyNode newNode = new MyNode();
			newNode.key = key;
			newNode.value = value;
			newNode.next = table[hashIndex];
			table[hashIndex] = newNode;
			count++;
		}
	}

	/**
	 * Retrieves the value associated with the specified key.
	 *
	 * @param key The key to search for.
	 * @return The value associated with the key, or null if the key is not found.
	 */
	public String get(String key) {

		int hashIndex = key.hashCode();

		MyNode list = table[hashIndex];
		while (list != null) {
			if (list.key.equals(key))
				return list.value;
			list = list.next;
		}

		return null;
	}

	/**
	 * Removes the entry with the specified key from the hashtable.
	 *
	 * @param key The key of the entry to remove.
	 */
	public void remove(String key) {

		int hashIndex = key.hashCode();

		if (table[hashIndex] == null) {
			return;
		}

		if (table[hashIndex].key.equals(key)) {
			table[hashIndex] = table[hashIndex].next;
			count--;
			return;
		}

		MyNode prev = table[hashIndex];
		MyNode curr = prev.next;
		while (curr != null && !curr.key.equals(key)) {
			curr = curr.next;
			prev = curr;
		}

		if (curr != null) {
			prev.next = curr.next;
			count--;
		}
	}

	/**
	 * Checks if the hashtable contains the specified key.
	 *
	 * @param key The key to search for.
	 * @return true if the hashtable contains the key, false otherwise.
	 */
	public boolean containsKey(String key) {

		int hashIndex = key.hashCode();

		MyNode list = table[hashIndex];
		while (list != null) {
			if (list.key.equals(key))
				return true;
			list = list.next;
		}
		return false;
	}

	/**
	 * Returns the number of key-value pairs stored in the hashtable.
	 *
	 * @return The size of the hashtable.
	 */
	public int size() {
		return count;
	}

	/**
	 * Resizes the hashtable by creating a new array of nodes with double the size
	 * and rehashing all the key-value pairs into the new array. This method is
	 * called when the load factor exceeds 0.75.
	 * 
	 * Note: This method is private and is only called internally by the hashtable.
	 */
	private void resize() {
		MyNode[] newtable = new MyNode[table.length * 2];
		for (int i = 0; i < table.length; i++) {
			MyNode list = table[i];
			while (list != null) {
				MyNode next = list.next;
				int hash = (Math.abs(list.key.hashCode())) % newtable.length;
				list.next = newtable[hash];
				newtable[hash] = list;
				list = next;
			}
		}
		table = newtable;
	}

}