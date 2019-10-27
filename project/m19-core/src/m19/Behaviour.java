package m19;

public abstract class Behaviour {

    protected User _user; //FAZ SENTIDO?
    private ArrayList<Int> _behaviourList; //1 entregou a tempo; 0 falhou entrega

    public Behaviour(User user) {
        _user = user;
    }

    public int getBehaviourFromList(int index) {
        return _behaviourList[index];
    }

    public int getBehaviourListSize() {
        return _behaviourList.length;
    }
    
    public String status() {
        return getClass().getName();
    }

    public abstract boolean checkLast3();
    public abstract boolean checkLast5();

}