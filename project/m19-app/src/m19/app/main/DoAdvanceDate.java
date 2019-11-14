package m19.app.main;

import m19.LibraryManager;
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
    public final void execute() throws DialogException {
        _form.parse();
            _receiver.advanceDate(_days.value());
    }
  
}
