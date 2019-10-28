package m19.app.requests;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

// FIXME import core concepts
// FIXME import ui concepts

public class DoReturnWork extends Command<LibraryManager> {

    // FIXME define input fields

    public DoReturnWork(LibraryManager receiver) {
        super(Label.RETURN_WORK, receiver);
        // FIXME initialize input fields
    }

    @Override
    public final void execute() throws DialogException {
        // FIXME implement command
    }

}
