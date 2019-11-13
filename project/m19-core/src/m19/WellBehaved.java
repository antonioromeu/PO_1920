package m19;

public class WellBehaved extends Behaviour {

    private static final long serialVersionUID = 20160823116L;
    
    public WellBehaved(User user) {
        super(user);
    }

    @Override
    public void checkLast3() {
        for(int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 3; i--) {
            if (getBehaviourFromList(i) != 0) return;
        }
        _user.setBehaviour(new BadlyBehaved(_user));
    }

    @Override
    public void checkLast5() {}

    @Override
    public String toString() {
        return "CUMPRIDOR";
    }
    
}