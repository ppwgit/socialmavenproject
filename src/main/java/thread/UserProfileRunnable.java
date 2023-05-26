package thread;

import user.User;

public class UserProfileRunnable implements Runnable {

    private User userProfileRunable;

    public UserProfileRunnable(User userProfile) {
        this.userProfileRunable = userProfileRunable;
    }

    public void run() {
        userProfileRunable.displayUserProfile();
    }

}
