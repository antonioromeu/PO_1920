package m19.exceptions;

/**
  * Class for representing a failed request error.
  */

public class RequestFailedException extends Exception {

    private int _index;

    /** Serial number for serialization. */
    static final long serialVersionUID = 201901091830L;

    public RequestFailedException(int index) {
        _index = index;
    } 

    public int getIndex() {
        return _index;
    }

}