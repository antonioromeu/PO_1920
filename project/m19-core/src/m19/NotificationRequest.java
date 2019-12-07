package m19;

public class NotificationRequest extends Notification {

    private static final long serialVersionUID = 20199996670L;
    
    public NotificationRequest(User user, Work work) {
        super(user, work);
    }

    @Override
    public String toString() {
        return "REQUISIÇÃO: ";
    }
}