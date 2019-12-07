package m19;

public class NotificationReturn extends Notification {

    private static final long serialVersionUID = 20199896660L;
    
    public NotificationReturn(User user, Work work) {
        super(user, work);
    }

    @Override
    public String toString() {
        return "ENTREGA: ";
    }
}