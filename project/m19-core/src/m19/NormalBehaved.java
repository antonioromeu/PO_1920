package m19;

public class NormalBehaved extends Behaviour {

    private static final long serialVersionUID = 20160823117L;
    
    public NormalBehaved(User user) {
        super(user);
    }

    @Override
    public void checkLast3() {
        if (getBehaviourListSize() < 3)
            return;
        for (int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 3; i--)
            if (getBehaviourFromList(i) != 0)
                return;
        _user.setBehaviour(new BadlyBehaved(_user));
    }

    @Override
    public void checkLast5() {
        if (getBehaviourListSize() < 5)
            return;
        for (int i = getBehaviourListSize() - 1; i >= getBehaviourListSize() - 5; i--)
            if (getBehaviourFromList(i) != 1)
                return;
        _user.setBehaviour(new WellBehaved(_user));
    }

    @Override
    public String toString() {
        return "NORMAL";
    }

}