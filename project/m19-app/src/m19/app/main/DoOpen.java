package m19.app.main;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import m19.exceptions.FailedToOpenFileException;
import m19.app.exceptions.FileOpenFailedException;
import m19.app.exceptions.FileDoesNotExistException;

import java.io.FileNotFoundException;
import java.io.IOException;
import pt.tecnico.po.ui.Input;

public class DoOpen extends Command<LibraryManager> {

    Input<String> _filename;

    public DoOpen(LibraryManager receiver) {
        super(Label.OPEN, receiver);
        _filename = _form.addStringInput(Message.openFile());
    }

    @Override
    public final void execute() throws DialogException {
        _form.parse();
        try {
            _receiver.load(_filename.value());
        } catch (FileNotFoundException e) {
            throw new FileDoesNotExistException(_filename.value());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace(); //esta bem?
        }
    }

}
