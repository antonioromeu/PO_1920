package m19;

public class User {

    private int _id;
    private String _name;
    private String _email;
    private boolean _active;
    private double _fine;
    private Behaviour _behaviour = new NormalBehaved(this);

    public User(int usersCounter, String name, String emailr) {
        _id = usersCounter;
        _name = name;
        _email = email;
        _active = true;
        _fine = 0;
    }

    protected void setBehaviour(Behaviour b) {
        _behaviour = b;
    }

    public boolean checkLast3() {
        _behaviour.checkLast3();
    }

    public boolean checkLast5() {
        _behaviour.checkLast5();
    }

    public void status() {
        System.out.println(_behaviour.status());
    }

    public void payFine() {} // PARA TERCEIRA ENTREGA

}