package m19.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import m19.LibraryManager;
import m19.exceptions.MissingFileAssociationException;
import m19.app.exceptions.FileDoesNotExistException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoSave extends Command<LibraryManager> {
  
    Input<String> _filename;

    public DoSave(LibraryManager receiver) {
        super(Label.SAVE, receiver);
        _filename = _form.addStringInput(Message.newSaveAs());
    }

    @Override
    public final void execute() {
        if (_receiver.getFileName() == "") {
            _form.parse();
        }
        try {
            _receiver.saveAs(_filename.value());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
