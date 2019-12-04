package m19.app.requests;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import m19.app.exceptions.NoSuchWorkException;
import m19.exceptions.NoSuchWorkExistsInMapException;
import m19.exceptions.RequestFailedException;
import m19.app.exceptions.NoSuchUserException;
import m19.app.exceptions.RuleFailedException;
import m19.exceptions.NoSuchUserExistsInMapException;

public class DoRequestWork extends Command<LibraryManager> {

    Input<Integer> _workId;
    Input<Integer> _userId; 
    Input<String> _answer; 

    public DoRequestWork(LibraryManager receiver) {
        super(Label.REQUEST_WORK, receiver);
    }
    
    @Override
    public final void execute() throws DialogException {
        _form.clear();
        _userId = _form.addIntegerInput(Message.requestUserId());
        _workId = _form.addIntegerInput(Message.requestWorkId());
        _form.parse();
        try {
            _receiver.requestWork(_userId.value(), _workId.value());
            _display.popup(Message.workReturnDay(_workId.value(), _receiver.getRequest(_userId.value(), _workId.value()).getReturnDay()));
        } catch (NoSuchUserExistsInMapException e) {
            throw new NoSuchUserException(_userId.value());
        } catch (NoSuchWorkExistsInMapException e) {
            throw new NoSuchWorkException(_workId.value());
        } catch (RequestFailedException e) {
            if (e.getIndex() == 3) {
                _form.clear();
                _answer = _form.addStringInput(Message.requestReturnNotificationPreference());
                _form.parse();
                _form.clear();
                if (_answer.equals("s")) {
                    try {
                        _receiver.notifyUser(_userId.value(), _workId.value(), "Request");
                    } catch (NoSuchUserExistsInMapException e2) {
                        throw new NoSuchUserException(_userId.value());
                    } catch (NoSuchWorkExistsInMapException e2) {
                        throw new NoSuchWorkException(_workId.value());
                    }
                }
            }
            else
                throw new RuleFailedException(_userId.value(), _workId.value(), e.getIndex());
        }
    }
}