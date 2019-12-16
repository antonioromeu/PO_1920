package m19;

import java.io.Serializable;

public abstract class Notification implements Serializable {

    private static final long serialVersionUID = 20199996660L;

    private User _user; 
    private Work _work;

    public Notification(User user, Work work) {
        _user = user;
        _work = work;
    }

    public User getUser() {
        return _user;
    }

    public Work getWork() {
        return _work;
    }

    public abstract String toString();


}