package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class UserAlreadyExistsException extends DialogException {
  
    static final long serialVersionUID = 201901091828L;

    @Override
    public String getMessage() {
        return Message.userAlreadyExists();
    } 
}