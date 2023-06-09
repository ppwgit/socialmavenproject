package org.lab.socialmaven.exception;

public class CameraFailedtoConnectException extends Exception {
	private String message;

	public CameraFailedtoConnectException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}