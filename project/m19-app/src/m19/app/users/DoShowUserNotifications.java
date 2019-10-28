package m19.app.users;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoShowUserNotifications extends Command<LibraryManager> {

    // FIXME define input fields

    public DoShowUserNotifications(LibraryManager receiver) {
        super(Label.SHOW_USER_NOTIFICATIONS, receiver);
        // FIXME initialize input fields
    }

    @Override
    public final void execute() throws DialogException {
        // FIXME implement command
    }

}
