package m19;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Behaviour implements Serializable {

    private static final long serialVersionUID = 20160823120L;

    protected User _user;
    private ArrayList<Integer> _behaviourList = new ArrayList<Integer>(); //1 entregou a tempo; 0 falhou entrega

    public Behaviour(User user) {
        _user = user;
    }

    public int getBehaviourFromList(int index) {
        return _behaviourList.get(index);
    }

    public int getBehaviourListSize() {
        return _behaviourList.size();
    }

    public void addBehaviourToList(int i) {
        _behaviourList.add(i);
    }
    
    public String status() {
        return getClass().getName();
    }

    public abstract String toString();
    public abstract void checkLast3();
    public abstract void checkLast5();

}