package chat;

import java.util.ArrayList;
import java.util.List;

import message.Message;

public class ChatHistory {
	private Integer id;
	private List<Message> messages;

	public ChatHistory() {

	}

	public ChatHistory(Integer id) {
		this.messages = new ArrayList<>();
	}

	public ChatHistory(List<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
	}

	public List<Message> getMessages() {
		return new ArrayList<>(messages);
	}
}
