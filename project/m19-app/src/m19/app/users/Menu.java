package m19.app.users;

import m19.LibraryManager;
import pt.tecnico.po.ui.Command;

public class Menu extends pt.tecnico.po.ui.Menu {

    public Menu(LibraryManager receiver) {
        super(Label.TITLE, new Command<?>[] { //
            new DoRegisterUser(receiver), //
            new DoShowUser(receiver), //
            new DoShowUsers(receiver), //
            new DoShowUserNotifications(receiver), //
            new DoPayFine(receiver), //
        });
    }

}
