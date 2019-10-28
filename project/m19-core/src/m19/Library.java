package m19;

import m19.LibraryManager;
import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.UserRegistrationException;
//import m19.exceptions.BadEntryException;
//import m19.exceptions.BadTimeSpecificationException;
//import m19.exceptions.ImportFileException;

import java.io.IOException;
import java.io.Serializable;

public class Library implements Serializable {

    private static final long serialVersionUID = 201901101348L;
    private int _worksCounter = 0;
    private int _usersCounter = 0;
    private RuleComposite _ruleComposite;
    private ArrayList<Work> _worksList;
    private ArrayList<User> _usersList;

    void importFile(String filename) throws BadEntrySpecificationException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String line;
        while ((line = br.readLine()) != null) {
            try {
                String[] worksParse = line.split(":", 7);
                if (worksParse[0].equals("DVD")) {
                    DVD dvd = new DVD(worksParse[1], worksParse[2], worksParse[3], worksParse[4], worksParse[5], worksParse[6]);
                    _worksList.add(dvd);
                }
                else {
                    Book book = new Book(worksParse[1], worksParse[2], worksParse[3], worksParse[4], worksParse[5], worksParse[6]);
                    _worksList.add(book);
                }
            }
            try {
                String[] worksParse = line.split(":", 3);
                User user = new User(worksParse[1], worksParse[2]);
                _usersList.add(user);
            } catch(BadEntrySpecificationException ex) {}
        }
    }

    public void registerUser(int usersCounter, String name, String email) { //FIX ME with exceptions 
        User _user = new User(usersCounter, name, email);
        _usersList.add(_user);
    }

    public void addBook(int worksCounter, int price, Category category, String title) {
        
    }


}