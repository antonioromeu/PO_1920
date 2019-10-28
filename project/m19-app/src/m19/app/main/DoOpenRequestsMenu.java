package m19.app.main;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoOpenRequestsMenu extends Command<LibraryManager> {

    public DoOpenRequestsMenu(LibraryManager receiver) {
        super(Label.OPEN_REQUESTS_MENU, receiver);
    }

    @Override
    public final void execute() {
        m19.app.requests.Menu menu = new m19.app.requests.Menu(_receiver);
        menu.open();
    }
}
