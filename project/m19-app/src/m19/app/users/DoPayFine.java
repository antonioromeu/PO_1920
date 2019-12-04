package m19.app.users;

import m19.LibraryManager;
import m19.exceptions.FailedToPayFineException;
import m19.app.exceptions.UserIsActiveException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoPayFine extends Command<LibraryManager> {

    Input<Integer> _userId;

    public DoPayFine(LibraryManager receiver) {
        super(Label.PAY_FINE, receiver);
        _userId = _form.addIntegerInput(Message.requestUserId());
    }

    @Override
    public final void execute() throws DialogException {
        _form.parse();
        try {
            _receiver.payFine(_userId.value());
        } catch (FailedToPayFineException e) {
            throw new UserIsActiveException(_userId.value());
        }
    }

}
