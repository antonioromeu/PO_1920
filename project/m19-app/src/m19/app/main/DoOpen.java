package m19.app.main;

import m19.LibraryManager;
import m19.exceptions.FailedToOpenFileException;
import m19.app.exceptions.FileOpenFailedException;
import m19.app.exceptions.FileDoesNotExistException;

import java.io.FileNotFoundException;
import java.io.IOException;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
  * 4.1.1. Open existing document.
  */

public class DoOpen extends Command<LibraryManager> {

    Input<String> _filename;

    /**
    * @param receiver
    */
    public DoOpen(LibraryManager receiver) {
        super(Label.OPEN, receiver);
        _filename = _form.addStringInput(Message.openFile());
    }

    @Override
    /** @see pt.tecnico.po.ui.Command#execute() */
    public final void execute() throws DialogException {
        _form.parse();
        try {
            _receiver.load(_filename.value());
        } catch (FailedToOpenFileException e) {
            throw new FileOpenFailedException(_filename.value());
        }
    }
}