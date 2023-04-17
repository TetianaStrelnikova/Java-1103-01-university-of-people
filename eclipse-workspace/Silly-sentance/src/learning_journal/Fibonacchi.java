package learning_journal;

/*
fibonacci(0) = 1
fibonacci(1) = 1
fibonacci(N) = fibonacci(N-1) + fibonacci(N-2) for N > 1
*/
public class Fibonacchi {
	/**
	 * 
	 * The nth number in the Fibonacci sequence.
	 */
	public int fibonacchi;

	/**
	 * 
	 * Initializes a Fibonacchi object with the nth number in the Fibonacci
	 * sequence.
	 * 
	 * @param a the index of the desired Fibonacci number (starting at 0)
	 * @throws IllegalArgumentException if a is negative
	 */
	Fibonacchi(int a) throws IllegalArgumentException {
		this.fibonacchi = calculateFibonacchi(a);
	}

	/**
	 * 
	 * Calculates the nth number in the Fibonacci sequence using recursion.
	 * 
	 * @param b the index of the desired Fibonacci number (starting at 0)
	 * @return the Fibonacci number at the given index
	 * @throws IllegalArgumentException if b is negative
	 */
	public int calculateFibonacchi(int b) throws IllegalArgumentException {
		if (b < 0) {
			throw new IllegalArgumentException("Input cannot be negative.");
		} else if (b == 0) {
			return 0;
		} else if (b == 1) {
			return 1;
		} else {
			return calculateFibonacchi(b - 1) + calculateFibonacchi(b - 2);
		}
	}

	/**
	 * 
	 * Main method to test the Fibonacchi class by initializing objects with
	 * different Fibonacci numbers.
	 */
	public static void main(String[] args) {
		for (int i = -1; i < 10; i++) {
			try {
				Fibonacchi c = new Fibonacchi(i);
				System.out.println(c.fibonacchi);
			} catch (IllegalArgumentException e) {
				System.out.println("IllegalArgumentException caught: " + e.getMessage());
			}
		}

	}

}
