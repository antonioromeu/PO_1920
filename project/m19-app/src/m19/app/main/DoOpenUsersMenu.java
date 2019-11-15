package m19.app.main;

import m19.LibraryManager;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoOpenUsersMenu extends Command<LibraryManager> {

    public DoOpenUsersMenu(LibraryManager receiver) {
        super(Label.OPEN_USERS_MENU, receiver);
    }

    @Override
    public final void execute() {
        m19.app.users.Menu menu = new m19.app.users.Menu(_receiver);
        menu.open();
    } 
}