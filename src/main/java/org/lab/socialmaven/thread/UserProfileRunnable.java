package org.lab.socialmaven.thread;

import org.lab.socialmaven.user.User;

public class UserProfileRunnable implements Runnable {

    private User userProfileRunable;

    public UserProfileRunnable(User userProfile) {
        this.userProfileRunable = userProfileRunable;
    }

    public void run() {
        userProfileRunable.displayUserProfile();
    }

}
