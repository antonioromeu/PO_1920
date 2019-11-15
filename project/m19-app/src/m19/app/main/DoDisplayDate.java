package m19.app.main;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoDisplayDate extends Command<LibraryManager> {

    public DoDisplayDate(LibraryManager receiver) {
        super(Label.DISPLAY_DATE, receiver);
    }

    @Override
    public final void execute() {
        _display.popup(Message.currentDate(_receiver.getDate()));
    }
  
}
