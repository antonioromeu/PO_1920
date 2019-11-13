package m19;

public class BadlyBehaved extends Behaviour {

    private static final long serialVersionUID = 20160823115L;
    
    public BadlyBehaved(User user) {
        super(user);
    }

    @Override
    public void checkLast3() {
        for(int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 3; i--) {
            if (getBehaviourFromList(i) != 1) return;
        }
        _user.setBehaviour(new NormalBehaved(_user));
    }

    @Override
    public void checkLast5() {
        for(int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 5; i--) {
            if (getBehaviourFromList(i) != 1) return;
        }
        _user.setBehaviour(new WellBehaved(_user));
    }

    @Override
    public String toString() {
        return "FALTOSO";
    }

}