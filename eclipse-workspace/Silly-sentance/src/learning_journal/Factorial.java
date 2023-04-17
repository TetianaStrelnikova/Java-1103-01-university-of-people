package learning_journal;

public class Factorial {
	/*
	 * factorial(0) = 1 factorial(N) = N*factorial(N-1) for N > 0
	 */
	public int factorial;

	/**
	 * Constructs a new Factorial object that calculates the factorial of a given
	 * integer.
	 *
	 * @param a the integer whose factorial is to be calculated
	 * @throws IllegalArgumentException if the given integer is negative
	 */
	Factorial(int a) throws IllegalArgumentException {
		this.factorial = calculateFactorial(a);
	}

	/**
	 * Calculates the factorial of a given integer.
	 *
	 * @param b the integer whose factorial is to be calculated
	 * @return the factorial of the given integer
	 * @throws IllegalArgumentException if the given integer is negative
	 */
	public static int calculateFactorial(int b) throws IllegalArgumentException {
		if (b < 0) {
			throw new IllegalArgumentException("Input cannot be negative.");
		} else if (b == 1 || b == 0) {
			return 1;
		} else {
			return b * calculateFactorial(b - 1);
		}
	}

	/**
	 * The main method is the entry point of the Java application. It initializes a
	 * new Factorial object with input of 10 and prints the calculated factorial. If
	 * an IllegalArgumentException is caught during the creation of the Factorial
	 * object, it prints an error message with the exception message.
	 *
	 * @param args the command line arguments passed to the application (not used in
	 *             this example)
	 */
	public static void main(String[] args) {
		for (int i = -1; i < 10; i++) {
			try {
				// Create a new Factorial object with input of 10
				Factorial first = new Factorial(i);
				// Print the calculated factorial
				System.out.println(first.factorial);
			} catch (IllegalArgumentException e) { // Catch the IllegalArgumentException
				// Print an error message
				System.out.println("IllegalArgumentException caught: " + e.getMessage());
			}
		}
	}
}
