package Grafics2D;

import java.awt.*;
import javax.swing.*;


public class MyFrame extends JFrame{
MyFrame(){
MyPanel panel = new MyPanel();
this.add(panel);	
this.setTitle("Grafics2D");
// set the dethisault close operation this the JFrame to exit the application when
// the user clicks the close button
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// allow the user to resize the JFrame
this.setResizable(true);
// set the initial size of the JFrame to 500x500 pixels
this.setSize(500, 500);
// make the JFrame visible
this.setVisible(true);
// create a new ImageIcon object using the file "logo.png" as the image source
ImageIcon img = new ImageIcon("C:\\Users\\strel\\Java-1103-01-university-of-people\\eclipse-workspace\\Silly-sentance\\src\\JFrame\\i.png");
// set the icon of the JFrame to the image represented by the ImageIcon object
this.setIconImage(img.getImage());
//the window will appears at the center of display
this.setLocationRelativeTo(null);

// size a window (JFrame) so that all its contents are at or above their preferred sizes
this.pack();
}

}
