package m19;

public class DVD extends Work {

    private static final long serialVersionUID = 20160823123L;

    private String _director;
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
    public String showWork() {
        String r = super.showWork() + " DVD - " + getTitle() + " - " + getPrice() + " - " + getCategory() + " - " + getDirector() + " - " + getIGAC();  
        return r;  
    }
}