package m19;

import m19.LibraryManager;
import m19.app.exceptions.UserRegistrationFailedException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.ImportFileException;
import m19.exceptions.MissingFileAssociationException;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Library implements Serializable {

    private static final long serialVersionUID = 201901101348L;
    private int _worksCounter = 0;
    private int _usersCounter = 0;
    private RuleComposite _ruleComposite;
    private Map<Integer, Work> _worksMap;
    private Map<Integer, User> _usersMap;
    private Map<Request> _requestsMap; //should we do treemaps? also, idea: request id = work id + user id !!
    private int _day = 0;

    public Library() {
        _worksMap = new TreeMap<Integer, Work>();
        _usersMap = new TreeMap<Integer, User>();
        _requestsMap = new TreeMap<Integer, Request>();
    }

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
            addBook(book);
        } else if (fields[0].equals("DVD")) {
            DVD dvd = new DVD(id, fields[2], fields[3], fields[4]);
            addDVD(dvd);
        }
    } 

    public int getNewUserID() {
        return _usersCounter++;
    }

    public int getNewWorkID() {
        return _worksCounter++;
    }

    public void addUser(User user) {
        _usersMap.add(user);
    } 

    public void addBook(Book book) {
        _worksMap.add(book);
    }

    public void addDVD(DVD dvd) {
        _worksMap.add(dvd);
    }

    public void advanceDate() {
        _day++;
    }

    public void displayDate() {
        System.out.println(_day);
    }

    public String showUser(int id) {
        User user = _usersMap.get(id);
        String r = user.getID() + " - " + user.getName() + " - " + user.getEmail() + " - " + user.getBehaviour().getClass().getName() + " - " + user.toStringActive();
        if (user.getFine())
            r = r + " - EUR " + user.getFine();
        return r;
    }

    public boolean canRequest(Request request) {
        return ok(request);
    }

    public Request request(User user, Work work) {
        Request r = new Request(user, work, _day);
        if (canRequest(r))
            _requestsMap.add(r);
    }

    public ArrayList<Request> getRequestsList() {
        return _requestsMap;
    }
 }