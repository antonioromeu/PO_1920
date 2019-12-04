package m19.app.main;

import m19.LibraryManager;
import m19.exceptions.MissingFileAssociationException;
import m19.app.exceptions.FileDoesNotExistException;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
  * 4.1.1. Save to file under current name (if unnamed, query for name).
  */
 
public class DoSave extends Command<LibraryManager> {
  
    Input<String> _filename;

    /**
    * @param receiver
    */
    public DoSave(LibraryManager receiver) {
        super(Label.SAVE, receiver);
        _filename = _form.addStringInput(Message.newSaveAs());
    }

    @Override
    /** @see pt.tecnico.po.ui.Command#execute() */
    public final void execute() {
        _form.parse();
        try {
            _receiver.saveAs(_filename.value());
        } catch (MissingFileAssociationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}