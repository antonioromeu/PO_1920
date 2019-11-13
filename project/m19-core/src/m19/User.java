package m19;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 201608231530L;

    private int _id;
    private String _name;
    private String _email;
    private boolean _active;
    private double _fine = 0;
    private Behaviour _behaviour = new NormalBehaved(this);
    private int _numberWorks = 0;

    public User(int usersCounter, String name, String email) {
        _id = usersCounter;
        _name = name;
        _email = email;
        _active = true;
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

    public String toStringActive() {
        if (_active) {
            return "ACTIVO";
        }
        else return "PASSIVO";
    }

    public double getFine() {
        return _fine;
    }

    public void setFine(int fine) {
        _fine = fine;
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

    public void upNumberWorks() {
        _numberWorks++;
    }

    public void checkLast3() {
        _behaviour.checkLast3();
    }

    public void checkLast5() {
        _behaviour.checkLast5();
    }

    public void status() {
        System.out.println(_behaviour.status());
    }

    public void payFine() {} // PARA TERCEIRA ENTREGA

    public String showUser() {
        String r = getID() + " - " + getName() + " - " + getEmail() + " - " + getBehaviour().toString() + " - " + toStringActive();
        if (getFine() != 0)
            r = r + " - EUR " + getFine();
        return r;
    }

}