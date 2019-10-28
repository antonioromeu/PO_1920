package m19.app.main;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoDisplayDate extends Command<LibraryManager> {

    public DoDisplayDate(LibraryManager receiver) {
        super(Label.DISPLAY_DATE, receiver);
    }

    @Override
    public final void execute() {
        // FIXME define method
    }
  
}
