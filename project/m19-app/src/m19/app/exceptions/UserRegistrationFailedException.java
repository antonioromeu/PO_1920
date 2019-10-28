package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class UserRegistrationFailedException extends DialogException {
  
    static final long serialVersionUID = 201901091828L;
    private String _name;
    private String _email;

    public UserRegistrationFailedException(String name, String email) {
        _name = name;
        _email = email;
    }

    @Override
    public String getMessage() {
        return Message.userRegistrationFailed(_name, _email);
    }
  
}
