package message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.SocialNetworkApp;
import user.User;

public class VoiceCallMessage extends Message {
	private static final Logger logger = LogManager.getLogger(VoiceCallMessage.class);
	private boolean isSpeakerEnabled;

	public VoiceCallMessage() {

	}

	public VoiceCallMessage(String content) {
		super(content);
	}

	public VoiceCallMessage(Integer id, User sender, User receiver, LocalDateTime sentAt, boolean isRead,
			String messageType, String content) {
		super(id, sender, receiver, sentAt, isRead, messageType, content);
		this.isSpeakerEnabled = isSpeakerEnabled;
		this.messageType = "VoiceCallMessage";
	}

	public boolean isSpeakerEnabled() {
		return isSpeakerEnabled;
	}

	public void setSpeakerEnabled(boolean isSpeakerEnabled) {
		this.isSpeakerEnabled = isSpeakerEnabled;
	}

	public String getMessageType() {
		return "VoiceCallMessage";
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Voice Call Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("VocieCall Message sent: " + message.getContent());
	}

}