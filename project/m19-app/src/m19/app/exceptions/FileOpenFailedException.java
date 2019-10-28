package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class FileOpenFailedException extends DialogException {

    static final long serialVersionUID = 201901091828L;
    private String _name;

    public FileOpenFailedException(String name) {
        _name = name;
    }

    @Override
    public String getMessage() {
        return Message.fileNotFound(_name);
    }

}
