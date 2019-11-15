package m19.app.works;

import m19.LibraryManager;
import m19.Work;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;

public class DoDisplayWorks extends Command<LibraryManager> {

    public DoDisplayWorks(LibraryManager receiver) {
        super(Label.SHOW_WORKS, receiver);
    }

    @Override
    public final void execute() {
        String r = "";
        for (Work w : _receiver.getWorks()) {
            r += w.showWork() + '\n';
        }
        _display.popup(r);
    }
}