package org.lab.socialmaven.exception;

public class LocationNotFoundException extends Exception {
	private String message;

	public LocationNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
