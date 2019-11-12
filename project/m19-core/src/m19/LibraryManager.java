package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.DuplicateUserException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import m19.exceptions.NoSuchUserException;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LibraryManager {
    
    private Library _library = new Library();
    private String _filename;
    private boolean _saved = false;
    
    public void save(Library library, String file) throws MissingFileAssociationException, IOException {
        if (!_saved) {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(library);
            out.close();
            _saved = true;
        }
    }

    public void saveAs(String filename) throws MissingFileAssociationException, IOException {
        _filename = filename;
        save(_library, _filename);
    }

    public void load(String filename) throws FailedToOpenFileException, IOException, ClassNotFoundException {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            _library = (Library) in.readObject();  
            in.close();
    }
    
    public void importFile(String datafile) throws ImportFileException {
        try {
            _library.importFile(datafile);
        } catch (IOException | BadEntrySpecificationException | DuplicateUserException e) {
            throw new ImportFileException();
        }

    }

    void registerFromFields(String[] fields) throws BadEntrySpecificationException, DuplicateUserException {
        _library.registerFromFields(fields);
    }

    public void registerUser(String name, String mail) throws DuplicateUserException {
        _library.registerUser(name, mail);
    }

    public void advanceDate() {
        _library.advanceDate();
    }

    public void displayDate() {
        _library.displayDate();
    }

    public void requestWork(int userID, int workID) {
        _library.requestWork(userID, workID);
    }

    public User getUser(int id) throws NoSuchUserException {
        try {
            return _library.getUser(id);
        } catch (NoSuchUserException e) {
            throw new NoSuchUserException();
        }
    }
}