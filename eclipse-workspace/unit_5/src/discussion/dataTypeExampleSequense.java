package discussion;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
public class dataTypeExampleSequense {

	
	/**
	 * This program demonstrates the use of a HashSet, TreeSet, and LinkedHashSet 
	 * to store a collection of dog breeds.
	 * 
	 * A HashSet is created to store a collection of dog breeds without duplicates. 
	 * Three dog breed strings are added to the HashSet using the add() method:
	 * - The first dog breed is "Bulldog".
	 * - The second dog breed is "Labrador Retriever".
	 * - The third dog breed is "Siberian Husky".
	 * 
	 * The contains() method is then used to check if "Labrador Retriever" 
	 * is present in the HashSet, and the result is printed to the console.
	 * 
	 * A TreeSet is also created to store the same collection of dog breeds, 
	 * with the same three dog breeds added using the add() method. 
	 * The elements in the TreeSet are then traversed in sorted order 
	 * using a for-each loop, and each dog breed is printed to the console.
	 * 
	 * The sorted output shows the dog breeds sorted in lexicographic order.
	 * 
	 * A LinkedHashSet is also created to store the same collection of dog breeds, 
	 * with the same three dog breeds added using the add() method. 
	 * The elements in the LinkedHashSet are then traversed in insertion order 
	 * using a for-each loop, and each dog breed is printed to the console.
	 * 
	 * The ordered output shows the dog breeds in the order they were inserted.
	 * 
	 * @param args The command-line arguments passed to the program (unused in this example).
	 */
	public static void main(String[] args) {
	    HashSet<String> mySet = new HashSet<>();
	    mySet.add("Bulldog");
	    mySet.add("Labrador Retriever");
	    mySet.add("Siberian Husky");
	    System.out.println(mySet.contains("Labrador Retriever")); // Output: true

	    TreeSet<String> mySortedSet = new TreeSet<>();
	    mySortedSet.add("Bulldog");
	    mySortedSet.add("Labrador Retriever");
	    mySortedSet.add("Siberian Husky");
	    for (String breed : mySortedSet) {
	        System.out.println(breed);
	    }
	    // Output: Bulldog
	    //         Labrador Retriever
	    //         Siberian Husky

	    LinkedHashSet<String> myOrderedSet = new LinkedHashSet<>();
	    myOrderedSet.add("Bulldog");
	    myOrderedSet.add("Labrador Retriever");
	    myOrderedSet.add("Siberian Husky");
	    for (String breed : myOrderedSet) {
	        System.out.println(breed);
	    }
	    // Output: Bulldog
	    //         Labrador Retriever
	    //         Siberian Husky
	}

}
