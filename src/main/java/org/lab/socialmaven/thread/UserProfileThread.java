package org.lab.socialmaven.thread;

import org.lab.socialmaven.user.User;

public class UserProfileThread extends Thread {
    private User userProfileThread;

    public UserProfileThread(User userProfileThread) {
        this.userProfileThread = userProfileThread;
    }

    public void run() {
        userProfileThread.displayUserProfile();
    }
}
