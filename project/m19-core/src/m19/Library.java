package m19;

import m19.LibraryManager;
import m19.app.exceptions.UserRegistrationFailedException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.ImportFileException;
import m19.exceptions.MissingFileAssociationException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Library implements Serializable {

    private static final long serialVersionUID = 201901101348L;
    private int _worksCounter = 0;
    private int _usersCounter = 0;
    private RuleComposite _ruleComposite;
    private ArrayList<Work> _worksList;
    private ArrayList<User> _usersList;
    private int _day = 0;

    void importFile(String filename) throws IOException, ImportFileException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(":");
            try {
                registerFromFields(fields);
            } catch (FileNotFoundException e) {
                throw new ImportFileException(e);
            } catch (MissingFileAssociationException e) {
                throw new ImportFileException(e);
            } catch (IOException e) {
                throw new ImportFileException(e);
            }
        }
        br.close();
    }

    void registerFromFields(String[] fields) throws BadEntrySpecificationException {
        Pattern patWork = Pattern.compile("^(BOOK|DVD)");
        Pattern patUser = Pattern.compile("^(USER)");

        if (patUser.matcher(fields[0]).matches()) {
            registerUser(fields);
        } else if (patWork.matcher(fields[0]).matches()) {
            registerWork(fields);
        } else {
            throw new BadEntrySpecificationException(fields[0]);
        }
    }

    public void registerUser(String... fields) { //FIX ME with exceptions
        int id = getNewUserID();
        if (fields[0].equals("USER")) {
            User user = new User(id, fields[2], fields[3], fields[4]);
            addUser(user);
        } 
    }

    public void registerWork(String... fields) { //FIX ME with exceptions
        int id = getNewWorkID();
        if (fields[0].equals("BOOK")) {
            Book book = new Book(id, fields[2], fields[3], fields[4]);
            addWork(book);
        } else if (fields[0].equals("DVD")) {
            DVD dvd = new DVD(id, fields[2], fields[3], fields[4]);
            addWork(dvd);
        }
    } 

    public int getNewUserID() {
        return _usersCounter++;
    }

    public int getNewWorkID() {
        return _worksCounter++;
    }

    public void addUser(User user) {
        _usersList.add(user);
    } 

    public void addBook(Book book) {
        _worksList.add(book);
    }

    public void addDVD(DVD dvd) {
        _worksList.add(dvd);
    }

    public void advanceDate() {
        _day++;
    }

    public void displayDate() {
        System.out.println(_day);
    }

    public void showUser(User user) { //FIXME
        System.out.println(user.getID() + " - " + user.getName() + " - " + user.getEmail() + " - " + user.getBehaviour().getClass().getName() + " - " + user. )
    }
}