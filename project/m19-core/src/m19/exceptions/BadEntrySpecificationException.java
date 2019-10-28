package m19.exceptions;

public class BadEntrySpecificationException extends Exception {

    private static final long serialVersionUID = 201901101348L;
    private String _entrySpecification;

    public BadEntrySpecificationException(String entrySpecification) {
        _entrySpecification = entrySpecification;
    }

    public BadEntrySpecificationException(String entrySpecification, Exception cause) {
        super(cause);
        _entrySpecification = entrySpecification;
    }

    public String getEntrySpecification() {
        return _entrySpecification;
    }

}
