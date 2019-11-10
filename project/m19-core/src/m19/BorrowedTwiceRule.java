package m19;

public class BorrowedTwiceRule implements Rule {
    public boolean ok(Request request) {
        for (Request r : getRequestsList()) {
            if (r.getWork().equals(request.getWork()) && r.getUser().equals(request.getUser())) return false;
        }
        return true;
    }
}