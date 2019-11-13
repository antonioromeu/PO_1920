package m19.app.works;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoDisplayWorks extends Command<LibraryManager> {

    public DoDisplayWorks(LibraryManager receiver) {
        super(Label.SHOW_WORKS, receiver);
    }

    @Override
    public final void execute() {
        _display.popup(_receiver.showWorks());
    }
}
