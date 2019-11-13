package m19;

public class Book extends Work {

    private static final long serialVersionUID = 20160823122L;

    private String _author;
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
    public String showWork() {
        String r = super.showWork() + " Livro - " + getTitle() + " - " + getPrice() + " - " + getCategory() + " - " + getAuthor() + " - " + getISBN();  
        return r;  
    }
}