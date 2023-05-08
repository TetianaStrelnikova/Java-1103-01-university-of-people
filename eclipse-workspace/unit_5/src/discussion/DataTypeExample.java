package discussion;
import java.util.TreeMap; 
import java.util.HashMap;
public class DataTypeExample {
	/**
	 * This program demonstrates the use of a HashMap and a TreeMap 
	 * to store key-value pairs representing names and ages.
	 * 
	 * A HashMap is created to store key-value pairs, 
	 * where the keys are strings representing names and the values are integers representing ages. 
	 * Two key-value pairs are added to the HashMap using the put() method:
	 * - The first pair has a key of "Tati" and a value of 33.
	 * - The second pair has a key of "Oleksii" and a value of 35.
	 * 
	 * The age of the person named "Tati" is retrieved from the HashMap 
	 * using the get() method and printed to the console.
	 * 
	 * A TreeMap is also created to store key-value pairs, 
	 * with the same key-value pairs added as in the HashMap example. 
	 * The keys in the TreeMap are then traversed in sorted order using a for-each loop, 
	 * and each key-value pair is printed to the console in the format "key: value".
	 * 
	 * The sorted output shows the key-value pairs sorted by the keys in alphabetical order.
	 * 
	 * @param args The command-line arguments passed to the program (unused in this example).
	 */
	public static void main(String[] args) {
		HashMap<String, Integer> myMap = new HashMap<>();
		myMap.put("Tati", 33);
		myMap.put("Oleksii", 35);
		int age = myMap.get("Tati");
		System.out.println(age); // Output: 33

		TreeMap<String, Integer> mySortedMap = new TreeMap<>();
		mySortedMap.put("Tati", 33);
		mySortedMap.put("Oleksii", 35);
		for (String name : mySortedMap.keySet()) {
		    System.out.println(name + ": " + mySortedMap.get(name));
		}
		// Output: Tati: 33
//		         Oleksii: 35
	}

}
