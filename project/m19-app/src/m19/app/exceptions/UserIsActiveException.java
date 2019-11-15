package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class UserIsActiveException extends DialogException {
  
    static final long serialVersionUID = 201901091828L;
    private int _id;

    public UserIsActiveException(int id) {
        _id = id;
    }

    @Override
    public String getMessage() {
        return Message.userNotSuspended(_id);
    } 
}