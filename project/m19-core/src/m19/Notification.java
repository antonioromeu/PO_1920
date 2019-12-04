package m19;

public abstract class Notification {

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