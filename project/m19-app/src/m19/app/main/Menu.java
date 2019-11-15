package m19.app.main;

import m19.LibraryManager;

import pt.tecnico.po.ui.Command;

public class Menu extends pt.tecnico.po.ui.Menu {

    public Menu(LibraryManager receiver) {
        super(Label.TITLE, new Command<?>[] { //4.1
            new DoOpen(receiver), //
            new DoSave(receiver), //
            new DoDisplayDate(receiver), //
            new DoAdvanceDate(receiver), //
            new DoOpenUsersMenu(receiver), //
            new DoOpenWorksMenu(receiver), //
            new DoOpenRequestsMenu(receiver), //
        });
    }
}