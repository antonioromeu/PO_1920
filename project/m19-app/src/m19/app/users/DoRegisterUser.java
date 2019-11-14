package m19.app.users;

import m19.LibraryManager;
import m19.app.exceptions.NoSuchUserException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoRegisterUser extends Command<LibraryManager> {
    Input<String> _name;
    Input<String> _mail;

    public DoRegisterUser(LibraryManager receiver) {
        super(Label.REGISTER_USER, receiver);
        _name = _form.addStringInput(Message.requestUserName());
        _mail = _form.addStringInput(Message.requestUserEMail());
    }

    @Override
    public final void execute() throws DialogException {
        _form.parse();
            _display.popup(Message.userRegistrationSuccessful(_receiver.registerUser(_name.value(), _mail.value()))); 
    }
}