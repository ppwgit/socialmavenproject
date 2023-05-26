package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum NotificationEnum {

    MESSAGE_RECEIVED("Message Received") {
        @Override
        public void showNotification(String sender, String message) {
            logger.info("New message from " + sender + ": " + message);
        }
    },
    FRIEND_REQUEST("Friend Request") {
        @Override
        public void showNotification(String sender, String message) {
            logger.info("Friend request from " + sender + ": " + message);
        }
    },
    GROUP_INVITATION("Group Invitation") {
        @Override
        public void showNotification(String sender, String message) {
            logger.info("You've been invited by " + sender + " to join a group: " + message);
        }
    };

    private static final Logger logger = LogManager.getLogger(NotificationEnum.class);
    private final String displayName;

    NotificationEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public abstract void showNotification(String sender, String message);
}
