package messageinterface;

import message.Message;

public interface IMessenger {
	public void sendMessage(Message message);
	public void readMessage(Message message);

}
