package m19;

import java.io.Serializable;
import java.lang.Comparable;

/**
  * Class that represents the concept of work.
  */

public abstract class Work implements Serializable, Comparable<Work> {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 20160823140L;

    /** ID. */
    private int _id;
    
     /** Copies. */
    private int _copies;

     /** Copies borrowed by an user. */
    private int _copiesTaken;

     /** Price. */
    private int _price;

     /** Category. */
    private String _category;

     /** Title. */
    private String _title;

    public Work(int worksCounter, int copies, int price, String title, String category) {
        _id = worksCounter;
        _copies = copies;
        _price = price;
        _title = title;
        if (category.equals("FICTION"))
            _category = "Ficção";
        else if (category.equals("SCITECH")) 
            _category = "Técnica e Científica";
        else
            _category = "Referência";
        _copiesTaken = 0;
    }

    public int compareTo(Work work) {
        if (!this.getTitle().equals(work.getTitle())) 
            return (this.getTitle().compareTo(work.getTitle()));
        else if (this.getId() < work.getId()) return -1;
        else return 1;
    }

    public int getId() {
        return _id;
    }

    public int getCopies() {
        return _copies;
    }

    public int getCopiesTaken() {
        return _copiesTaken;
    }

    public int getPrice() {
        return _price;
    }

    public String getTitle() {
        return _title;
    }

    public String getCategory() {
        return _category;
    }

    public void incrementCopies() {
        _copies++;
    }

    public void decrementCopies() {
        _copies--;
    }

    public void incrementCopiesTaken() {
        _copiesTaken++;
    }

    public void decrementCopiesTaken() {
        _copiesTaken--;
    }

    /** Represents work as a string. */
    public String showWork() {
        String r = getId() + " - " + (getCopies() - getCopiesTaken()) +  " de " + getCopies() + " -";
        return r;
    }

    public abstract boolean containsTerm(String term);
}
