package m19.app.users;

import m19.LibraryManager;
import m19.app.exceptions.NoSuchUserException;
import m19.exceptions.NoSuchUserExistsInMapException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoShowUser extends Command<LibraryManager> {

    Input<Integer> _id;
    
    public DoShowUser(LibraryManager receiver) {
        super(Label.SHOW_USER, receiver);
        _id = _form.addIntegerInput(Message.requestUserId());
    }

    @Override
    public final void execute() throws DialogException, NoSuchUserException {
        _form.parse();
        try {
            _display.popup(_receiver.getUser(_id.value()).showUser()); 
        } catch (NoSuchUserExistsInMapException e) {
            throw new NoSuchUserException(_id.value());
        }
    }
}