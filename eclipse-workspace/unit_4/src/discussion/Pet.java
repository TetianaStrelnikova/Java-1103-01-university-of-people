package discussion;
/**
 * The Pet class represents a pet animal, with a name, age, and sex.
 */
public class Pet {
	private String name;
	private int age;
	private String sex;

	 /**
     * Constructs a new Pet object with the given name, age, and sex.
     *
     * @param name the name of the pet
     * @param age the age of the pet, in years
     * @param sex the sex of the pet (either "Male" or "Female")
     */
	public Pet(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	/**
     * Constructs a new Pet object with default values for the name, age, and sex fields.
     * The name is set to "Fluffy", the age is set to 1, and the sex is set to "Male".
     */
	public Pet() {
		// Set the name field to "Fluffy"
		this.name = "Fluffy";

		// Set the age field to 1
		this.age = 1;

		// Set the sex field to "Male"
		this.sex = "Male";
	}
	/**
     * Compares this Pet object to the specified object for equality.
     * Returns true if the other object is also a Pet with the same name, age, and sex,
     * or false otherwise.
     *
     * @param obj the object to compare to this Pet
     * @return true if the objects are equal, false otherwise
     */
    @Override
	public boolean equals(Object obj) {
		// The method first checks
		// if the two objects are the same reference, using the == operator.
		if (this == obj) {
			return true;
		}
		// Check if the other object is a Pet
		// If the two objects are not the same reference,
		// the method checks if the parameter object is a Pet object, using the
		// instanceof operator.
		// If the parameter is not a Pet object, the method returns false,
		// two objects of different classes cannot be equal.
		if (!(obj instanceof Pet)) {
			return false;
		}
		// If the parameter object is a Pet object,
		// the method casts it to a Pet reference and compares the values of the name,
		// age, and sex
		//using the equals() method of String and the == operator for comparing primitive types. 
		// If all fields are equal, the method returns true,
		// indicating that the two objects are equal.
		// If any field is different, the method returns false.
		Pet other = (Pet) obj;
		return name.equals(other.name) && age == other.age && sex.equals(other.sex);
	}
    /**
     * A simple test program that creates two Pet objects and compares them for equality.
     * If the objects are equal, it prints "the objects are equal".
     * If the objects are not equal, it prints "the objects are NOT equal".
     *
     * @param args the command-line arguments
     */
	public static void main(String[] args) {
		Pet cat = new Pet();
		Pet dog = new Pet();

		if (cat.equals(dog)) {
			System.out.println("the objects are equal");
		} else {
			System.out.println("the objects are NOT equal");
		}

	}
}
