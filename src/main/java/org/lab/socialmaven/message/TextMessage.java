package org.lab.socialmaven.message;

import java.time.LocalDateTime;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.messageinterface.ITextMessage;
import org.lab.socialmaven.user.User;

public class TextMessage extends Message implements ITextMessage {
	private static final Logger logger = LogManager.getLogger(TextMessage.class);
	private String text;
	private Set<Message> txtmessageSet;
	private List<Message> txtmessageList;
	private LinkedList<Message> txtmessageLinkedList;
	private Map<String, Message> txtmessageMap;
	private Queue<Message> txtmessageQueue;
	private Deque<Message> txtmessageDeque;

	public TextMessage() {

	}

	public TextMessage(String content) {
		super(content);
		this.txtmessageSet = new HashSet<>();
		this.txtmessageList = new ArrayList<>();
		this.txtmessageLinkedList = new LinkedList<Message>();
		txtmessageMap = new HashMap<>();
		txtmessageQueue = new LinkedList<Message>();
		txtmessageDeque = new LinkedList<Message>();

	}

	public TextMessage(User sender, LocalDateTime sentAt) {
		super(sender, sentAt);
		this.text = text;
		this.messageType = "TextMessage";
		this.txtmessageSet = new HashSet<>();
		this.txtmessageList = new ArrayList<>();
		txtmessageLinkedList = new LinkedList<Message>();
		txtmessageMap = new HashMap<>();
		txtmessageQueue = new LinkedList<Message>();
		txtmessageDeque = new LinkedList<Message>();
	}

	public TextMessage(User sender, String content) {
		super(sender, content);
		this.text = text;
		this.messageType = "TextMessage";
		this.txtmessageSet = new HashSet<>();
		this.txtmessageList = new ArrayList<>();
		txtmessageLinkedList = new LinkedList<Message>();
		txtmessageMap = new HashMap<>();
		txtmessageQueue = new LinkedList<Message>();
		txtmessageDeque = new LinkedList<Message>();
	}

	public TextMessage(User sender, String content, String text) {
		super(sender, content);
		this.text = text;
		this.messageType = "TextMessage";
		this.txtmessageSet = new HashSet<>();
		this.txtmessageList = new ArrayList<>();
		txtmessageLinkedList = new LinkedList<Message>();
		txtmessageMap = new HashMap<>();
		txtmessageQueue = new LinkedList<Message>();
		txtmessageDeque = new LinkedList<Message>();
	}

	public TextMessage(Integer id, String content, User sender, User receiver) {
		super(id, content, sender, receiver);
		this.text = text;
		this.messageType = "TextMessage";
		this.txtmessageSet = new HashSet<>();
		this.txtmessageList = new ArrayList<>();
		txtmessageLinkedList = new LinkedList<Message>();
		txtmessageMap = new HashMap<>();
		txtmessageQueue = new LinkedList<Message>();
		txtmessageDeque = new LinkedList<Message>();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMessageType() {
		return "TextMessage";
	}

	public void displayMessage() {
		logger.debug(text);
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Text Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("TextMessage Message sent: " + message.getContent());
	}

	public String toString() {
		return "TextMessage{" + "sender=" + this.getSender() + ", sentAt=" + this.getSentAt() + ", text='" + text + '\''
				+ '}';
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + text.hashCode();
		return result;
	}

	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		TextMessage otherMessage = (TextMessage) obj;
		return this.text.equals(otherMessage.text);
	}

	public void addMessageToSet(Message message) {
		this.txtmessageSet.add(message);
	}

	public Set<Message> getMessageSet() {
		return txtmessageSet;
	}

	public List<Message> getMessageList() {
		return txtmessageList;
	}

	public void addMessageList(Message message) {
		txtmessageList.add(message);
	}

	public void addMessageLinkedList(Message message) {
		txtmessageLinkedList.add(message);
	}

	public LinkedList<Message> getMessageLinkedList() {
		return txtmessageLinkedList;
	}

	public void addMessage(String key, Message message) {
		txtmessageMap.put(key, message);
	}

	public Message getMessage(String key) {
		return txtmessageMap.get(key);
	}

	public void addMessageToQueue(Message message) {
		txtmessageQueue.add(message);
	}

	public void removeMessageFromQueue() {
		txtmessageQueue.remove();
	}

	public void addMessageLinkedLast(Message message) {
		txtmessageLinkedList.addLast(message);
	}

	public void addMessageLinkedInMiddle(int index, Message message) {
		if (index >= txtmessageLinkedList.size()) {
			txtmessageLinkedList.addLast(message);
		} else {
			txtmessageLinkedList.add(index, message);
		}
	}

}
