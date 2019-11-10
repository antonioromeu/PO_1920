package m19;

public abstract class Work {

    private int _id;
    private int _copies;
    private int _price;
    private String _category;
    private String _title;

    public Work(int worksCounter, int copies, int price, String title, String category) {
        _id = worksCounter;
        _copies = copies;
        _price = price;
        _title = title;
        _category = category;
    }

    public int getID() {
        return _id;
    }

    public int getCopies() {
        return _copies;
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
}