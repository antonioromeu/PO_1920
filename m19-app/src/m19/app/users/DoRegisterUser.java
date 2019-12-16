package m19.app.users;

import m19.LibraryManager;
import m19.app.exceptions.NoSuchUserException;
import m19.app.exceptions.UserRegistrationFailedException;
import m19.exceptions.FailedToRegisterUserException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input; 

/**
  * 4.2.1. Register new user.
  */

public class DoRegisterUser extends Command<LibraryManager> {
    Input<String> _name;
    Input<String> _email;

    /**
    * @param receiver
    */
    public DoRegisterUser(LibraryManager receiver) {
        super(Label.REGISTER_USER, receiver);
        _name = _form.addStringInput(Message.requestUserName());
        _email = _form.addStringInput(Message.requestUserEMail());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws DialogException, UserRegistrationFailedException {
        _form.parse();
        try {
            _display.popup(Message.userRegistrationSuccessful(_receiver.registerUser(_name.value(), _email.value()))); 
        } catch (FailedToRegisterUserException e) {
            throw new UserRegistrationFailedException(_name.value(), _email.value());
        }
    }
}