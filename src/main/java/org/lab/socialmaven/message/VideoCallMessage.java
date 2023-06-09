package org.lab.socialmaven.message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.user.User;

public class VideoCallMessage extends Message {
	private static final Logger logger = LogManager.getLogger(VideoCallMessage.class);
	private boolean isVideoEnabled;

	public VideoCallMessage() {

	}

	public VideoCallMessage(String content) {
		super(content);
	}

	public VideoCallMessage(User sender, User receiver, String content) {
		super(sender, receiver, content);

		this.isVideoEnabled = isVideoEnabled;
		this.messageType = "VideoCallMessage";
	}

	public VideoCallMessage(Integer id, User sender, User receiver, LocalDateTime sentAt, boolean isRead,
			String messageType, String content) {
		super(id, sender, receiver, sentAt, isRead, messageType, content);

		this.isVideoEnabled = isVideoEnabled;
		this.messageType = "VideoCallMessage";
	}

	public boolean isVideoEnabled() {
		return isVideoEnabled;
	}

	public void setVideoEnabled(boolean isVideoEnabled) {
		this.isVideoEnabled = isVideoEnabled;
	}

	public String getMessageType() {
		return "VideoCallMessage";
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Video Call Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("VideoCallMessage Message sent: " + message.getContent());
	}
}
