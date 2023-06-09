package org.lab.socialmaven.message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.messageinterface.IGifMessage;
import org.lab.socialmaven.user.User;

public class GifMessage extends Message implements IGifMessage {
	private static final Logger logger = LogManager.getLogger(GifMessage.class);

	private String gifFilePath;

	public GifMessage() {

	}

	public GifMessage(String content) {
		super(content);
	}
	public GifMessage(String content, String gifFilePath) {
		super(content);
		this.gifFilePath = gifFilePath;
	}
	public GifMessage(Integer id, String content, User sender, User receiver, String gifFilePath) {
		super(id, content, sender, receiver);
		this.gifFilePath = gifFilePath;
		this.messageType = "GifMessage";
	}

	public GifMessage(User sender, String content) {
		super(sender, content);
		this.messageType = "GifMessage";
	}

	public String getGifFilePath() {
		return gifFilePath;
	}

	public void setGifFilePath(String gifFilePath) {
		this.gifFilePath = gifFilePath;
	}

	public void playGif() {
		logger.debug("Play GIF");
	}

	public void stopGif() {
		logger.debug("Stop playing GIF");
	}

	public void printMessage() {
		logger.debug(": (GIF message) (" + LocalDateTime.now() + ")");
	}

	public String getMessageType() {
		return "GifMessage";
	}

	public void displayMessage() {
		logger.debug("Gif File Path: " + gifFilePath);
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Gif Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("Gif Message sent: " + message.getContent());
	}

	public String toString() {
		return "GifMessage{" + "sender='" + getSender() + '\'' + ", recipient='" + getReceiver() + '\''
				+ ", gifFilePath='" + gifFilePath + '\'' + '}';
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 20 * result + gifFilePath.hashCode();
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		GifMessage otherMessage = (GifMessage) obj;
		return this.gifFilePath.equals(otherMessage.gifFilePath);

	}

	public void sendMessage() {
		// Code to send the GIF message
		logger.debug("Sending GIF message: " + toString());
		// Set wasSentSuccessfully flag to true
		setWasSentSuccessfully(true);
	}

	public String getGifUrl() {
		return gifFilePath;
	}

	public void setGifUrl(String gifFilePath) {
		this.gifFilePath = gifFilePath;

	}
}