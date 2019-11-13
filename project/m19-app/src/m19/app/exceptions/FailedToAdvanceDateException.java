package m19.app.exceptions;

import pt.tecnico.po.ui.DialogException;

public class FailedToAdvanceDateException extends DialogException {

    private static final long serialVersionUID = 201901101348L;
      
    @Override
    public String getMessage() {
        return Message.negativeDaysToAdvance();
    }
}