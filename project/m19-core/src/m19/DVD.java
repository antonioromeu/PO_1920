package m19;

public class DVD extends Work {

    private String _director;
    private String _IGAC;

    public DVD(int worksCounter, int copies, int price, String title, String director, String IGAC) {
        super(worksCounter, copies, price, title);
        _director = director;
        _IGAC = IGAC;
    }
}