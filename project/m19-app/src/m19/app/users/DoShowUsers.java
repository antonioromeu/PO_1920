package m19.app.users;

import m19.LibraryManager;
import m19.User;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoShowUsers extends Command<LibraryManager> {

    public DoShowUsers(LibraryManager receiver) {
        super(Label.SHOW_USERS, receiver);
    }

    @Override
    public final void execute() {
        String r = "";
        for (User u : _receiver.getUsers()) {
            r += u.showUser() + '\n';
        }
        _display.popup(r);
    }
}
