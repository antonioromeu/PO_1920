package m19.app.main;

import m19.LibraryManager;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoOpenWorksMenu extends Command<LibraryManager> {

    public DoOpenWorksMenu(LibraryManager receiver) {
        super(Label.OPEN_WORKS_MENU, receiver);
    }

    @Override
    public final void execute() {
        m19.app.works.Menu menu = new m19.app.works.Menu(_receiver);
        menu.open();
    } 
}