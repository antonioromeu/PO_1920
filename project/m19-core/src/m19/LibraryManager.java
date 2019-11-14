package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.NegativeDaysToAdvanceException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.ImportFileException;
import m19.exceptions.NoSuchUserExistsInMapException;
import m19.exceptions.NoSuchWorkExistsInMapException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LibraryManager {
    
    private Library _library = new Library();
    private String _filename = "";
    
    public void save(Library library, String file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(library);
        out.close();
    }

    public void saveAs(String filename) throws IOException {
        _filename = filename;
        save(_library, _filename);
    }

    public Library load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        _library = (Library) in.readObject();  
        in.close();
        return _library;
    }
    
    public void importFile(String datafile) throws ImportFileException {
        try {
            _library.importFile(datafile);
        } catch (BadEntrySpecificationException | ImportFileException e) {
            throw new ImportFileException(datafile);
        }
    }

    public String getFileName() {
        return _filename;
    }

    void registerFromFields(String[] fields) throws BadEntrySpecificationException {
        _library.registerFromFields(fields);
    }

    public int registerUser(String name, String mail) {
        return _library.registerUser(name, mail);
    }

    public void advanceDate(int days) {
        _library.advanceDate(days);
    }

    public int getDate() {
        return _library.getDate();
    }

    public void requestWork(int userID, int workID) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException {
        _library.requestWork(userID, workID);
    }

    public String showUser(int id) throws NoSuchUserExistsInMapException {
        return _library.showUser(id);
    }

    public String showUsers() {
        return _library.showUsers();
    }

    public String showWork(int id) throws NoSuchWorkExistsInMapException {
        return _library.showWork(id);
    }

    public String showWorks() {
        return _library.showWorks();
    }
}