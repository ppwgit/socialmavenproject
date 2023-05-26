package chat;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.SocialNetworkApp;
import message.Message;
import user.User;

//Chat Room
public class Chat {
	private static final Logger logger = LogManager.getLogger(Chat.class);
	private Integer id;
	private String name;
	private List<User> members;
	private List<ChatHistory> chatHistory;;
	private Boolean isGroupChat;

	public Chat() {
	}

	public Chat(Integer id) {
		this.id = id;
		members = new ArrayList<>();
		chatHistory = new ArrayList<>();
	}

	public Chat(String name) {
		this.name = name;
	}

	public Chat(Integer id, String name) {
		this.id = id;
		this.name = name;
		members = new ArrayList<>();
		chatHistory = new ArrayList<>();
	}

	public Chat(String name, List<User> members) {
		this.name = name;
		this.members = members;
	}

	public Chat(List<User> members, List<ChatHistory> chatHistory) {
		this.members = members;
		this.chatHistory = chatHistory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getMembers() {
		return members;
	}

	public void addMember(User user) {
		if (!members.contains(user)) {
			members.add(user);
		}
	}

	public void removeMember(User user) {
		members.remove(user);
	}

	public void sendMessage(Message message) {
		logger.debug(name + " (from " + message.getSender() + "): " + message.getContent());
	}

	public void sendToMember(String memberName, String message) {
		logger.info("sendToMember");
	}

}