package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class WorkNotBorrowedByUserException extends DialogException {
  
    static final long serialVersionUID = 200510291601L;
    private int _idUser;
    private int _idWork;

    public WorkNotBorrowedByUserException(int idWork, int idUser) {
        _idWork = idWork;
        _idUser = idUser;
    }

    @Override
    public String getMessage() {
        return Message.workNotBorrowedByUser(_idWork, _idUser);
    } 
}