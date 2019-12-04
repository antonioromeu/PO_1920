package m19;

import java.util.Map;

public class NonAvailableRule implements Rule {
    public boolean ok(Request request, Map<Integer, Request> requestMap) {
        for (Request r : requestMap.values()) {
            if (r.getWork().equals(request.getWork()) && r.getWork().getCopies() <= 0) return false;
        }
        return true;
    }
}