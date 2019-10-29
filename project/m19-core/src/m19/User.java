package m19;

public class User {

    private int _id;
    private String _name;
    private String _email;
    private boolean _active;
    private double _fine;
    private Behaviour _behaviour = new NormalBehaved(this);

    public User(int usersCounter, String name, String email) {
        _id = usersCounter;
        _name = name;
        _email = email;
        _active = true;
        _fine = 0;
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

    public double getFine() {
        return _fine;
    }

    public Behaviour getBehaviour() {
        return _behaviour;
    }

    protected void setBehaviour(Behaviour b) {
        _behaviour = b;
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

}