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

    private List<Work> _worksWanted = new ArrayList<Work>(); 

    public User(int usersCounter, String name, String email) {
        _id = usersCounter;
        _name = name;
        _email = email;
        _active = true;
    }

    public int compareTo(User user) {
        if (!this.getName().equals(user.getName())) 
            return (this.getName().compareTo(user.getName()));
        else if (this.getId() < user.getId())
            return -1;
        else
            return 1;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }
    
    public int getFine() {
        return _fine;
    }
    
    public Behaviour getBehaviour() {
        return _behaviour;
    }

    public List<Work> getWantedWorks() {
        return _worksWanted;
    }

    public int getNumberWorks() {
        return _numberWorks;
    }

    public List<Notification> getNotificationsList() {
        return _notificationList;
    }

    public void setActiveness(boolean b) {
        _active = b;
    }

    public void setFine(int value) {
        _fine = value;
    }

    protected void setBehaviour(Behaviour b) {
        _behaviour = b;
    }
    public boolean isActive() {
        return _active;
    }

    public String toStringActive() {
        if (_active)
            return "ACTIVO";
        else return "SUSPENSO";
    }

    public void incrementFine(int n_days) {
        _fine += (n_days * 5);
    }
    
    public void incrementWorks() {
        _numberWorks++;
    }

    public void decrementWorks() {
        _numberWorks--;
    }

    public void checkLast3() {
        _behaviour.checkLast3();
    }

    public void checkLast5() {
        _behaviour.checkLast5();
    }

    public void addWantedWork(Work work) {
        _worksWanted.add(work);
    }

    public void removeWantedWork(Work work) {
        _worksWanted.remove(work);
    }

    public void payFine() {
         _fine = 0;
    }

    public boolean hasLateRequests(Map<List<Integer>, Request> requestsMap, int currentDay) {
        for (Request r : requestsMap.values()) 
            if (r.getUser().getId() == getId() && r.isLate())
                return true;
        return false;
    }

    public void registerNotification(Notification n) {
        _notificationList.add(n);
    }

    public void unregisterNotification(Notification n) {
        _notificationList.remove(n);
    }

    public String showNotifications() {
        String string = "";
        for (Notification notification : _notificationList)
            string += notification.toString() + notification.getWork().showWork() + "\n";
        getNotificationsList().removeAll(getNotificationsList());
        return string;
    }

    /** Represents work as a string. */
    public String showUser() {
        String r = getId() + " - " + getName() + " - " + getEmail() + " - " + getBehaviour().toString() + " - " + toStringActive();
        if (!isActive())
            r = r + " - EUR " + getFine();
        r += showNotifications();
        return r;
    }
}