package discussion;
import java.util.TreeMap; 
public class TreeSetExample {
	/**
	 * This program demonstrates the use of a TreeMap 
	 * to store a collection of pet names and traverse the keys in sorted order.
	 * 
	 * A TreeMap is created to store key-value pairs, 
	 * where the keys are integers representing pet IDs and the values are pet names.
	 * Three key-value pairs are added to the TreeMap using the put() method:
	 * - The first pair has a key of 1 and a value of "Varvara".
	 * - The second pair has a key of 3 and a value of "Rim".
	 * - The third pair has a key of 2 and a value of "Nord".
	 * 
	 * The keys in the TreeMap are then traversed in sorted order using a for-each loop, 
	 * and each key-value pair is printed to the console in the format "key: value".
	 * 
	 * The sorted output shows the key-value pairs sorted by the integer keys.
	 * 
	 * @param args The command-line arguments passed to the program (unused in this example).
	 */
	public static void main(String[] args) {
		TreeMap<Integer, String> myPets = new TreeMap<>();
		myPets.put(1, "Varvara");
		myPets.put(3, "Rim");
		myPets.put(2, "Nord");
		for (Integer key : myPets.keySet()) {
		    System.out.println(key + ": " + myPets.get(key));
		}
		// Output:
		// 1: Varvara
		// 2: Nord
		// 3: Rim
	}

}
