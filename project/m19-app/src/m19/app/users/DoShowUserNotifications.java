package m19.app.users;

import m19.LibraryManager;
import m19.exceptions.NoSuchUserExistsInMapException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoShowUserNotifications extends Command<LibraryManager> {

    Input<Integer> _userId;

    public DoShowUserNotifications(LibraryManager receiver) {
        super(Label.SHOW_USER_NOTIFICATIONS, receiver);
        _userId = _form.addIntegerInput(Message.requestUserId());
    }

    @Override
    public final void execute() throws DialogException {
        _form.parse();
        try {
            _display.popup(_receiver.notifyUser(_userId));
        } catch (NoSuchUserExistsInMapException e) {
            e.printStackTrace();
        }
    }

}
