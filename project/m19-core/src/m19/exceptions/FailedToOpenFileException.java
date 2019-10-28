package m19.exceptions;

public class FailedToOpenFileException extends Exception {

    static final long serialVersionUID = 201901091828L;
    private String _name;

    public FailedToOpenFileException(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

}
