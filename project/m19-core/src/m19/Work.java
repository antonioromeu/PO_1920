package m19;

import java.io.Serializable;

public abstract class Work implements Serializable {

    private static final long serialVersionUID = 20160823140L;

    private int _id;
    private int _copies;
    private int _copiesTaken;
    private int _price;
    private String _category;
    private String _title;

    public Work(int worksCounter, int copies, int price, String title, String category) {
        _id = worksCounter;
        _copies = copies;
        _price = price;
        _title = title;
        _category = category;
        _copiesTaken = 0;
    }

    public int getID() {
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

    public String showWork() {
        String r = getID() + " - " + getCopiesTaken() +  " de " + getCopies() + " - ";
        return r;
    }
}