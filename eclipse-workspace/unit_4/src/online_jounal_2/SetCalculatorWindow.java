package online_jounal_2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetCalculatorWindow extends JFrame implements ActionListener {
	private JTextField textField;
	private JButton button;

	public SetCalculatorWindow() {
		// set up the window
		setTitle("Calculator");
		setSize(400, 100);
		setLocationRelativeTo(null); // center the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create the text field and button
		textField = new JTextField(30);
		button = new JButton("Calculate");
		button.addActionListener(this);

		// add the text field and button to a panel
		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(button);

		// add the panel to the window
		add(panel, BorderLayout.CENTER);

		// show the window
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String input = textField.getText();

		if (input.isEmpty()) {
			JOptionPane.showMessageDialog(this, "You did not enter the expression to calculate!");
		} else {
			// Split the input line into the two sets and the operator
			String[] part = input.split("\\s*([+*/-])\\s*");

			// Check that the input is valid
			if (part.length != 3) {
				JOptionPane.showMessageDialog(this, "Invalid expression : Example [1,3,4] * [1,3,5])");
				dispose(); // close the window if the input is blank
			} else {

				JOptionPane.showMessageDialog(this, input + " = ");
			}
		}

		textField.setText(""); // clear the text field

		if (input.isEmpty()) {
			dispose(); // close the window if the input is blank
		}
	}

	public static void main(String[] args) {
		new SetCalculatorWindow();
	}
}
