package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class NoSuchUserException extends DialogException {

    static final long serialVersionUID = 201901091828L;
    private int _id;

    public NoSuchUserException(int id) {
        _id = id;
    }

    @Override
    public String getMessage() {
        return Message.noSuchUser(_id);
    }
}