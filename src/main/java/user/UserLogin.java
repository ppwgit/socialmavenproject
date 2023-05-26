package user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.SocialNetworkApp;

// pass authen from fb account ?
public class UserLogin {
	private static final Logger logger = LogManager.getLogger(SocialNetworkApp.class);
	private String email;
	private String password;
	private boolean loggedIn;

	public UserLogin(String email, String password) {
		this.email = email;
		this.password = password;
		this.loggedIn = false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean authenticate(String email, String password) {
		if (this.email.equals(email) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public void login() {
		// if (authenticate("taexxxxxx", email)) {
		if (authenticate("tae@gmail.com", "mypassword")) {
			this.loggedIn = true;
			logger.debug("Login successful!");
		} else {
			logger.debug("Invalid username or password.");
		}
	}

	public void logout() {
		this.loggedIn = false;
		logger.debug("Logged out.");
	}

}
