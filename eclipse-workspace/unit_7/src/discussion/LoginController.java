package discussion;

import javax.swing.JOptionPane;

class LoginController {
	LoginModel user;
	LoginView view;

	public LoginController(LoginModel user, LoginView view) {
		super();
		this.user = user;
		this.view = view;
	}

	public void authenticate() {
		String enteredUsername = view.getUsername();
		String enteredPassword = view.getPassword();
		boolean authenticated = user.authenticate(enteredUsername, enteredPassword);
		if (authenticated) {
			JOptionPane.showMessageDialog(null, "Login successful.");
		} else {
			JOptionPane.showMessageDialog(null, "Login is not successful.");
		}
	}
}