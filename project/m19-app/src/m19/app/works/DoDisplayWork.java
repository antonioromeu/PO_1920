package m19.app.works;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoDisplayWork extends Command<LibraryManager> {

    // FIXME define input fields

    public DoDisplayWork(LibraryManager receiver) {
        super(Label.SHOW_WORK, receiver);
        // FIXME initialize input fields
    }

    @Override
    public final void execute() throws DialogException {
        // FIXME implement command
    }
  
}
