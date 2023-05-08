package online_jounal;

import java.util.*;

public class SetCalculator {
	/**
	 * Convert a string representation of a set to a TreeSet of integers.
	 *
	 * @param str the string representation of the set
	 * @return a TreeSet of integers representing the set
	 * @throws NumberFormatException if the input string cannot be parsed as an integer
	 */
	public static TreeSet<Integer> convertToTreeSet(String str) {
	    String[] splitedParts = str.replace("[", "").replace("]", "").split(",");
	    TreeSet<Integer> numbers = new TreeSet<>();
	    for (String part : splitedParts) {
	        try {
	            numbers.add(Integer.parseInt(part));
	        } catch (NumberFormatException e) {
	            throw new NumberFormatException("Syntax error: input should be in propriate format, example: [1,2,3] + [1,3,5] ");
	        }
	    }
	    return numbers;
	}

	/**
	 * Reads expressions from the console, evaluates them, and prints the result.
	 * Expressions should be in the form of [1,2,3] operator [4,5,6], where
	 * operator is one of +, *, or - for union, intersection, or difference
	 * respectively. Each expression should be entered on a separate line.
	 * 
	 * If a line is empty, the program will exit gracefully. If a line contains
	 * a syntax error, the program will report the error and move on to the
	 * next line of input. If a line contains an invalid operator or invalid
	 * input, the program will report a syntax error and move on to the next
	 * line of input.
	 * 
	 * @param args the command line arguments (not used)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter expression, (example [1,3,4] + [1,3,5]) or Enter to quit: ");
			String input = scanner.nextLine();
			// exit the loop if Enter pressed
			if (input.isEmpty()) {
				break;
			}

			String[] parts = input.split("\\s+");
			if (parts.length != 3) {
				System.out.println("Syntax error: input should be in the format [1,2,3] + [4,5,6]");
				continue; // move on to the next line of input
			}
			if (parts[1].equals("+") || parts[1].equals("*") || parts[1].equals("-")) {
				try {
					TreeSet<Integer> result = new TreeSet<>(convertToTreeSet(parts[0]));

					if (parts[1].equals("+")) {
						// compute the union of set1 and set2
						result.addAll(convertToTreeSet(parts[2]));
						System.out.println(input + " = " + result);
					} else if (parts[1].equals("*")) {
						// compute the intersection
						result.retainAll(convertToTreeSet(parts[2]));
						System.out.println(input + " = " + result);
					} else if (parts[1].equals("-")) {
						// compute the difference
						result.removeAll(convertToTreeSet(parts[2]));
						System.out.println(input + " = " + result);
					}
				} catch (NumberFormatException e) {
					System.out.println("Syntax error: input should be in the format [1,2,3] + [4,5,6]");
				}
			} else {
				System.out.println("Syntax error: invalid operator, use +, *, or -");
				continue;
			}
			
		}
		scanner.close();
		System.out.println("Goodbye!");
	}
}
