package chat;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.SocialNetworkApp;
import user.User;

public class GroupChat extends Chat {
	private static final Logger logger = LogManager.getLogger(GroupChat.class);

	private Integer id;
	private String groupName;
	private List<User> members;

	public GroupChat() {
	}

	public GroupChat(Integer id) {
		super(id);
	}

	public GroupChat(Integer id, List<User> members) {
		super(id);
		logger.debug("Group chat add all member");
	}

	public GroupChat(String groupName, List<User> members) {
		super(groupName, members);
		members = new ArrayList<User>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupName() {
		return id;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addMember(User memberName) {
		members.add(memberName);
	}

	public void sendToMember(String memberName, String message) {
		if (members.contains(memberName)) {
			logger.debug(getName() + " (to " + memberName + "): " + message);
		} else {
			logger.debug(memberName + " is not a member of " + getName() + ".");
		}
	}
}
