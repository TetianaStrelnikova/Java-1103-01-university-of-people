package JFrame;

import java.awt.Color;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// create a new JFrame object
		JFrame f = new JFrame();
		// set the title of the JFrame
		f.setTitle("My app");
		// set the default close operation of the JFrame to exit the application when
		// the user clicks the close button
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// allow the user to resize the JFrame
		f.setResizable(true);
		// set the initial size of the JFrame to 500x500 pixels
		f.setSize(500, 500);
		// make the JFrame visible
		f.setVisible(true);
		// create a new ImageIcon object using the file "logo.png" as the image source
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\strel\\\\Java-1103-01-university-of-people\\\\eclipse-workspace\\\\Silly-sentance\\\\src\\\\JFrame\\\\i.png");
		// set the icon of the JFrame to the image represented by the ImageIcon object
		f.setIconImage(img.getImage());
		// set the background color of the content pane to new Color(255,0,127)
		//in RGB or HEX
		// option Color.BLUE
		f.getContentPane().setBackground(new Color(255,0,127));
		
		
	}

}
