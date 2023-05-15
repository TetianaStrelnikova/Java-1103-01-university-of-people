package discussion;
import java.util.HashSet;
public class examples {
	/**
	 * This program demonstrates the use of a HashSet 
	 * to store a collection of pet names and perform membership testing.
	 *
	 * A HashSet is created to store a collection of unique pet names. 
	 * Two membership tests are then performed using the contains() method:
	 * - The first test checks for the presence of a non-existent pet name ("Nemo").
	 * - The second test checks for the presence of an existing pet name ("Varvara").
	 * 
	 * The results of each test are printed to the console.
	 * 
	 * @param args The command-line arguments passed to the program (unused in this example).
	 */
	public static void main(String[] args) {
		HashSet<String> myPets = new HashSet<>();
		myPets.add("Rim");
		myPets.add("Nord");
		myPets.add("Varvara");
		System.out.println(myPets.contains("Nemo")); // Output: false
		System.out.println(myPets.contains("Varvara")); // Output: true
		
		

	}

}
