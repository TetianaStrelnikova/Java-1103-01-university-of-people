package discussion;

class LoginModel {
	String password = "Hi!";
	String username = "Tati";

	public boolean authenticate(String enteredUsername, String enteredPassword) {
		return (enteredUsername.equals(username) && enteredPassword.equals(password));
	}
}
