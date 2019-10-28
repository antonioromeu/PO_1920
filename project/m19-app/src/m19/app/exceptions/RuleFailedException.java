package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class RuleFailedException extends DialogException {

    static final long serialVersionUID = 200510291601L;
    int _idUser;
    int _idWork;
    int _ruleIndex = -1;

    public RuleFailedException(int idUser, int idWork, int ruleIndex) {
        _idUser = idUser;
        _idWork = idWork;
        _ruleIndex = ruleIndex;
    }

    public int getRuleIndex() {
        return _ruleIndex;
    }

    public int getWork() {
        return _idWork;
    }

    public int getUser() {
        return _idUser;
    }

    @Override
    public String getMessage() {
        return Message.ruleFailed(_idUser, _idWork, _ruleIndex);
    }

}
