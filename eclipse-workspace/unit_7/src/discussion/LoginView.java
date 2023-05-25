package discussion;
import javax.swing.*;
import java.awt.*;
public class LoginView extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	public LoginView() {
		setTitle("Login Form");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		JLabel usernameLabel = new JLabel("Username:");
		usernameField = new JTextField();
		JLabel passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();
		loginButton = new JButton("Login");
		setLocationRelativeTo(null);
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(new JLabel()); // Empty label for spacing
		panel.add(loginButton);
		add(panel);
		setVisible(true);}
	public JButton getLoginButton() {return loginButton;}
	public String getUsername() {return usernameField.getText();}
	public String getPassword() {return new String(passwordField.getPassword());}
}