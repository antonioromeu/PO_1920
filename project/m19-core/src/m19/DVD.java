package m19;

public class DVD extends Work {

    private String _director;
    private String _IGAC;

    public DVD(int worksCounter, String director, int price, String category, String IGAC, int copies) {
        super(worksCounter, copies, price, title, category);
        _director = director;
        _IGAC = IGAC;
    }
}