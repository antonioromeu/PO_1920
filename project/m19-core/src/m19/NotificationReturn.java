package m19;

public class NotificationReturn extends Notification {
    
    public NotificationReturn(User user, Work work) {
        super(user, work);
    }

    @Override
    public String toString() {
        return "ENTREGA: ";
    }
}