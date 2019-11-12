package m19;

import m19.LibraryManager;
//import m19.exceptions.UserRegistrationFailedException;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.ImportFileException;
import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.DuplicateUserException;
import m19.exceptions.NoSuchUserException;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.regex.Pattern;

public class Library implements Serializable {

    private static final long serialVersionUID = 201901101348L;
    private int _worksCounter = 0;
    private int _usersCounter = 0;
    private int _day = 0;
    private RuleComposite _ruleComposite;
    private Map<Integer, Work> _worksMap;
    private Map<Integer, User> _usersMap;
    private Map<Integer, Request> _requestsMap;

    public Library() {
        _worksMap = new HashMap<Integer, Work>();
        _usersMap = new HashMap<Integer, User>();
        _requestsMap = new HashMap<Integer, Request>();
    }

    void importFile(String filename) throws IOException, BadEntrySpecificationException, ImportFileException, DuplicateUserException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(":");
            try {  
                registerFromFields(fields);
            } catch (BadEntrySpecificationException e) {
                throw new ImportFileException();
            }
        }
        br.close();
    }

    void registerFromFields(String[] fields) throws BadEntrySpecificationException, DuplicateUserException {
        Pattern patWork = Pattern.compile("^(BOOK|DVD)");
        Pattern patUser = Pattern.compile("^(USER)");
        if (patUser.matcher(fields[0]).matches()) {
            try {
                registerUser(fields[1], fields[2]);
            } catch (DuplicateUserException e) {
                throw new BadEntrySpecificationException(fields[1]);
            }
        } else if (patWork.matcher(fields[0]).matches()) {
            registerWork(fields[1], fields[2],fields[3], fields[4], fields[5], fields[6]);
        } else {
            throw new BadEntrySpecificationException(fields[1]);
        }
    }

    public void registerWork(String... fields) {
        int id = getNewWorkID();
        if (_worksMap.containsKey(id))
            _worksMap.get(id).incrementCopies();
        else if (fields[0].equals("BOOK")) {
            Book book = new Book(id, fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]));
            addBook(book);
        } else if (fields[0].equals("DVD")) {
            DVD dvd = new DVD(id, fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]));
            addDVD(dvd);
        }
    }

    public void registerUser(String name, String mail) throws DuplicateUserException { 
        int id = getNewUserID();
        if (_usersMap.containsKey(id))
            throw new DuplicateUserException(id, name);
        User user = new User(id, name, mail);
        addUser(user); 
    }

    public RuleComposite getRuleComposite() {
        return _ruleComposite;
    }

    public int getNewUserID() {
        return _usersCounter++;
    }

    public int getNewWorkID() {
        return _worksCounter++;
    }

    public User getUser(int id) throws NoSuchUserException {
        return _usersMap.get(id);
    }

    public void addUser(User user) {
        _usersMap.put(user.getID(), user);
    } 

    public void addBook(Book book) {
        _worksMap.put(book.getID(), book);
    }

    public void addDVD(DVD dvd) {
        _worksMap.put(dvd.getID(), dvd);
    }

    public void advanceDate() {
        _day++;
    }

    public void displayDate() {
        System.out.println(_day);
    }

    public String showUser(int id) throws NoSuchUserException {
        User user = _usersMap.get(id);
        if (user == null) throw new NoSuchUserException();
        String r = user.getID() + " - " + user.getName() + " - " + user.getEmail() + " - " + user.getBehaviour().getClass().getName() + " - " + user.toStringActive();
        if (user.getFine() != 0)
            r = r + " - EUR " + user.getFine();
        return r;
    }

    public boolean canRequest(Request request) {
        for (Rule rule : _ruleComposite.getRulesList()) {
            if (!rule.ok(request, _requestsMap)) return false;
        }
        return true;
    }

    public void requestWork(int userID, int workID) {
        User user = _usersMap.get(userID);
        Work work = _worksMap.get(workID);
        Request r = new Request(user, work, _day);
        if (canRequest(r))
            _requestsMap.put(r.getID(), r);
    }

    public Map<Integer, Request> getRequestsMap() {
        return _requestsMap;
    }
}