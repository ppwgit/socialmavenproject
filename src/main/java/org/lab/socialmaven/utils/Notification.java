package org.lab.socialmaven.utils;

import org.lab.socialmaven.chat.Chat;
import org.lab.socialmaven.user.User;

import java.util.Date;

public abstract class Notification {
    protected String notificationId;
    protected User recipient;
    protected String message;
    protected NotificationType type;
    protected Chat relatedChat;
    protected Date date;

    public Notification(String notificationId, User recipient, String message, NotificationType type,
                        Chat relatedChat) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.message = message;
        this.type = type;
        this.relatedChat = relatedChat;
        this.date = new Date();
    }

    public String getNotificationId() {
        return notificationId;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    public Chat getRelatedChat() {
        return relatedChat;
    }

    public Date getTimestamp() {
        return date;
    }

    public abstract void sendNotification();
}
