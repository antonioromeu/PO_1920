package m19.app.main;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import m19.exceptions.FailedToOpenFileException;
import m19.app.exceptions.FileOpenFailedException;
import java.io.IOException;

// FIXME import core concepts
// FIXME import ui concepts

public class DoOpen extends Command<LibraryManager> {

    // FIXME define input fields if needed

    public DoOpen(LibraryManager receiver) {
        super(Label.OPEN, receiver);
        // FIXME initialize input fields if needed
    }

    @Override
    public final void execute() throws DialogException {
        /*try {
        // FIXME implement command
        } catch (FailedToOpenFileException fnfe) {
        throw new FileOpenFailedException(fnfe.getName());
        } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
        }*/
    }

}
