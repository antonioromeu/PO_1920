package m19.app.requests;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoRequestWork extends Command<LibraryManager> {

    Input<Integer> _workID;
    Input<Integer> _userID;

    public DoRequestWork(LibraryManager receiver) {
        super(Label.REQUEST_WORK, receiver);
        _workID = _form.addIntegerInput(Message.requestWorkId());
        _userID = _form.addIntegerInput(Message.requestUserId());
    }

    @Override
    public final void execute() throws DialogException {
        /*_form.parse();
        try {
            _display.popup(_receiver.requestWork(_userID.value(), _workID.value()));
        } catch (NoSuchUserExistsInMapException e) {
            throw new NoSuchUserException(_userID.value());
        } catch (NoSuchWorkExistsInMapException e) {
            throw new NoSuchWorkException(_id.value());
        }*/
    }
}