package m19;

import java.io.Serializable;

public class Request implements Serializable {

    private static final long serialVersionUID = 20160823120L;

    private User _user;
    private Work _work;
    private int _requestDay;
    private int _returnDay;
    private int _fine;
    private boolean _late;

    public Request(User user, Work work, int requestDay) {
        _user = user;
        _work = work;
        _requestDay = requestDay;
        _fine = 0;
        _late = false;
    }

    public int getReturnDay() {
        if (_work.getCopies() == 1) {
            switch(_user.getBehaviour().getClass().getName()) {
                case "m19.WellBehaved":
                    _returnDay = _requestDay + 8;
                    break;
                case "m19.NormalBehaved":
                    _returnDay = _requestDay + 3;
                    break;
                case "m19.BadlyBehaved":
                    _returnDay = _requestDay + 2;
                    break;
            }
        }
        else if (_work.getCopies() <= 5) {
            switch(_user.getBehaviour().getClass().getName()) {
                case "m19.WellBehaved":
                    _returnDay = _requestDay + 15;
                    break;
                case "m19.NormalBehaved":
                    _returnDay = _requestDay + 8;
                    break;
                case "m19.BadlyBehaved":
                    _returnDay = _requestDay + 2;
                    break;
            }
        }
        else if (_work.getCopies() > 5) {
            switch(_user.getBehaviour().getClass().getName()) {
                case "m19.WellBehaved":
                    _returnDay = _requestDay + 30;
                    break;
                case "m19.NormalBehaved":
                    _returnDay = _requestDay + 15;
                    break;
                case "m19.BadlyBehaved":
                    _returnDay = _requestDay + 2;
                    break;
            }
        }
        return _returnDay;
    }

    public int getRequestDay() {
        return _requestDay;
    }

    public boolean isLate() {
        return _late;
    }

    public void setLateness(boolean value) {
        _late = value;
    }

    public Work getWork() {
        return _work;
    }

    public User getUser() {
        return _user;
    }

    public int getFine() {
        return _fine;
    }

    public void incrementFine(int n_days) {
        _fine += (n_days * 5);
    }

    public void payFine() {
        _fine = 0;
    }
}