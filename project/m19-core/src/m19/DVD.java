package m19;

public class DVD extends Work {

    private String _director;
    private String _IGAC;

    public DVD(int worksCounter, String director, int price, Category category, String IGAC, int copies) {
        super(worksCounter, copies, price, title);
        _director = director;
        _IGAC = IGAC;
    }
}