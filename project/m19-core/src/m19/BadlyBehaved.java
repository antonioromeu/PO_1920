package m19;

public class BadlyBehaved extends Behaviour {
    
    public BadlyBehaved(User user) {
        super(user);
    }

    public void checkLast3() {
        for(int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 3; i--) {
            if (getBehaviourFromList(i) != 1) return;
        }
        _user.setBehaviour(new NormalBehaved(_user));
    }

    public void checkLast5() {
        for(int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 5; i--) {
            if (getBehaviourFromList(i) != 1) return;
        }
        _user.setBehaviour(new WellBehaved(_user));
    }

}