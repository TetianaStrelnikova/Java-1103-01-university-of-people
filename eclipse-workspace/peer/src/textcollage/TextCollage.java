package textcollage;
//THE CREATION OF THE PACKAGE 

//THE FOUR FILE ARE IN THE SAME PACKAGE.  

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class TextCollage {
	/** contain te main routine for all other classes. */

	public static void main(String[] args) {

		JFrame frame = new JFrame("Text Collage");

		DrawTextPanel panel = new DrawTextPanel();

		frame.setContentPane(panel);

		frame.setJMenuBar(panel.getMenuBar());

		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		frame.setLocation((screenSize.width - frame.getWidth()) / 2,

				(screenSize.height - frame.getHeight()) / 2);

		frame.setVisible(true);

	}
}
