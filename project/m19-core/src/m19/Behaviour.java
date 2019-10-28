package m19;

import java.util.ArrayList;

public abstract class Behaviour {

    protected User _user; //FAZ SENTIDO?
    private ArrayList<Integer> _behaviourList; //1 entregou a tempo; 0 falhou entrega

    public Behaviour(User user) {
        _user = user;
    }

    public int getBehaviourFromList(int index) {
        return _behaviourList.get(index);
    }

    public int getBehaviourListSize() {
        return _behaviourList.size();
    }
    
    public String status() {
        return getClass().getName();
    }

    public abstract void checkLast3();
    public abstract void checkLast5();

}