package message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.SocialNetworkApp;
import user.User;

public class VoiceRecordMessage extends Message {
	private static final Logger logger = LogManager.getLogger(VoiceRecordMessage.class);
	private String audioData;
	private int duration;
	private String audioFile;

	public VoiceRecordMessage() {

	}

	public VoiceRecordMessage(String content) {
		super(content);
	}

	public VoiceRecordMessage(Integer id, User sender, User receiver, LocalDateTime sentAt, boolean isRead,
			String messageType, String content) {
		super(id, sender, receiver, sentAt, isRead, messageType, content);
		this.audioData = audioData;
		this.duration = duration;
		this.messageType = "VoiceRecordMessage";
	}

	public String getAudioData() {
		return audioData;
	}

	public void setAudioData(String audioData) {
		this.audioData = audioData;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAudioFile() {
		return audioFile;
	}

	public void setAudioFile(String audioFile) {
		this.audioFile = audioFile;
	}

	public String getMessageType() {
		return "VoiceRecordMessage";
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Voice Record Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("Voice Record Message sent: " + message.getContent());
	}

}
