package m19;

import java.util.Map;

public class WorkNumberRule implements Rule {
    public boolean ok(Request request, Map<Integer, Request> requestMap) {
        if (request.getUser().getBehaviour() instanceof NormalBehaved && request.getUser().getNumberWorks() < 3) return true;
        if (request.getUser().getBehaviour() instanceof WellBehaved && request.getUser().getNumberWorks() < 5) return true;
        if (request.getUser().getBehaviour() instanceof BadlyBehaved && request.getUser().getNumberWorks() < 1) return true;
        return false;
    }
}