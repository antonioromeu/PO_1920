package m19;

public class NotificationRequest extends Notification {
    
    public NotificationRequest(User user, Work work) {
        super(user, work);
    }

    @Override
    public String toString() {
        return "REQUISIÇÃO: ";
    }
}