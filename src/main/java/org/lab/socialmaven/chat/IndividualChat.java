package org.lab.socialmaven.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.message.Message;
import org.lab.socialmaven.user.User;

public class IndividualChat extends Chat {
	private static final Logger logger = LogManager.getLogger(IndividualChat.class);
	private User user1;
	private User user2;

	public IndividualChat() {

	}

	public IndividualChat(Integer id, User user1, User user2) {
		super(id);
		this.user1 = user1;
		this.user2 = user2;
		logger.debug("Individual chat");
	}

	public IndividualChat(String personName) {
		super(personName);
	}

	public void sendMessage(Message message) {
		logger.debug("send Message Individual and add message");
		user1.receiveMessage(message);
		user2.receiveMessage(message);
	}

}