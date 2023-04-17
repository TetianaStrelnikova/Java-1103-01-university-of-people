package Grafics2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
MyPanel(){
	this.setPreferredSize(new Dimension(500,500));
	this.setBackground(Color.lightGray);
}
/**
 * This method paints a blue line with a width of 5 pixels from the point (0,0) to the point (500,500).
 *
 * @param g the Graphics object used for painting
 */
public void paint(Graphics g) {
	// Cast Graphics object to Graphics2D
	Graphics2D g2d = (Graphics2D) g;
	
	// Set the stroke to a width of 5 pixels
	g2d.setStroke(new BasicStroke(2));
	
	// Set the paint (color) to blue
	g2d.setPaint(Color.BLUE);
	
	// Draw a line from point (0,0) to point (500,500)
	g2d.drawLine(0, 0, 500, 500);
	
	//circle
	g2d.setPaint(Color.yellow);
	g2d.fillOval(350,0,100,100);
	// arc
	g2d.setPaint(Color.yellow);
	g2d.drawArc(100, 30, 100, 100,0, 100);
	g2d.drawRect(0, 0, 100,200);
	
	//polygon
	g2d.setPaint(Color.green);
	int[] xpoints = {150,250,350};
	int[] ypoints = {100,150,100};
	g2d.drawPolygon(xpoints,ypoints,3);
	
	//house 
	// Draw the house
    g.setColor(Color.BLUE);
    g.fillRect(150, 200, 200, 200); 
    // Draw the roof
    g.setColor(Color.RED);
    g.fillPolygon(new int[] {150, 250, 350}, new int[] {200, 100, 200}, 3); 
    // Draw the door
    g.setColor(Color.GREEN);
    g.fillRect(225, 300, 50, 100);  
    // Draw the windows
    g.setColor(Color.YELLOW);
    g.fillRect(175, 225, 50, 50);
    g.fillRect(275, 225, 50, 50);
    
    // human
 // Calculate the position of the human
    int x = getWidth() - 150;
    int y = getHeight() - 150;
    
    // Draw the head
    g.setColor(Color.PINK);
    g.fillOval(x + 50, y, 100, 100);
    
    // Draw the body
    g.setColor(Color.PINK);
    g.drawLine(x + 100, y + 100, x + 100, y + 200);
    
    // Draw the arms
    g.setColor(Color.PINK);
    g.drawLine(x, y + 125, x + 100, y + 125);
    g.drawLine(x + 200, y + 125, x + 100, y + 125);
    
    // Draw the legs
    g.setColor(Color.PINK);
    g.drawLine(x + 100, y + 200, x, y + 300);
    g.drawLine(x + 100, y + 200, x + 200, y + 300);
    
}
}
