package JFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ChildOfJFrame extends JFrame {
	ChildOfJFrame() {
		// set the title of the JFrame
		this.setTitle("My crying app");
		// set the dethisault close operation othis the JFrame to exit the application when
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
		// set the background color of the content pane to new Color(255,0,127)
		// in RGB or HEX
		// option Color.BLUE
		this.getContentPane().setBackground(new Color(255, 0, 127));
		//the window will appears at the center of display
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
			
		
	//LABELS 
		// creates a new JLabel object and sets its text to "I Hate JAVA".
		JLabel label = new JLabel();
		label.setText("I Hate JAVA");
		// This code creates a new ImageIcon object from the file path provided and sets it as the icon of the label.
		ImageIcon i = new ImageIcon("C:\\Users\\strel\\Java-1103-01-university-of-people\\eclipse-workspace\\Silly-sentance\\src\\JFrame\\i.png");
		label.setIcon(i);
		// This code sets the horizontal text position of the label to center and the vertical text position to top.
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		// This code sets the foreground color of the label to green and the font to "MV Boli" with a size of 30.
		label.setForeground(new Color(0x00FF00));
		label.setFont(new Font("MV Boli", Font.PLAIN,30));
		// This code sets the icon text gap of the label to -150 and sets the background color to black.
		label.setIconTextGap(-150);
		// This code sets the opaque property of the label to true, which means that the label will paint every pixel within its bounds.
		//label.setBackground(Color.BLACK);
		//label.setOpaque(true);
		// create a border
		Border b = BorderFactory.createLineBorder(Color.DARK_GRAY);
		label.setBorder(b);
		//position of label+text
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		// sets x,y,position within frame and dimensions
		// Don't forget to child.setLayout(null)
		// will stay in the one place even if the window will resized
		//label.setBounds(100,100,250,250);
		
		
		
	//new ChildOfJFrame();
			ChildOfJFrame child = new ChildOfJFrame();
			child.add(label);
			//child.setLayout(null);
			
			//code  will accommodate frame to the label or other components size
			// you don't need a size for a frame
			// add components before pack() !!!!
			child.pack();
}}
