package m19.exceptions;

public class ImportFileException extends Exception {
  
    private static final long serialVersionUID = 201901101348L;

    public ImportFileException() {} //Do nothing

    public ImportFileException(String description) {
        super(description);
    }

    public ImportFileException(Exception cause) {
        super(cause);
    }

}
