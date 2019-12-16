package m19;

/**
  * Class that represents the concept of book.
  */

public class Book extends Work {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 20160823122L;

    /** Author. */
    private String _author;

    /** ISBN. */
    private String _ISBN;

    public Book(int worksCounter, String title, String author, int price, String category, String ISBN, int copies) {
        super(worksCounter, copies, price, title, category);
        _author = author;
        _ISBN = ISBN;
    }

    public String getISBN() {
        return _ISBN;
    }

    public String getAuthor() {
        return _author;
    }
    
    @Override
    public boolean containsTerm(String term) {
        return getAuthor().toLowerCase().contains(term.toLowerCase()) || getTitle().toLowerCase().contains(term.toLowerCase());
    }

    /** Represents book as a string. */
    @Override
    public String showWork() {
        String r = super.showWork() + " Livro - " + getTitle() + " - " + getPrice() + " - " + getCategory() + " - " + getAuthor() + " - " + getISBN();  
        return r;  
    }
}
