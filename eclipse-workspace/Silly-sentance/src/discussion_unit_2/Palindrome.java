package discussion_unit_2;

public class Palindrome {
	/**
	 * 
	 * This method checks whether a given string is a palindrome or not. A string is
	 * said to be palindrome if it reads the same backward as forwards.
	 * 
	 * @param s the string to be checked
	 * @return true if the given string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * 
	 * This method checks whether a given string is a palindrome or not using
	 * recursion. A string is said to be palindrome if it reads the same backward as
	 * forwards.
	 * 
	 * @param s the string to be checked
	 * @return true if the given string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome_recursion(String s) {
		s = s.toLowerCase();
		if (s.length() <= 1) {
			return true;
		} else {
			char first = s.charAt(0);
			char last = s.charAt(s.length() - 1);
			if (first == last) {
				String sub = s.substring(1, s.length() - 1);

				return isPalindrome_recursion(sub);

			} else {
				return false;
			}

		}
	}

	public static void main(String[] args) {

		System.out.println(isPalindrome_recursion("Saippuakivikauppias"));
		System.out.println(isPalindrome("Saippuakivikauppias"));
		System.out.println(isPalindrome_recursion("Tati"));
		System.out.println(isPalindrome("Tati"));

	}
}
