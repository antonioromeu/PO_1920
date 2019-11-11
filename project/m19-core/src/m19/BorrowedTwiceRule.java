package m19;

import java.util.Map;

public class BorrowedTwiceRule implements Rule {
    public boolean ok(Request request, Map<Integer, Request> requestMap) {
        for (Request r : requestMap.values()) {
            if (r.getWork().equals(request.getWork()) && r.getUser().equals(request.getUser())) return false;
        }
        return true;
    }
}