package m19.app.main;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
// FIXME import core concepts
// FIXME import ui concepts

public class DoSave extends Command<LibraryManager> {
  
    // FIXME define input fields

    public DoSave(LibraryManager receiver) {
        super(Label.SAVE, receiver);
        // FIXME initialize input fields
    }

    @Override
    public final void execute() {
        // FIXME implement command
    }
}
