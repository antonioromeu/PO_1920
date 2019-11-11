package m19;

public class Book extends Work {

    private String _author;
    private String _ISBN;

    public Book(int worksCounter, String title, String author, int price, String category, String ISBN, int copies) {
        super(worksCounter, copies, price, title, category);
        _author = author;
        _ISBN = ISBN;
    }
}