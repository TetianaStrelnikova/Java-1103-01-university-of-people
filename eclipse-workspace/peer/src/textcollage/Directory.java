package textcollage;
import java.io.File;
import java.util.Scanner;


/**The starting point, the creation of the directory class

 * the file object, array of file will be created.

*/


public class Directory {
	public static void main(String[] args) {


	     String directoryName;  

	     File directory;        

	     String[] files;        

	     Scanner scanner;       

	      scanner = new Scanner(System.in);  

	    System.out.print("Enter a directory name: ");

	     directoryName = scanner.nextLine().trim();

	     directory = new File(directoryName);


	     if (directory.isDirectory() == false) {

	        if (directory.exists() == false)

	           System.out.println("There is no such directory!");

	        else

	           System.out.println("That file is not a directory.");

	     }

	     else {

	        files = directory.list();

	        System.out.println("Files in directory \"" + directory + "\":");

	        for (int i = 0; i < files.length; i++)

	           System.out.println("   " + files[i]);

	     }
}}
