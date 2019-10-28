package m19.app.works;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoDisplayWorks extends Command<LibraryManager> {

    public DoDisplayWorks(LibraryManager receiver) {
        super(Label.SHOW_WORKS, receiver);
    }

    @Override
    public final void execute() {
        // FIXME implement command
    }
}
