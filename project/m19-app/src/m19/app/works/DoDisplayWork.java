package m19.app.works;

import m19.LibraryManager;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import m19.app.exceptions.NoSuchWorkException;
import m19.exceptions.NoSuchWorkExistsInMapException;



public class DoDisplayWork extends Command<LibraryManager> {

    Input<Integer> _id;

    public DoDisplayWork(LibraryManager receiver) {
        super(Label.SHOW_WORK, receiver);
        _id = _form.addIntegerInput(Message.requestWorkId());
    }

    @Override
    public final void execute() throws DialogException {
        _form.parse();
        try {
            _display.popup(_receiver.getWork(_id.value()).showWork());
        } catch (NoSuchWorkExistsInMapException e) {
            throw new NoSuchWorkException(_id.value());
        }
    }
  
}
