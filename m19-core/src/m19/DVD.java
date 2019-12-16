package m19;

/**
  * Class that represents the concept of dvd.
  */

public class DVD extends Work {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 20160823123L;

    /** Director. */
    private String _director;

    /** IGAC. */
    private String _IGAC;

    public DVD(int worksCounter, String title, String director, int price, String category, String IGAC, int copies) {
        super(worksCounter, copies, price, title, category);
        _director = director;
        _IGAC = IGAC;
    }

    public String getIGAC() {
        return _IGAC;
    }

    public String getDirector() {
        return _director;
    }

    @Override
    public boolean containsTerm(String term) {
        return getDirector().toLowerCase().contains(term.toLowerCase()) || getTitle().toLowerCase().contains(term.toLowerCase());
    }

    /** Represents dvd as a string. */
    @Override
    public String showWork() {
        String r = super.showWork() + " DVD - " + getTitle() + " - " + getPrice() + " - " + getCategory() + " - " + getDirector() + " - " + getIGAC();  
        return r;  
    }
}
