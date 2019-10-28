package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class NoSuchWorkException extends DialogException {
  
    static final long serialVersionUID = 201901091828L;
    private int _id;

    public NoSuchWorkException(int id) {
        _id = id;
    }

    @Override
    public String getMessage() {
        return Message.noSuchWork(_id);
    }
  
}
