import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;

public class Game {
	private Board layout;
	// creating the vars for tiles in the game and its prospereties width and height
	public static final int WIDTH = 28;
	public static final int HEIGTH = 28;
	// x and y are the number of tiles in the line horizontal(x) and vertical(y)
	public static final int X = 30;
	public static final int Y = 16;
	// The "protected" keyword means that the variable is accessible within the
	// class where it is declared,
	// as well as any subclasses of that class.
	// creating a JFrame instance variable that can be used to hold the game's
	// graphical user interface (GUI)
	// a top-level container used in Java Swing applications to create windows or
	// frames that can hold user interface components
	// such as buttons, labels, and text fields
	protected JFrame window;
	// game attributers
	public static final int BOMB_COUNT = 50;
	private int score_board_width = 100;
	private boolean end = false;
	private boolean win = false;
	private int flags;
	public Game() {
		window = new JFrame();
		window.setTitle("Tati Minesweeper");
		//the size of the window depends of the sizes and amount of tiles (cells) in the game
		window.setSize(X*WIDTH, Y*HEIGTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new Board();
		flags = BOMB_COUNT;
		window.setVisible(true);
	}
	/**
	 * Resizes a BufferedImage object to a specified width and height.
	 *
	 * @param originalImage the original BufferedImage object to resize
	 * @param width the desired width of the resized image
	 * @param height the desired height of the resized image
	 * @return a new BufferedImage object with the resized image
	 * @throws IOException if there is a problem reading or writing the image data
	 *
	 * Example usage:
	 * BufferedImage originalImage = ImageIO.read(new File("original.png"));
	 * BufferedImage resizedImage = resizeImage(originalImage, 200, 200);
	 * ImageIO.write(resizedImage, "png", new File("resized.png"));
	 */
	//IOException is a checked exception in Java that is thrown when an input or output operation fails or is interrupted. It is a common exception that can be thrown when working with files, 
	//network connections, or other I/O operations.
	public static BufferedImage resizeImage(BufferedImage originalImage,int width, int height)throws IOException{
		// Scale the original image to the desired size 
		//using the getScaledInstance method of the Image class
		//It can be used to resize an image to a specified width and height.
		Image resultingImage = originalImage.getScaledInstance(width,height, Image.SCALE_DEFAULT);
		// Create a new BufferedImage object with the desired width and height
		BufferedImage outputImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
		// Draw the scaled image onto the new BufferedImage object 
		//using the drawImage method of the Graphics class
		//method is called on the outputImage object to obtain a Graphics2D object
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		return outputImage;
		
	}
}
