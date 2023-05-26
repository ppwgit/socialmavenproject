package exception;

public class MessageSendingFailedException extends Exception {
	private String message;

	public MessageSendingFailedException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
