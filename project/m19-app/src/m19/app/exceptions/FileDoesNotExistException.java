package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class FileDoesNotExistException extends DialogException {

    private static final long serialVersionUID = 201901101348L;

    private String _name;

    public FileDoesNotExistException(String name) {
        _name = name;
    }
      
    @Override
    public String getMessage() {
        return Message.fileNotFound(_name);
    }
}