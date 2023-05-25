package non_gradedExersise;

import java.io.File;
import java.util.Scanner;

/**
 * This program lists the files in a directory specified by the user. The user
 * is asked to type in a directory name. If the name entered by the user is not
 * a directory, a message is printed and the program ends.
 */
public class DirectoryList {

	public static void main(String[] args) {

		String[] files; // Array of file names in the directory.
		try (Scanner scanner = new Scanner(System.in);) {
			// For reading a line of input from the user.scanner reads from
			// standard input.
			System.out.print("Enter a directory name: ");
			String directoryName = scanner.nextLine().trim(); // Directory name entered by the user.
			File directory = new File(directoryName); // File object referring to the directory.

			if (directory.isDirectory() == false) {
				if (directory.exists() == false)
					System.out.println("There is no such directory!");
				else
					System.out.println("That file is not a directory.");
			} else {
				System.out.println("Files in directory \"" + directory + "\":");
				listFiles(directory);
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());

		}
	}

	/**
	 * Recursive method to list all files in a directory and its subdirectories.
	 * 
	 * @param dir The directory to list files from.
	 */
	public static void listFiles(File dir) {
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					listFiles(file); // Recursively call the method for subdirectories
				} else {
					System.out.println("   " + file.getAbsolutePath());
				}
			}
		}

	} // end main()

} // end class DirectoryList
