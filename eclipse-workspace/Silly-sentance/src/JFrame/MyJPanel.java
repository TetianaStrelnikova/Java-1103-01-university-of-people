package JFrame;
import java.awt.Color;
import javax.swing.*;


public class MyJPanel {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();

		f.setTitle("My app");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setSize(500, 500);
		f.setVisible(true);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\strel\\\\Java-1103-01-university-of-people\\\\eclipse-workspace\\\\Silly-sentance\\\\src\\\\JFrame\\\\i.png");
		f.setIconImage(img.getImage());
		f.getContentPane().setBackground(new Color(55, 0, 27));
		f.setLayout(null);
		//the window will appears at the center of display
		f.setLocationRelativeTo(null);
		
		
		JPanel whitePanel = new JPanel();
		whitePanel.setBackground(Color.WHITE);
		whitePanel.setBounds(0,0,250,250);
		
		
		f.add(whitePanel);
		
		JPanel orangePanel = new JPanel();
		orangePanel.setBackground(Color.ORANGE);
		orangePanel.setBounds(0,250,50,50);
		f.add(orangePanel);

	}
}
