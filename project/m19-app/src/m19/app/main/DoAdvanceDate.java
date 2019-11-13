package m19.app.main;

import m19.LibraryManager;
import m19.exceptions.NegativeDaysToAdvanceException;
import m19.app.exceptions.FailedToAdvanceDateException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

public class DoAdvanceDate extends Command<LibraryManager> {

    Input<Integer> _days;

    public DoAdvanceDate(LibraryManager receiver) {
        super(Label.ADVANCE_DATE, receiver);
        _days = _form.addIntegerInput(Message.requestDaysToAdvance());
    }

    @Override
    public final void execute() throws DialogException, FailedToAdvanceDateException{
        _form.parse();
        try {
            _receiver.advanceDate(_days.value());
        } catch (NegativeDaysToAdvanceException e) {
            throw new FailedToAdvanceDateException();
        }
    }
  
}
