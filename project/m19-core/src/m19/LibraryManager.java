package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import m19.exceptions.NoSuchUserExistsInMapException;
import m19.exceptions.NoSuchWorkExistsInMapException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.List;

public class LibraryManager {
    
    private Library _library = new Library();
    private String _filename = "";
    
    public void save() throws MissingFileAssociationException, IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(_filename));
            out.writeObject(_library);
            out.close();
        } catch (FileNotFoundException e) {
            throw new MissingFileAssociationException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAs(String filename) throws MissingFileAssociationException, IOException {
        _filename = filename;
        save();
    }

    public void load(String filename) throws FailedToOpenFileException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            _library = (Library) in.readObject();  
            _filename = filename;
            in.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new FailedToOpenFileException(filename);
        } 
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

    public User getUser(int id) throws NoSuchUserExistsInMapException {
        return _library.getUser(id);
    }

    public List<User> getUsers() {
        return _library.getUsers();
    }

    public Work getWork(int id) throws NoSuchWorkExistsInMapException {
        return _library.getWork(id);
    }

    public List<Work> getWorks() {
        return _library.getWorks();
    }
}