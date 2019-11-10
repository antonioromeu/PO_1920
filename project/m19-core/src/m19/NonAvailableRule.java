package m19;

import java.util.ArrayList;

public class NonAvailableRule implements Rule {
    public boolean ok(Request request, ArrayList requestList) {
        for (Request r : requestList) {
            if (r.getWork().equals(request.getWork()) && r.getWork().getCopies() > 0) return false;
        }
        return true;
    }
}