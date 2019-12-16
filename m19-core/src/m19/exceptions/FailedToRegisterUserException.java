package m19.exceptions;

/**
  * Class for representing a failed user registration error.
  */

public class FailedToRegisterUserException extends Exception {

    /** Serial number for serialization. */
    static final long serialVersionUID = 201901124678L;
    
    /** Bad user name. */
    private String _name;

    /** Bad user email. */
    private String _email;

    /**
    * @param name
    */
    public FailedToRegisterUserException(String name, String email) {
        _name = name;
        _email = email;
    }

    /**
    * @return the name
    */
    public String getName() {
        return _name;
    }

    /**
    * @return the email
    */
    public String getEmail() {
        return _email;
    }

}