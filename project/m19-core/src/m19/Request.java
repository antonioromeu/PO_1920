package m19;

public class Request {
    private User _user;
    private Work _work;
    private int _requestDay;
    private int _returnDay;
    private int _id;

    public Request(User user, Work work, int requestDay) {
        _user = user;
        _work = work;
        _requestDay = requestDay;
        _id = user.getID() + work.getID();
    }

    public int getID() {
        return _id;
    }

    public int getReturnDay() {
        if (_work.getCopies() == 1) {
            switch(_user.getBehaviour().getClass().getName()) {
                case "WellBehaved":
                    _returnDay = _requestDay + 8;
                case "NormalBehaved":
                    _returnDay = _requestDay + 3;
                case "BadlyBehaved":
                    _returnDay = _requestDay + 2;
            }
        }
        if (_work.getCopies() <= 5) {
            switch(_user.getBehaviour().getClass().getName()) {
                case "WellBehaved":
                    _returnDay = _requestDay + 15;
                case "NormalBehaved":
                    _returnDay = _requestDay + 8;
                case "BadlyBehaved":
                    _returnDay = _requestDay + 2;
            }
        }
        if (_work.getCopies() > 5) {
            switch(_user.getBehaviour().getClass().getName()) {
                case "WellBehaved":
                    _returnDay = _requestDay + 30;
                case "NormalBehaved":
                    _returnDay = _requestDay + 15;
                case "BadlyBehaved":
                    _returnDay = _requestDay + 2;
            }
        }
        return _returnDay;
    }
    public Work getWork() {
        return _work;
    }
    public User getUser() {
        return _user;
    }
}