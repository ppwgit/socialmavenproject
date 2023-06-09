package org.lab.socialmaven.messageinterface;

import org.lab.socialmaven.message.Message;

public interface IMessenger {
	public void sendMessage(Message message);
	public void readMessage(Message message);

}
