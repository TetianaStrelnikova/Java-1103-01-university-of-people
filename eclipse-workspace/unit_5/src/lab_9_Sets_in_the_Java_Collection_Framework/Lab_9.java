package lab_9_Sets_in_the_Java_Collection_Framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JFileChooser;

/**
 * 
 * A program that reads a list of words from a file, stores them in a HashSet,
 * and then reads another file and checks each word to see if it is contained in
 * the HashSet. If a word is not found, the program generates a list of possible
 * corrections to suggest for the misspelled word. Possible corrections include
 * deleting any one letter, changing any letter to any other letter, inserting
 * any letter at any point, swapping two neighboring characters, and inserting a
 * space at any point (and checking that both words that are produced are in the
 * dictionary).
 */
public class Lab_9 {

	/**
	 * 
	 * Lets the user select an input file using a standard file selection dialog
	 * box. If the user cancels the dialog without selecting a file, the return
	 * value is null.
	 * 
	 * @return The selected File object, or null if the dialog was canceled.
	 */
	static File getInputFileNameFromUser() {
		JFileChooser fileDialog = new JFileChooser();
		fileDialog.setDialogTitle("Select File for Input");
		int option = fileDialog.showOpenDialog(null);
		if (option != JFileChooser.APPROVE_OPTION)
			return null;
		else
			return fileDialog.getSelectedFile();
	}

	/**
	 * 
	 * Generates and returns a TreeSet<String> containing variations on the
	 * misspelled word that are contained in the dictionary.
	 * 
	 * @param badWord    The misspelled word to generate corrections for.
	 * @param dictionary A HashSet of known words to use as a dictionary for
	 *                   markdown generating corrections.
	 * @return A TreeSet of suggested corrections for the misspelled word, or null
	 *         if no suggestions are found.
	 */
	static TreeSet<String> corrections(String badWord, HashSet<String> dictionary) {
		TreeSet<String> corrections = new TreeSet<String>();
		// Delete any one of the letters from the misspelled word
		// Loop through each letter of the misspelled word.
		for (int i = 0; i < badWord.length(); i++) {
			// Delete the i-th letter of the misspelled word by concatenating the substring
			// of the misspelled word up to the i-th letter with the substring after the
			// i-th letter.
			// all the characters from the beginning of the string up to
			// (but not including) the character at position i.
			// includes all the characters from position i+1 to the end of the string.
			String deletion = badWord.substring(0, i) + badWord.substring(i + 1);
			if (dictionary.contains(deletion)) {
				corrections.add(deletion);
			}
		}

		// Change any letter in the misspelled word to any other letter
		for (int i = 0; i < badWord.length(); i++) {

			for (char ch = 'a'; ch <= 'z'; ch++) {
				String substitution = badWord.substring(0, i) + ch + badWord.substring(i + 1);
				if (dictionary.contains(substitution)) {
					corrections.add(substitution);
				}
			}
		}
		// Insert any letter at any point in the misspelled word

		for (int i = 0; i <= badWord.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				String insertion = badWord.substring(0, i) + ch + badWord.substring(i);
				if (dictionary.contains(insertion)) {
					corrections.add(insertion);
				}
			}
		}
		// Swap any two neighboring characters in the misspelled word
		for (int i = 0; i < badWord.length() - 1; i++) {
			String transposition = badWord.substring(0, i) + badWord.charAt(i + 1) + badWord.charAt(i)
					+ badWord.substring(i + 2);
			if (dictionary.contains(transposition)) {
				corrections.add(transposition);
			}
		}
		// Insert a space at any point in the misspelled word
		for (int i = 1; i < badWord.length(); i++) {
			String[] words = { badWord.substring(0, i), badWord.substring(i) };
			if (dictionary.contains(words[0]) && dictionary.contains(words[1])) {
				corrections.add(words[0] + " " + words[1]);
			}
		}
		return corrections.isEmpty() ? null : corrections;
	}

	/**
	 * This main reads a list of correctly spelled words from a file named
	 * "words.txt" and stores them in a HashSet. Then, it prompts the user to select
	 * a file to spell-check. It reads each word from the file and checks if it is
	 * contained in the HashSet of correctly spelled words. If not, it adds the word
	 * to a HashSet of misspelled words. For each misspelled word, it generates a
	 * TreeSet of potential corrections by performing the following operations:
	 * Delete any one of the letters from the misspelled word. Change any letter in
	 * the misspelled word to any other letter. Insert any letter at any point in
	 * the misspelled word. Swap any two neighboring characters in the misspelled
	 * word. Insert a space at any point in the misspelled word. If there are no
	 * potential corrections for a misspelled word, it prints "no corrections".
	 * Otherwise, it prints the potential corrections in alphabetical order.
	 * 
	 * @param args an array of command-line arguments (not used)
	 */
	public static void main(String[] args) {
		HashSet<String> words = new HashSet<String>();
		try {
			Scanner fileIn = new Scanner(new File("words.txt"));
			while (fileIn.hasNext()) {
				String word = fileIn.next().toLowerCase();
				words.add(word);
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}
		System.out.println("Number of words in set: " + words.size());
		//System.out.println("Set contains 'hello': " + words.contains("hello"));

		// Let the user select an input file
		File userFile = getInputFileNameFromUser();
		if (userFile == null) {
			System.out.println("No file selected.");
			return;
		}

		// Read words from the input file and check for spelling errors
		HashSet<String> misspelledWords = new HashSet<String>();
		try {
			Scanner userFileIn = new Scanner(userFile);

			userFileIn.useDelimiter("[^a-zA-Z]+"); // Skip non-letter characters
			while (userFileIn.hasNext()) {
				String userWord = userFileIn.next().toLowerCase();
				if (!words.contains(userWord)) {
					misspelledWords.add(userWord);

				}
			}
			userFileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found.");
			return;
		}
		/*
		 * This is a for loop that iterates over each misspelled word in the HashSet
		 * "misspelledWords". For each misspelled word, it calls the "corrections"
		 * method, passing in the misspelled word and the HashSet "words" as arguments.
		 * The "corrections" method returns a TreeSet of suggestions to correct the
		 * misspelled word. If the TreeSet is null, it prints out the misspelled word
		 * and the message "no corrections" to the console. Otherwise, it prints out the
		 * misspelled word and the TreeSet of suggestions to the console.
		 */
		for (String badWord : misspelledWords) {
			TreeSet<String> suggestions = corrections(badWord, words);
			if (suggestions == null) {
				System.out.println(badWord + ": no corrections");
			} else {
				System.out.println(badWord + ": " + suggestions);
			}
		}
	}
}
