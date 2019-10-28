package m19.app.users;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoShowUsers extends Command<LibraryManager> {

    public DoShowUsers(LibraryManager receiver) {
        super(Label.SHOW_USERS, receiver);
    }

    @Override
    public final void execute() {
        // FIXME implement command
    }
  
}
