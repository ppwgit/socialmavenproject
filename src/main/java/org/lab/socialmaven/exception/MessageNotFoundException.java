package org.lab.socialmaven.exception;

public class MessageNotFoundException extends Exception {
	private String message;

	public MessageNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
