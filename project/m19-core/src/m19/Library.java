package m19;

import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.ImportFileException;
import m19.exceptions.DuplicateUserException;
import m19.exceptions.NoSuchUserExistsInMapException;
import m19.exceptions.NoSuchWorkExistsInMapException;
import m19.exceptions.NegativeDaysToAdvanceException;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Library implements Serializable {

    private static final long serialVersionUID = 201901101348L;
    private int _worksCounter = 1;
    private int _usersCounter = 1;
    private int _day = 0;
    private RuleComposite _ruleComposite;
    private Map<Integer, Work> _worksMap;
    private Map<Integer, User> _usersMap;
    private Map<Integer, Request> _requestsMap;

    public Library() {
        _worksMap = new HashMap<Integer, Work>();
        _usersMap = new HashMap<Integer, User>();
        _requestsMap = new HashMap<Integer, Request>();
        //_ruleComposite = new RuleComposite();
    }

    void importFile(String filename) throws BadEntrySpecificationException, ImportFileException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(":");
                registerFromFields(fields);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new ImportFileException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void registerFromFields(String[] fields) throws BadEntrySpecificationException {
        Pattern patWork = Pattern.compile("^(BOOK|DVD)");
        Pattern patUser = Pattern.compile("^(USER)");
        if (patUser.matcher(fields[0]).matches()) {
            try {
                registerUser(fields[1], fields[2]);
            } catch (DuplicateUserException e) {
                throw new BadEntrySpecificationException(fields[1]);
            }
        }
        else if (patWork.matcher(fields[0]).matches()) {
            registerWork(fields);
        }
        else
            throw new BadEntrySpecificationException(fields[1]);
    }

    public void registerWork(String... fields) {
        int id = getNewWorkID();
        if (fields[0].equals("BOOK")) {
            Book book = new Book(id, fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]));
            addBook(book);
        } else if (fields[0].equals("DVD")) {
            DVD dvd = new DVD(id, fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]));
            addDVD(dvd);
        }
    }

    public int registerUser(String name, String mail) throws DuplicateUserException { 
        int id = getNewUserID();
        if (_usersMap.containsKey(id))
            throw new DuplicateUserException(id, name);
        User user = new User(id, name, mail);
        addUser(user); 
        return id;
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

    public User getUser(int id) throws NoSuchUserExistsInMapException {
        User u = _usersMap.get(id);
        if (u == null) 
            throw new NoSuchUserExistsInMapException();
        return _usersMap.get(id);
    }

    public Map<Integer, User> getAllUsers() {
        return _usersMap;
    }

    public Work getWork(int id) {
        Work w = _worksMap.get(id);
        if (w != null)
            return _worksMap.get(id);
        return null;
    }

    public Map<Integer, Work> getAllWorks() {
        return _worksMap;
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

    public void advanceDate(int days) throws NegativeDaysToAdvanceException {
        if (days < 0) throw new NegativeDaysToAdvanceException(); 
        _day += days;
    }

    public int getDate() {
        return _day;
    }

    public String showUser(int id) throws NoSuchUserExistsInMapException {
        User user = _usersMap.get(id);
        if (user == null) 
            throw new NoSuchUserExistsInMapException();
        return user.showUser();
    }

    public String showUsers() {
        String r = "";
        for (User u : _usersMap.values()) {
            r = r + u.showUser() + "\n";
        }
        return r;
    }

    public String showWork(int id) throws NoSuchWorkExistsInMapException {
        Work work = _worksMap.get(id);
        if (work == null) 
            throw new NoSuchWorkExistsInMapException();
        return work.showWork();
    }

    public String showWorks() {
        String r = "";
        for (Work w : _worksMap.values()) {
            r = r + w.showWork() + "\n";
        }
        return r;
    }

    public boolean canRequest(Request request) {
        for (Rule rule : _ruleComposite.getRulesList()) {
            if (!rule.ok(request, _requestsMap)) return false;
        }
        return true;
    }

    public void requestWork(int userID, int workID) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException {
        User user = _usersMap.get(userID);
        if (user == null) 
            throw new NoSuchUserExistsInMapException();
        Work work = _worksMap.get(workID);
        if (work == null) 
            throw new NoSuchWorkExistsInMapException();
        Request r = new Request(user, work, _day);
        if (canRequest(r))
            _requestsMap.put(r.getID(), r);
    }

    public Map<Integer, Request> getRequestsMap() {
        return _requestsMap;
    }
}