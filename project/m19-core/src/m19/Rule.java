package m19;

public interface Rule {
    public boolean ok(Request request);

    public void addRule(Rule rule);
    public void removeRule(Rule rule);
}