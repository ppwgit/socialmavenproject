package message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.SocialNetworkApp;
import user.User;

public class CameraMessage extends Message {
	private static final Logger logger = LogManager.getLogger(CameraMessage.class);
	private boolean isCameraEnabled;
	private String ipAddress;
	private boolean connected;
	private String image;



	public CameraMessage() {
	}
	public CameraMessage(String content, String image) {
		super(content);
		this.image = image;
	}


	public CameraMessage(Integer id, User sender, User receiver, LocalDateTime sentAt, boolean isRead,
			String messageType, String content) {
		super(id, sender, receiver, sentAt, isRead, messageType, content);
		this.isCameraEnabled = isCameraEnabled;
		this.messageType = "CameraMessage";
	}

	public CameraMessage(User sender, User receiver, String content) {
		super(sender, receiver, content);
		this.isCameraEnabled = isCameraEnabled;
		this.messageType = "CameraMessage";
	}

	public CameraMessage(User sender, String content) {
		super(sender, content);
		this.messageType = "CameraMessage";
	}

	public void displayMessage() {
		// logger.debug("Displaying CameraMessage: " + this.content);
	}
	public String getImage() {
		return image;
	}
	public void displayMessageTypeandContent() {
		logger.debug("Displaying CameraMessage: " + this.getContent());
	}

	public String getMessageType() {
		return "CameraMessage";
	}

	public boolean isVideoEnabled() {
		return isCameraEnabled;
	}

	public void setVideoEnabled(boolean isVideoEnabled) {
		this.isCameraEnabled = isVideoEnabled;
	}
}