package m19.app.requests;

import m19.LibraryManager;
import pt.tecnico.po.ui.Command;

public class Menu extends pt.tecnico.po.ui.Menu {

    public Menu(LibraryManager receiver) {
        super(Label.TITLE, new Command<?>[] { //
            new DoRequestWork(receiver), //
            new DoReturnWork(receiver), //
        });
    }

}
