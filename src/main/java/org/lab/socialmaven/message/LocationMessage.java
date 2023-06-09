package org.lab.socialmaven.message;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.lab.socialmaven.messageinterface.ILocationMessage;
import org.lab.socialmaven.user.User;

public class LocationMessage extends Message implements ILocationMessage {
	private static final Logger logger = LogManager.getLogger(LocationMessage.class);

	private String location;
	private String locationURL;

	public LocationMessage() {

	}

	public LocationMessage(Integer id, User sender, User receiver, LocalDateTime sentAt, boolean isRead,
			String messageType, String content) {
		super(id, sender, receiver, sentAt, isRead, messageType, content);
		this.location = location;
		this.locationURL = locationURL;
		this.messageType = "ShareLocationMessage";
	}

	public String getMessageType() {
		return "ShareLocationMessage";
	}

	public void displayMessageTypeandContent() {
		logger.debug("Displaying Location Message: " + this.getContent());
	}

	public static void sendMessageObj(Message message) {
		logger.debug("Message sent: " + message.getContent());
	}

	public LocationMessage(String content) {
		super(content);
	}

	public void setLocation(double latitude, double longitude) throws Exception {
		// String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" +
		// latitude + "," + longitude + "&key=YOUR_API_KEY";
		/*
		 * URL obj = new URL(url); HttpURLConnection con = (HttpURLConnection)
		 * obj.openConnection(); con.setRequestMethod("GET");
		 * con.setRequestProperty("User-Agent",
		 * "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36"
		 * ); int responseCode = con.getResponseCode(); if (responseCode ==
		 * HttpURLConnection.HTTP_OK) { Scanner sc = new Scanner(con.getInputStream());
		 * StringBuilder response = new StringBuilder(); while (sc.hasNextLine()) {
		 * response.append(sc.nextLine()); } sc.close(); location = response.toString();
		 * setContent("Location: " + location); } else { throw new
		 * LocationNotFoundException("Location not found from LocationMessage class");
		 * 
		 * }
		 */
	}

	public String getLocation() {
		return location;
	}

	public String getLocationURL() {
		return location;
	}
}
