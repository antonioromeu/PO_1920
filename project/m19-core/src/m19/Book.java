package m19;

public class Book extends Work {

    private String _author;
    private String _ISBN;

    public Book(int worksCounter, String author, int price, Category category, String ISBN, int copies) {
        super(worksCounter, copies, price, title);
        _author = author;
        _ISBN = ISBN;
    }
}