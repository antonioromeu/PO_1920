package m19.app.requests;

import m19.Request;
import m19.LibraryManager;

import m19.exceptions.NoSuchWorkExistsInMapException;
import m19.exceptions.ReturnFailedException;
import m19.exceptions.FailedToPayFineException;
import m19.exceptions.NoSuchUserExistsInMapException;

import m19.app.exceptions.NoSuchUserException;
import m19.app.exceptions.NoSuchWorkException;
import m19.app.exceptions.WorkNotBorrowedByUserException;
import m19.app.exceptions.UserIsActiveException;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoReturnWork extends Command<LibraryManager> {

    Input<Integer> _workId;
    Input<Integer> _userId;
    Input<String> _answer;

    public DoReturnWork(LibraryManager receiver) {
        super(Label.RETURN_WORK, receiver);
    }
    
    @Override
    public final void execute() throws DialogException {
        _form.clear();
        _userId = _form.addIntegerInput(Message.requestUserId());
        _workId = _form.addIntegerInput(Message.requestWorkId());
        _form.parse();
        try {
            Request request = _receiver.getRequest(_userId.value(), _workId.value());
            _receiver.returnWork(_userId.value(), _workId.value());
            if (!_receiver.getUser(_userId.value()).isActive()) {
                _display.popup(Message.showFine(_userId.value(), _receiver.getUser(_userId.value()).getFine()));
                _form.clear();
                _answer = _form.addStringInput(Message.requestFinePaymentChoice());
                _form.parse();
                if (_answer.value().equals("s")) {
                    _receiver.payFine(_userId.value());
                }
            }
        } catch (NoSuchUserExistsInMapException e) {
            throw new NoSuchUserException(_userId.value());
        } catch (NoSuchWorkExistsInMapException e) {
            throw new NoSuchWorkException(_workId.value());
        } catch (ReturnFailedException e) {
            throw new WorkNotBorrowedByUserException(_workId.value(), _userId.value());
        } catch (FailedToPayFineException e) {
            throw new UserIsActiveException(_userId.value());
        }
    }
}