package m19.app.users;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoPayFine extends Command<LibraryManager> {

    // FIXME define input fields

    public DoPayFine(LibraryManager receiver) {
        super(Label.PAY_FINE, receiver);
        // FIXME initialize input fields
    }

    @Override
    public final void execute() throws DialogException {
        // FIXME implement command
    }

}
