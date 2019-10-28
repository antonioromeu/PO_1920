package m19;

import m19.LibraryManager;
import m19.exceptions.BadEntrySpecificationException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

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
            String[] worksParse = line.split(":", 7);
            if (worksParse[0].equals("DVD")) {
                DVD dvd = new DVD(Integer.parseInt(worksParse[1]), Integer.parseInt(worksParse[2]), Integer.parseInt(worksParse[3]), worksParse[4], worksParse[5], worksParse[6]);
                _worksList.add(dvd);
            }
            else if (worksParse[0].equals("Book")) {
                Book book = new Book(Integer.parseInt(worksParse[1]), Integer.parseInt(worksParse[2]), Integer.parseInt(worksParse[3]), worksParse[4], worksParse[5], worksParse[6]);
                _worksList.add(book);
            }
            else {
                String[] userParse = line.split(":", 3);
                User user = new User(_usersCounter, userParse[1], userParse[2]);
                _usersList.add(user);
            }
        }
    }

    public void registerUser(int usersCounter, String name, String email) { //FIX ME with exceptions 
        User _user = new User(usersCounter, name, email);
        _usersList.add(_user);
    }

    public void addBook(int worksCounter, int price, Category category, String title) {
        
    }


}