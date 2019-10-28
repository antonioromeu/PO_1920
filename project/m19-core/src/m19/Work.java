package m19;

public abstract class Work {

    private int _id;
    private int _copies;
    private int _price;
    private Category _category;
    private String _title;

    public Work(int worksCounter, int copies, int price, String title) {
        _id = worksCounter;
        _copies = copies;
        _price = price;
        _title = title;
    }

    /* DEPENDE DE FEEDBACK
    setState() {}
    public void return() {}
    public boolean borrow() {}
    */
}