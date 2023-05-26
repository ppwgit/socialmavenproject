package message;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import user.User;

public class Message {
	private static final Logger logger = LogManager.getLogger(Message.class);
	private Integer id;
	private User sender;
	private User receiver;
	private LocalDateTime sentAt; // ? use java.util date ?
	private Boolean isRead;
	private String content;
	protected String messageType;
	private boolean wasSentSuccessfully;
	private Set<Message> messageSet;
	private List<Message> messageList;
	private LinkedList<Message> messageLinkedList;
	private Map<String, Message> messageMap;
	private Queue<Message> messageQueue;
	private Deque<Message> messageDeque;

	public Message() {
	}

	public Message(String content) {
		this.content = content;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Message(User sender, String content) {
		this.sender = sender;
		this.content = content;
		this.sentAt = LocalDateTime.now();
		this.isRead = false;
		this.messageType = messageType;
		this.wasSentSuccessfully = false;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Message(User sender, LocalDateTime sentAt) {
		this.sender = sender;
		this.sentAt = sentAt;
		this.content = content;
		this.messageType = messageType;
		this.wasSentSuccessfully = false;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Message(User sender, LocalDateTime sentAt, String content) {
		this.sender = sender;
		this.sentAt = sentAt;
		this.content = content;
		this.messageType = messageType;
		this.wasSentSuccessfully = false;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Message(Integer id, User sender, User receiver, LocalDateTime sentAt, Boolean isRead, String messageType,
			String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.sentAt = LocalDateTime.now();
		this.isRead = false;
		this.content = content;
		this.messageType = messageType;
		this.wasSentSuccessfully = false;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Message(Integer id, String content, User sender, User receiver) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.sentAt = LocalDateTime.now();
		this.isRead = false;
		this.messageType = messageType;
		this.wasSentSuccessfully = false;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Message(User sender, User receiver, String content) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.sentAt = LocalDateTime.now();
		this.isRead = false;
		this.messageType = messageType;
		this.wasSentSuccessfully = false;
		this.messageSet = new HashSet<>();
		this.messageList = new ArrayList<>();
		this.messageLinkedList = new LinkedList<>();
		this.messageMap = new HashMap<>();
		this.messageQueue = new LinkedList<>();
		this.messageDeque = new LinkedList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public void markAsRead() {
		this.isRead = true;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public boolean wasSentSuccessfully() {
		return wasSentSuccessfully;
	}

	public void setWasSentSuccessfully(boolean wasSentSuccessfully) {
		this.wasSentSuccessfully = wasSentSuccessfully;
	}

	public void sendMessage() {
		// Code to send the message
		logger.debug("Sending message: " + toString());
		// Set wasSentSuccessfully flag to true
		setWasSentSuccessfully(true);
	}

	// use this one to send msg with subclass obj
	public static void sendMessageObj(Message message) {
		logger.debug("Message sent: " + message.getContent());
	}

	public void displayMessage() {
		logger.debug(this.sender + ": " + this.content + " (" + this.sentAt.toString() + ")");
	}

	/*
	 * public abstract void displayMessageTypeandContent();
	 * 
	 * public String toString() { return "Message{" + "sender=" + sender +
	 * ", sentAt=" + sentAt + '}'; }
	 */

	public String toString() {
		return "Message{" + "sender='" + sender + '\'' + ", recipient='" + receiver + '\'' + ", senttime='" + sentAt
				+ '\'' + ", wasSentSuccessfully=" + wasSentSuccessfully + '}';
	}

	public int hashCode() {
		int result = 17;
		result = 31 * result + sender.hashCode();
		result = 31 * result + sentAt.hashCode();
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Message))
			return false;
		Message otherMessage = (Message) obj;
		return this.sender.equals(otherMessage.sender) && this.sentAt.equals(otherMessage.sentAt);
	}

	// Set
	public Set<Message> getMessageSet() {
		return messageSet;
	}

	public void addMessageSet(Message message) {
		messageSet.add(message);
	}

	public boolean removeMessageSet(Message message) {
		return messageSet.remove(message);
	}

	public String toStringSet() {
		return sender + " to " + receiver + ": " + content + " [messageSet=" + messageSet + "]";
	}

	// List
	public List<Message> getMessageList() {
		return messageList;
	}

	public void addMessageList(Message message) {
		messageList.add(message);
	}

	public boolean removeMessageList(Message message) {
		return messageList.remove(message);
	}

	public String toStringList() {
		return sender + " to " + receiver + ": " + content + " [messageList=" + messageList + "]";
	}

	// LinkedList

	public LinkedList<Message> getMessageLinkedList() {
		return messageLinkedList;
	}

	public void addMessageLinkedList(Message message) {
		messageLinkedList.add(message);
	}

	public boolean removeMessageLinkedList(Message message) {
		return messageLinkedList.remove(message);
	}

	public String toStringLinkedList() {
		return sender + " to " + receiver + ": " + content + " [messageLinkedList=" + messageLinkedList + "]";
	}

	// Map
	public Map<String, Message> getMessageMap() {
		return messageMap;
	}

	public void addMessageMap(String key, Message message) {
		messageMap.put(key, message);
	}

	public boolean removeMessageMap(String key) {
		return messageMap.remove(key) != null;
	}

	public String toStringMap() {
		return sender + " to " + receiver + ": " + content + " [messageMap=" + messageMap + "]";
	}

	// Queue

	public Queue<Message> getMessageQueue() {
		return messageQueue;
	}

	public void addMessageQueue(Message message) {
		messageQueue.add(message);
	}

	public Message removeMessageQueue() {
		return messageQueue.poll();
	}

	public String toStringQueue() {
		return sender + " to " + receiver + ": " + content + " [messageQueue=" + messageQueue + "]";
	}

	public Deque<Message> getMessageDeque() {
		return messageDeque;
	}

	public void addMessageDeque(Message message) {
		messageDeque.add(message);
	}

	public Message removeFirstMessageDeque() {
		return messageDeque.pollFirst();
	}

	public Message removeLastMessageDeque() {
		return messageDeque.pollLast();
	}

	public String toStringDeque() {
		return sender + " to " + receiver + ": " + content + " [messageDeque=" + messageDeque + "]";
	}
}
