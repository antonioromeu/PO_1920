package m19;

public class Book extends Work {

    private String _author;
    private String _ISBN;

    public Book(int worksCounter, int copies, int price, String title, String author, String ISBN) {
        super(worksCounter, copies, price, title);
        _author = author;
        _ISBN = ISBN;
    }
}