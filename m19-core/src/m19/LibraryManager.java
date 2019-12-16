package m19;

import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import m19.exceptions.NoSuchUserExistsInMapException;
import m19.exceptions.NoSuchWorkExistsInMapException;
import m19.exceptions.FailedToPayFineException;
import m19.exceptions.FailedToRegisterUserException;
import m19.exceptions.RequestFailedException;
import m19.exceptions.ReturnFailedException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.List;

/**
  * The façade class.
  */

public class LibraryManager {
    
    private Library _library = new Library();
    private String _filename = "";
    

    /**
    * @throws MissingFileAssociationException
    * @throws IOException
    */
    public void save() throws MissingFileAssociationException, IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(_filename));
            _library.setSaveStatus(true);
            out.writeObject(_library);
            out.close();
        } catch (FileNotFoundException e) {
            throw new MissingFileAssociationException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * @param filename
    * @throws MissingFileAssociationException
    * @throws IOException
    */
    public void saveAs(String filename) throws MissingFileAssociationException, IOException {
        _filename = filename;
        save();
    }

    /**
    * @param filename
    * @throws FailedToOpenFileException
    */
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

    public boolean isSaved() {
        return _library.getSaveStatus();
    }
    
    /**
    * @param datafile
    * @throws ImportFileException
    */
    public void importFile(String datafile) throws ImportFileException {
        try {
            _library.importFile(datafile);
        } catch (FailedToRegisterUserException | BadEntrySpecificationException | ImportFileException e) {
            throw new ImportFileException(datafile);
        }
    }

    /**
    * Returns the library's associate file name.
    * 
    * @return _filename
    */
    public String getFileName() {
        return _filename;
    }

    /**
    * @param fields
    * @throws BadEntrySpecificationException
    */
    void registerFromFields(String[] fields) throws BadEntrySpecificationException, FailedToRegisterUserException {
        _library.registerFromFields(fields);
    }

    /**
    * @param name
    * @param mail 
    */
    public int registerUser(String name, String mail) throws FailedToRegisterUserException {
        return _library.registerUser(name, mail);
    }

    /**
    * @param days
    */
    public void advanceDate(int days) {
        _library.advanceDate(days);
    }

    public int getDate() {
        return _library.getDate();
    }

    /**
    * @param userID
    * @param workID
    * @throws NoSuchUserExistsInMapException
    * @throws NoSuchWorkExistsInMapException
    */
    public void requestWork(int userID, int workID) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException, RequestFailedException {
        _library.requestWork(userID, workID);
    }

    public void returnWork(int userID, int workID) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException, ReturnFailedException {
        _library.returnWork(userID, workID);
    }

    /**
    * @param id
    * @throws NoSuchUserExistsInMapException
    */
    public User getUser(int id) throws NoSuchUserExistsInMapException {
        return _library.getUser(id);
    }

    public List<User> getUsers() {
        return _library.getUsers();
    }

    /**
    * @param id
    * @throws NoSuchWorkExistsInMapException
    */
    public Work getWork(int id) throws NoSuchWorkExistsInMapException {
        return _library.getWork(id);
    }

    public List<Work> getWorks() {
        return _library.getWorks();
    }

    public Request getRequest(int userId, int workId) {
        return _library.getRequest(userId, workId);
    }

    /**
    * @param userID
    * @throws FailedToPayFineException
    */
    public void payFine(int userID) throws FailedToPayFineException, NoSuchUserExistsInMapException {
        _library.payFine(userID);
    }

    public List<Work> searchWork(String term) throws NoSuchWorkExistsInMapException {
        return _library.searchWork(term);
    }

    public void notifyUser(int userId, int workId, String flag) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException {
        _library.notifyUser(userId, workId, flag);
    }
}