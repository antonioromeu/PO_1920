package m19;

import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.ImportFileException;
import m19.exceptions.NoSuchUserExistsInMapException;
import m19.exceptions.NoSuchWorkExistsInMapException;
import m19.exceptions.FailedToPayFineException;
import m19.exceptions.FailedToRegisterUserException;
import m19.exceptions.RequestFailedException;
import m19.exceptions.ReturnFailedException;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.regex.Pattern;

import java.io.IOException;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
  * Class that represents the library as a whole.
  */

public class Library implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201901101348L;

    /** Number of existing works in the library. */
    private int _worksCounter = 0;

    /** Number of existing users in the library. */
    private int _usersCounter = 0;

    /** Date (in days). */
    private int _day = 0;

    /** Library rule set. */
    private RuleComposite _ruleComposite;

    /** Map of existing works. */
    private Map<Integer, Work> _worksMap;

    /** Map of existing users. */
    private Map<Integer, User> _usersMap;

    /** Map of current requests. */
    private Map<List<Integer>, Request> _requestsMap;

    /** Boolean that specifies whether the library is saved or not. */
    private boolean _saved = false;

    public Library() {
        _worksMap = new HashMap<Integer, Work>();
        _usersMap = new HashMap<Integer, User>();
        _requestsMap = new HashMap<List<Integer>, Request>();
        _ruleComposite = new RuleComposite();
    }

    /**
    * Read the text input file at the beginning of the program and populates the
    * instances of the various possible types (books, DVDs, users).
    * 
    * @param filename
    *          name of the file to load
    * @throws BadEntrySpecificationException
    * @throws ImportFileException
    */
    void importFile(String filename) throws BadEntrySpecificationException, ImportFileException, FailedToRegisterUserException {
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

    /**
    * Registers the users and works from the input string field.
    * 
    * @param fields
    *          string input
    * @throws BadEntrySpecificationException
    */
    void registerFromFields(String[] fields) throws BadEntrySpecificationException, FailedToRegisterUserException {
        Pattern patWork = Pattern.compile("^(BOOK|DVD)");
        Pattern patUser = Pattern.compile("^(USER)");
        if (patUser.matcher(fields[0]).matches())
            registerUser(fields[1], fields[2]);
        else if (patWork.matcher(fields[0]).matches())
            registerWork(fields);
        else
            throw new BadEntrySpecificationException(fields[1]);
    }

    /**
    * Registers new work in the library.
    * 
    * @param fields
    *          string input
    */
    public void registerWork(String... fields) {
        int id = getNewWorkId();
        if (fields[0].equals("BOOK")) {
            Book book = new Book(id, fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]));
            addBook(book);
        } else if (fields[0].equals("DVD")) {
            DVD dvd = new DVD(id, fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]));
            addDVD(dvd);
        }
    }

    /**
    * Registers new user in the library.
    * 
    * @param name
    *          users's name
    * @param mail
    *          users's email
    * @return id
    */
    public int registerUser(String name, String email) throws FailedToRegisterUserException { 
        if (name.equals("") || email.equals(""))
            throw new FailedToRegisterUserException(name, email);
        int id = getNewUserId();
        User user = new User(id, name, email);
        addUser(user);
        return id;
    }

    /**
    * Returns the library status.
    * 
    * @return _saved
    */
    public boolean getSaveStatus() {
        return _saved;
    }
    
    /**
    * Sets the library status.
    * 
    * @param value
    *          boolean value
    */
    public void setSaveStatus(boolean value) {
        _saved = value;
    }

    /**
    * Returns a new user ID.
    * 
    * @return _usersCounter
    */
    public int getNewUserId() {
        return _usersCounter++;
    }

    /**
    * Returns a new work ID.
    * 
    * @return _worksCounter
    */
    public int getNewWorkId() {
        return _worksCounter++;
    }

    /**
    * Returns the workers' map.
    * 
    * @return _worksMap
    */
    public Map<Integer, Work> getAllWorks() {
        return _worksMap;
    }

    /**
    * Adds new user to the library.
    */
    public void addUser(User user) {
        _usersMap.put(user.getId(), user);
    } 

    /**
    * Adds new book to the library.
    */
    public void addBook(Book book) {
        _worksMap.put(book.getId(), book);
    }

    /**
    * Adds new dvd to the library.
    */
    public void addDVD(DVD dvd) {
        _worksMap.put(dvd.getId(), dvd);
    }

    /**
    * Advances library date.
    *
    * @param days
    *        days to advance
    */
    public void advanceDate(int days) {
        if (days > 0) {
            updateRequestsFine(days);
            _day += days;
            updateUsersBehaviours();
            updateUsersActiveness();
        }
    }

    /**
    * Returns library date.
    *
    * @return _day
    */
    public int getDate() {
        return _day;
    }

    /**
    * Updates the users' behaviours when advancing the date.
    */
    public void updateUsersBehaviours() {
        for (User user : _usersMap.values()) {
            user.checkLast3();
            user.checkLast5();
        }
    }

    /**
    * Updates the fines associated with every request.
    *
    * @param days
    *        days advanced
    */
    public void updateRequestsFine(int days) {
        for (Request request : _requestsMap.values()) {
            if ((days + getDate()) > request.getReturnDay()) {
                request.setLateness(true);
                request.incrementFine((days + getDate()) - request.getReturnDay());
            }
        }
    }

    /**
    * Updates the activeness of every user.
    */
    public void updateUsersActiveness() {
        for (Request request : _requestsMap.values())
            if (request.getReturnDay() < getDate()) {
                request.getUser().setActiveness(false);
            }
    }

    /**
    * Returns library date.
    *
    * @return _day
    */
    public void payFine(int userID) throws FailedToPayFineException, NoSuchUserExistsInMapException {
        User user =  getUser(userID);
        if (user.isActive())
            throw new FailedToPayFineException();
        else {
            user.payFine(); 
            if (!user.hasLateRequests(_requestsMap, getDate()))
                user.setActiveness(true);
        }
    }

    /**
    * Returns one user.
    * 
    * @param id
    *          user id
    * @throws NoSuchUserExistsInMapException
    *
    * @return user
    */
    public User getUser(int id) throws NoSuchUserExistsInMapException {
        User user = _usersMap.get(id);
        if (user == null) 
            throw new NoSuchUserExistsInMapException();
        return user;
    }

    /**
    * Returns list of users.
    *
    * @return usersList
    */
    public List<User> getUsers() {
        List<User> usersList = new LinkedList<User>();
        usersList.addAll(_usersMap.values());
        Collections.sort(usersList);
        return usersList;
    }

    /**
    * Returns work.
    * 
    * @param id
    *          work id
    * @throws NoSuchWorkExistsInMapException
    *
    * @return work
    */
    public Work getWork(int id) throws NoSuchWorkExistsInMapException {
        Work work = _worksMap.get(id);
        if (work == null) 
            throw new NoSuchWorkExistsInMapException();
        return work;
    }

    /**
    * Returns list of works.
    *
    * @return worksList
    */
    public List<Work> getWorks() {
        List<Work> worksList = new LinkedList<Work>();
        worksList.addAll(_worksMap.values());
        return worksList;
    }

    /**
    * Returns a request.
    *
    * @param userId
    * 
    * @param workId
    *
    * @return request
    */
    public Request getRequest(int userId, int workId) {
        List<Integer> keys = new ArrayList<Integer>();
        keys.add(userId);
        keys.add(workId);
        return _requestsMap.get(keys);
    }

    /**
    * Checks if a request is legal.
    *
    * @param request
    *        request to be checked
    * @return boolean
    */
    public boolean canRequest(Request request) throws RequestFailedException {
        int i = 1;
        for (Rule rule : _ruleComposite.getRulesList()) {
            if (!rule.ok(request, _requestsMap))
                throw new RequestFailedException(i);
            i++;
        }
        return true;
    }

    /**
    * Creates a request.
    *
    * @param userID
    *        id of the user that creates the request
    *
    * @param workID
    *        id of the work to be requested
    *
    * @throws NoSuchUserExistsInMapException
    * @throws NoSuchWorkExistsInMapException
    */
    public void requestWork(int userId, int workId) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException, RequestFailedException {
        User user = _usersMap.get(userId);
        if (user == null) 
            throw new NoSuchUserExistsInMapException();
        Work work = _worksMap.get(workId);
        if (work == null) 
            throw new NoSuchWorkExistsInMapException();
        Request r = new Request(user, work, _day);
        List<Integer> keys = new ArrayList<Integer>();
        keys.add(user.getId());
        keys.add(work.getId());
        try {
            if (canRequest(r)) {
                user.incrementWorks();
                work.incrementCopiesTaken();
                _requestsMap.put(keys, r);
                checkWantedWorks(workId, "Request");
            }
        } catch (RequestFailedException e) {
            if (e.getIndex() == 3)
                user.addWantedWork(work);
            throw new RequestFailedException(e.getIndex());
        }
    }

    /**
    * Returns work and takes care of the consequences.
    *
    * @param userId
    *        id of the user that creates the request
    *
    * @param workId
    *        id of the work to be requested
    *
    * @throws NoSuchUserExistsInMapException
    * @throws NoSuchWorkExistsInMapException
    * @throws ReturnFailedException
    */
    public void returnWork(int userId, int workId) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException, ReturnFailedException {
        User user = _usersMap.get(userId);
        if (user == null) 
            throw new NoSuchUserExistsInMapException();
        Work work = _worksMap.get(workId);
        if (work == null) 
            throw new NoSuchWorkExistsInMapException();
        List<Integer> keys = new ArrayList<Integer>();
        keys.add(user.getId());
        keys.add(work.getId());
        Request request = _requestsMap.get(keys);
        if (request != null) {
            if (request.getReturnDay() >= getDate())
                user.getBehaviour().addBehaviourToList(1);
            else {
                user.setFine(user.getFine() + request.getFine());
                user.getBehaviour().addBehaviourToList(0);
            }
            user.decrementWorks();
            work.decrementCopiesTaken();
            request.setLateness(false);
            _requestsMap.remove(keys, request);
            checkWantedWorks(workId, "Return");
            updateUsersBehaviours();
        }
        else
            throw new ReturnFailedException();
    }

    /**
    * Returns the requests' map.
    *
    * @return _requestsMap       
    */
    public Map<List<Integer>, Request> getRequestsMap() {
        return _requestsMap;
    }

    /**
    * Returns a list with all the works with the given term.
    *
    * @param term
    *        id of the user that creates the request
    *
    * @throws NoSuchWorkExistsInMapException
    */
    public List<Work> searchWork(String term) throws NoSuchWorkExistsInMapException {
        List<Integer> keys = new LinkedList<Integer>(_worksMap.keySet());
        List<Work> resultsList = new LinkedList<Work>();
        Collections.sort(keys);
        for (Integer key : keys)
            if (getWork(key).containsTerm(term))
                resultsList.add(getWork(key));
        return resultsList;
    }

    /**
    * Notifies user according to the flag.
    *
    * @param userId
    *
    * @param workdId
    *
    * @param flag
    *        "Request" if a notification request is to be added or "Return" if a notification return is to be added.
    *
    * @throws NoSuchUserExistsInMapException
    * @throws NoSuchWorkExistsInMapException
    */
    public void notifyUser(int userId, int workId, String flag) throws NoSuchUserExistsInMapException, NoSuchWorkExistsInMapException {
        try {
            User user = getUser(userId);
            if (flag.equals("Request"))
                user.registerNotification(new NotificationRequest(user, getWork(workId)));
            else if (flag.equals("Return"))
                user.registerNotification(new NotificationReturn(user, getWork(workId)));
        } catch (NoSuchUserExistsInMapException e) {
            throw new NoSuchUserExistsInMapException();
        } catch (NoSuchWorkExistsInMapException e) {
            throw new NoSuchWorkExistsInMapException();
        }
    }

    /**
    * Checks the users' wanted works and adds notifications accordingly.
    *
    * @param workId
    *
    * @param flag
    *        "Request" if a notification request is to be added or "Return" if a notification return is to be added.
    */
    public void checkWantedWorks(int workId, String flag) {
        for (User user : _usersMap.values())
            for (Work work : user.getWantedWorks()) {
                if (work.getId() == workId && flag.equals("Request"))
                    user.registerNotification(new NotificationRequest(user, work));
                else if (work.getId() == workId && flag.equals("Return"))
                    user.registerNotification(new NotificationReturn(user, work));
            }
    }
}