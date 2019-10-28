package m19.app.works;

import m19.LibraryManager;
import pt.tecnico.po.ui.Command;

public class Menu extends pt.tecnico.po.ui.Menu {

    public Menu(LibraryManager receiver) {
        super(Label.TITLE, new Command<?>[] { //
            new DoDisplayWork(receiver), //
            new DoDisplayWorks(receiver), //
            new DoPerformSearch(receiver), //
        });
    }

}
