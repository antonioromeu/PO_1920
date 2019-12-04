package m19;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
  * Class that represents the concept of user.
  */

public class User implements Serializable, Comparable<User> {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201608231530L;

     /** ID. */
    private int _id;

     /** Name. */
    private String _name;

     /** Email. */
    private String _email;

     /** Active. */
    private boolean _active;

     /** Fine. */
    private int _fine = 0;

     /** Behaviour. */
    private Behaviour _behaviour = new NormalBehaved(this);

     /** Number of works in possession of user. */
    private int _numberWorks = 0;

    private List<Notification> _notificationList = new ArrayList<Notification>();

    public User(int usersCounter, String name, String email) {
        _id = usersCounter;
        _name = name;
        _email = email;
        _active = true;
    }

    public int compareTo(User user) {
        if (!this.getName().equals(user.getName())) 
            return (this.getName().compareTo(user.getName()));
        else if (this.getID() < user.getID()) return -1;
        else return 1;
    }

    public int getID() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActiveness(boolean b) {
        _active = b;
    }

    public String toStringActive() {
        if (_active) {
            return "ACTIVO";
        }
        else return "SUSPENSO";
    }

    public int getFine() {
        return _fine;
    }

    public void incrementFine(int n_days) {
        _fine += (n_days * 5);
    }

    public Behaviour getBehaviour() {
        return _behaviour;
    }

    protected void setBehaviour(Behaviour b) {
        _behaviour = b;
    }

    public int getNumberWorks() {
        return _numberWorks;
    }

    public void incrementWorks() {
        _numberWorks++;
    }

    public void decrementWorks() {
        _numberWorks--;
    }

    public List<Notification> getNotificationsList() {
        return _notificationList;
    }

    public void checkLast3() {
        _behaviour.checkLast3();
    }

    public void checkLast5() {
        _behaviour.checkLast5();
    }

    /*public void status() {
        System.out.println(_behaviour.status());
    }*/

    public void payFine() {
         _fine = 0;
    }

    public boolean hasLateRequests(Map<Integer, Request> requestsMap, int currentDay) {
        for (Request r : requestsMap.values()) 
            if (r.getUser().getID() == getID() && r.getReturnDay() < currentDay)
                return true;
        return false;
    }

    public void registerNotification(Notification n) {
        _notificationList.add(n);
    }

    public void unregisterNotification(Notification n) {
        _notificationList.remove(n);
    }

    public String notifyUser() {
        String string = "";
        for (Notification notification : getNotificationsList()) {
            string += notification.toString() + notification.getWork().showWork() + "\n";
            getNotificationsList().remove(notification);
        }
        return string;
    }

    /** Represents work as a string. */
    public String showUser() {
        String r = getID() + " - " + getName() + " - " + getEmail() + " - " + getBehaviour().toString() + " - " + toStringActive();
        if (getFine() > 0)
            r = r + " - EUR " + getFine();
        return r;
    }
}
