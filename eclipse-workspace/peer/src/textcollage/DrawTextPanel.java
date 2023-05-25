package textcollage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/** * The strings are represented by objects of 

* type DrawTextItem, and the panel contains a sizable drawing area where the strings can be drawn. When the user clicks on the drawing area, a string is drawn according to the string entered in an input box underneath the panel. 

** NEW FEATURES: 

* 1. added support for right click to undo (remove item) 

* 2. added support for undo as many levels as allowed 

* 3. each left click places text with random background color, border, font, etc. 

*4. All new features are supported by the save and open command Anonymous Author 

*/ 

/** 

* For evaluation purposes,

*
*/
public class DrawTextPanel extends JPanel {

//As of the right moment, this class can only display one string at once! 
//The DrawTextItem object named theString contains the information for that text; 
//if it is null, nothing is displayed. This variable should be changed to one that can store 
//numerous items and is of type // ArrayListDrawStringItem>.

private ArrayList<DrawTextItem> theStrings;// changed to an ArrayList<DrawTextItem> !

private Color currentTextColor = Color.BLACK;// Adding color to fresh strings.
private Canvas canvas; // the work space.
private JTextField input; // where the user enters the string to add to the canvas
private SimpleFileChooser FileChooser; // for enabling file selection by the user
private JMenuBar menuBar; //command in the menu bar that affects this panel
private MenuHandler menuHandler; // a listener that reacts each time a user chooses a menu option
private JMenuItem undoMenuItem; // the edit menu's "Remove Item" option



/**
* An object of type Canvas is used for the drawing area.
* The canvas simply displays all the DrawTextItems that
* are stored in the ArrayList, strings.
*/

private class Canvas extends JPanel {
 Canvas() {
  setPreferredSize( new Dimension(800,600) );
  setBackground(Color.WHITE);
  setFont( new Font( "Serif", Font.BOLD, 24 ));
 }
 protected void paintComponent(Graphics g) {
  super.paintComponent(g);
 ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING
RenderingHints.VALUE_ANTIALIAS_ON);
if (theStrings != null)
for (DrawTextItem s: theStrings)
s.draw(g);
}
}
/**
* An object of type MenuHandler is registered as the ActionListener
* for all the commands in the menu bar. The MenuHandler object
* simply calls doMenuCommand() when the user selects a command
* from the menu.
*/
private class MenuHandler implements ActionListener {
public void actionPerformed(ActionEvent evt) {
doMenuCommand( evt.getActionCommand());
}
}
/**
* Creates a DrawTextPanel. The panel has a large drawing area and
* a text input box where the user can specify a string. When the
* user clicks the drawing area, the string is added to the drawing
* area at the point where the user clicked.
*/
public DrawTextPanel() {
leChooser = new SimpleFileChooser();
undoMenuItem = new JMenuItem("Remove Item");
undoMenuItem.setEnabled(false);
menuHandler = new MenuHandler();
setLayout(new BorderLayout(3,3));
setBackground(Color.BLACK);
setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
canvas = new Canvas();
add(canvas, BorderLayout.CENTER);
JPanel bottom = new JPanel();
bottom.add(new JLabel("Text to add: "));
input = new JTextField("Hello World!", 40);
bottom.add(input);
add(bottom, BorderLayout.SOUTH);
canvas.addMouseListener( new MouseAdapter() {
public void mousePressed(MouseEvent e) {
doMousePress( e );
}
} );
}
/**
* This method is called when the user clicks the drawing area.
* A new string is added to the drawing area. The center of
* the string is at the point where the user clicked.
* @param e the mouse event that was generated when the user clicked
*/
public void doMousePress( MouseEvent e ) {
if (e.isMetaDown()) { //right click to remove an item
removeItem();
return;
}
String text = input.getText().trim();
if (text.length() == 0) {
input.setText("Hello World!");
text = "Hello World!";
}
DrawTextItem s = new DrawTextItem( text, e.getX(), e.getY() );
s.setTextColor(currentTextColor); // Default is null, meaning default color of the canvas (black).
 // SOME OTHER OPTIONS THAT CAN BE APPLIED TO TEXT ITEMS:
 //
int randomChoice = (int)(Math.random()*5);
int fontStyle;
switch (randomChoice) {
case 0: fontStyle = Font.ITALIC; break;
case 1: fontStyle = Font.BOLD; break;
default: fontStyle = Font.ITALIC + Font.BOLD;
}
s.setFont( new Font( "Serif", fontStyle, (int)(Math.random()*12+8) ));

//create dierent types of magnication
s.setMagnication((int)(Math.random()*4+1));

//create random border
if (Math.random() > 0.3)
s.setBorder(true);

//create random rotation angle (0 to 360)
s.setRotationAngle(Math.random()*360);
}
} );
}
/**
* This method is called when the user clicks the drawing area.
* A new string is added to the drawing area. The center of
* the string is at the point where the user clicked.
* @param e the mouse event that was generated when the user clicked
*/
public void doMousePress( MouseEvent e ) {
if (e.isMetaDown()) { //right click to remove an item
removeItem();
return;
}
String text = input.getText().trim();
if (text.length() == 0) {
input.setText("Hello World!");
text = "Hello World!";
}
DrawTextItem s = new DrawTextItem( text, e.getX(), e.getY() );
s.setTextColor(currentTextColor); // Default is null, meaning default color of the canvas (black).
 // SOME OTHER OPTIONS THAT CAN BE APPLIED TO TEXT ITEMS:
 //
int randomChoice = (int)(Math.random()*5);
int fontStyle;
switch (randomChoice) {
case 0: fontStyle = Font.ITALIC; break;
case 1: fontStyle = Font.BOLD; break;
default: fontStyle = Font.ITALIC + Font.BOLD;
}
s.setFont( new Font( "Serif", fontStyle, (int)(Math.random()*12+8) ));

//create dierent types of magnication
s.setMagnication((int)(Math.random()*4+1));

//create random border
if (Math.random() > 0.3)
s.setBorder(true);

//create random rotation angle (0 to 360)
s.setRotationAngle(Math.random()*360);
Menu editMenu = new JMenu("Edit");
menuBar.add(editMenu);
undoMenuItem.addActionListener(menuHandler); // undoItem was created in the constructor
undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(commandKey + "Z"));
editMenu.add(undoMenuItem);
editMenu.addSeparator();
JMenuItem clearItem = new JMenuItem("Clear");
clearItem.addActionListener(menuHandler);
editMenu.add(clearItem);
JMenu optionsMenu = new JMenu("Options");
menuBar.add(optionsMenu);
JMenuItem colorItem = new JMenuItem("Set Text Color...");
colorItem.setAccelerator(KeyStroke.getKeyStroke(commandKey + "T"));
colorItem.addActionListener(menuHandler);
optionsMenu.add(colorItem);
JMenuItem bgColorItem = new JMenuItem("Set Background Color...");
bgColorItem.addActionListener(menuHandler);
optionsMenu.add(bgColorItem);
}
return menuBar;
}
/**
* Carry out one of the commands from the menu bar.
* @param command the text of the menu command.
*/
private void doMenuCommand(String command) {
if (command.equals("Save...")) { // save all the string info to a le
saveFile();
}
else if (command.equals("Open...")) { // read a previously saved le, and reconstruct the list of strings
openFile();
canvas.repaint(); // (you'll need this to make the new list of strings take eect)
}
else if (command.equals("Clear")) { // remove all strings
theStrings = null; // Remove the ONLY string from the canvas.
undoMenuItem.setEnabled(false);
canvas.repaint();
}
else if (command.equals("Remove Item"))
removeItem();
else if (command.equals("Set Text Color...")) {
Color c = JColorChooser.showDialog(this, "Select Text Color", currentTextColor);
if (c != null)
currentTextColor = c;
}
else if (command.equals("Set Background Color...")) {
Color c = JColorChooser.showDialog(this, "Select Background Color", canvas.getBackground());
if (c != null) {
canvas.setBackground(c);
canvas.repaint();
}
}
else if (command.equals("Save Image...")) { // save a PNG image of the drawing area
File imageFile = leChooser.getOutputFile(this, "Select Image File Name", "textimage.png");
if (imageFile == null)
return;
try {
// Because the image is not available, I will make a new BueredImage and
// draw the same data to the BueredImage as is shown in the panel.
// A BueredImage is an image that is stored in memory, not on the screen.
// There is a convenient method for writing a BueredImage to a le.
BueredImage image = new BueredImage(canvas.getWidth(),canvas.getHeight(),
BueredImage.TYPE_INT_RGB);
Graphics g = image.getGraphics();
g.setFont(canvas.getFont());
canvas.paintComponent(g); // draws the canvas onto the BueredImage, not the screen!
boolean ok = ImageIO.write(image, "PNG", imageFile); // write to the le
if (ok == false)
throw new Exception("PNG format not supported (this shouldn't happen!).");
}
catch (Exception e) {
JOptionPane.showMessageDialog(this,
"Sorry, an error occurred while trying to save the image:\n" + e);
}
}
}
/**
* When Command equal "Remove Item" remove the last item from the canvas one by one. Ctrl-Z and
right click
* are both supported.
*/
private void removeItem() {
if (theStrings.size() > 0)
theStrings.remove(theStrings.size()-1); // remove the most recently added string
if (theStrings.size() == 0)
ndoMenuItem.setEnabled(false);
canvas.repaint();
}
/**
* Save the current canvas into a text le
*/
private void saveFile() {
File saveAs = leChooser.getOutputFile(this, "Save As", "Text Collage.txt");
try {
PrintWriter out = new PrintWriter(saveAs);
out.println("New text collage le");
out.println(canvas.getBackground().getRed());
out.println(canvas.getBackground().getGreen());
out.println(canvas.getBackground().getBlue());
if (theStrings != null)
for (DrawTextItem s: theStrings) {
out.println("theString:");
out.println(s.getString());
out.println(s.getX());
out.println(s.getY());
out.println(s.getFont().getName());
out.println(s.getFont().getStyle());
out.println(s.getFont().getSize());
out.println(s.getTextColor().getRed());
out.println(s.getTextColor().getGreen());
out.println(s.getTextColor().getBlue());
out.println(s.getTextTransparency());
if (s.getBackground() == null) {
out.println("-1");
out.println("-1");
out.println("-1");
}
else {
out.println(s.getBackground().getRed());
out.println(s.getBackground().getGreen());
out.println(s.getBackground().getBlue());
}
out.println(s.getBackgroundTransparency());
out.println(s.getBorder());
out.println(s.getMagnication());
out.println(s.getRotationAngle());
out.close();
} catch (FileNotFoundException e) {
JOptionPane.showMessageDialog(this, "Can't write to the le \"" + saveAs + "\".");
System.out.println("Error message: " + e);
}
}
/**
* Open a saved text le and read the background color as well as the text
* strings.
*/
private void openFile() {
File openFile = leChooser.getInputFile(this, "Open Saved File");
try {
Scanner in = new Scanner(openFile);
if (!in.nextLine().equals("New text collage le")) {
JOptionPane.showMessageDialog(this, "Not a valid le \"" + openFile + "\".");
return;
}
Color savedBg = new Color(in.nextInt(), in.nextInt(), in.nextInt());
ArrayList<DrawTextItem> newStrings = new ArrayList<DrawTextItem>();
DrawTextItem newItem;
in.nextLine(); //skip to the next line before read a new line
while (in.hasNext() && in.nextLine().equals("theString:")) {
newItem = new DrawTextItem(in.nextLine(),
in.nextInt(), in.nextInt());
in.nextLine(); //skip to the next line before read a new line
newItem.setFont(new Font(in.nextLine(), in.nextInt(), in.nextInt()));
newItem.setTextColor(new Color(in.nextInt(), in.nextInt(), in.nextInt()));
newItem.setTextTransparency(in.nextDouble());
int r = in.nextInt();
int g = in.nextInt();
int b = in.nextInt();
if (r == -1)
newItem.setBackground(null);
else
newItem.setBackground(new Color(r, g, b));
newItem.setBackgroundTransparency(in.nextDouble());
newItem.setBorder(in.nextBoolean());
newItem.setMagnication(in.nextDouble());
newItem.setRotationAngle(in.nextDouble());
in.nextLine(); //skip to the next line before read a new line
newStrings.add(newItem);
}
\\if no exceptions occurred, replace the current background and strings canvas.setBackground(savedBg);
theStrings=newStrings;
} catch(FileNotFoundException e) {
J.OptionPane.showMessageDialog(this,"Can't read file \""+openFile +"\".");
System.out.printIn("Error Message:"+e);
}

}
}
