package m19.app.works;

import m19.LibraryManager;
import m19.Work;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import m19.app.exceptions.NoSuchWorkException;
import m19.exceptions.NoSuchWorkExistsInMapException;

public class DoPerformSearch extends Command<LibraryManager> {

    Input<String> _term;

    public DoPerformSearch(LibraryManager m) {
        super(Label.PERFORM_SEARCH, m);
        _term = _form.addStringInput(Message.requestSearchTerm());
    }

    @Override
    public final void execute() throws DialogException {
        _form.parse();
        String r = "";
        try { 
            for (Work w : _receiver.searchWork(_term.value())) {
            r += w.showWork() + '\n';
        }
            _display.popup(r); 
        } catch (NoSuchWorkExistsInMapException e) {
            throw new NoSuchWorkException(0); //FIXME
    }
}
}

