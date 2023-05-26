package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ChatNotificationType {

    MESSAGE("New Message", true),
    TYPING("Typing Indicator", false),
    DELIVERY("Delivery Receipt", true),
    READ("Read Receipt", true),
    MENTION("Group Chat Mention", true),
    ONLINE("Online Status", false);

    private static final Logger logger = LogManager.getLogger(ChatNotificationType.class);
    private final String displayName;
    private final boolean requiresAction;

    ChatNotificationType(String displayName, boolean requiresAction) {
        this.displayName = displayName;
        this.requiresAction = requiresAction;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean requiresAction() {
        return requiresAction;
    }

    public void displayNotification() {
        logger.info("Displaying notification: " + displayName);
        if (requiresAction) {
            logger.info("This notification requires action.");
        } else {
            logger.info("This notification does not require action.");
        }
    }
}
