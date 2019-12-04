package m19.exceptions;

public class DuplicateUserException extends Exception {

    private static final long serialVersionUID = 201901101348L;
    private String _name;
    private int _id;

    public DuplicateUserException(int id, String name) {
        _name = name;
        _id = id;
    }

    /*public DuplicateUserException(String entrySpecification, Exception cause) {
        super(cause);
        _entrySpecification = entrySpecification;
    }*/

    public String getName() {
        return _name;
    }

}