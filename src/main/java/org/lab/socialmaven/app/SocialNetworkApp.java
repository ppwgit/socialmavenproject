package org.lab.socialmaven.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.chat.Chat;
import org.lab.socialmaven.message.Message;
import org.lab.socialmaven.user.User;

public class SocialNetworkApp {
	private static final Logger logger = LogManager.getLogger(SocialNetworkApp.class);
	private String url;
	private List<User> users;
	private List<Chat> chats;
	private List<Message> messages;

	public SocialNetworkApp(String url) {
		this.url = url;
		this.users = new ArrayList<>();
		this.chats = new ArrayList<>();
		this.messages = new ArrayList<>();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	// list User
	/*
	 * public void addUser(User user) { users.add(user); }
	 */

	public void addUser(User user) {
		users.add(user);
	}

	public void createChat(Chat chat) {
		chats.add(chat);
	}

	public void sendMessage(Message message) {
		messages.add(message);
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public int getTotalUsers() {
		return users.size();
	}

	public int getTotalChats() {
		return chats.size();
	}

	public int getTotalMessages() {
		return messages.size();
	}

}
