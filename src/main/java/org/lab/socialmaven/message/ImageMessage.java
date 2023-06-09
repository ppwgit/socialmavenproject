package org.lab.socialmaven.message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.app.SocialNetworkApp;
import org.lab.socialmaven.user.User;

public class ImageMessage extends Message {
	private static final Logger logger = LogManager.getLogger(SocialNetworkApp.class);
	protected String imageUrl;

	public ImageMessage() {

	}

	public ImageMessage(String content) {
		super(content);
	}

	public ImageMessage(User sender, LocalDateTime sentAt, String imageUrl) {
		super(sender, sentAt);
		this.imageUrl = imageUrl;
		this.messageType = "ImageMessage";
	}

	public ImageMessage(Integer id, String content, User sender, User receiver) {
		super(id, content, sender, receiver);
		this.imageUrl = imageUrl;
		this.messageType = "GifMessage";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMessageType() {
		return "ImageMessage";
	}

	public void displayMessage() {
		logger.debug("Image URL: " + imageUrl);
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Image Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("Image Message sent: " + message.getContent());
	}

	public String toString() {
		return "ImageMessage{" + "sender=" + this.getSender() + ", sentAt=" + this.getSentAt() + ", imageUrl='"
				+ imageUrl + '\'' + '}';
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + imageUrl.hashCode();
		return result;
	}

	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		ImageMessage otherMessage = (ImageMessage) obj;
		return this.imageUrl.equals(otherMessage.imageUrl);
	}
}
