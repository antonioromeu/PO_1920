package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import java.io.IOException;
import java.io.Serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class LibraryManager {
    
    private Library _library = new Library();
    private String _filename;
    
    public void save(Library library, String file) throws MissingFileAssociationException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(library);
        out.close();
    }

    public void saveAs(String filename) throws MissingFileAssociationException, IOException {
        _filename = filename;
        save(_library, filename);
    }

    public void load(String filename) throws FailedToOpenFileException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Library library = (Library) in.readObject();
        in.close();
    }
    
    public void importFile(String datafile) throws ImportFileException {
        try {
            _library.importFile(datafile);
        } catch (BadEntrySpecificationException e) {
            throw new ImportFileException(e);
        } catch (IOException e) {
            throw new ImportFileException(e);
        }

    }

    void registerFromFields(String[] fields) throws BadEntrySpecificationException {
        _library.registerFromFields(fields);
    }

    public void registerUser(String... fields) {
        _library.registerUser(fields);
    }

    public void registerWork(String... fields) {
        _library.registerWork(fields);
    }

    /*public void addUser(User user) {
        _library.addUser(user);
    }

    public void addBook(Book book) {
        _library.addBook(book);
    }

    public void addDVD(DVD dvd) {
        _library.addDVD(dvd); 
    } isto existe? */

    public void advanceDate() {
        _library.advanceDate();
    }

    public void displayDate() {
        _library.displayDate();
    }

    public void showUser(int id) {
        _library.showUser(id);
    }

    public void request(User user, Work work) {
        _library.request(user, work);
    }

    public ArrayList<Request> getRequestsList() {
        _library.getRequestsList();
    }
    


}
