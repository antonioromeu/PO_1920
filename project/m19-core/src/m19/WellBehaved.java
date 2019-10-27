package m19;

public class WellBehaved extends Behaviour {
    
    public WellBehaved(User user) {
        super(user);
    }

    public void checkLast3() {
        for(int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 3; i--) {
            if (getBehaviourFromList(i) != 0) return;
        }
        _user.setBehaviour(new BadlyBehaved(_user));
    }
    
}