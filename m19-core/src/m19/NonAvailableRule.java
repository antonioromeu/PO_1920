package m19;

import java.util.Map;
import java.util.List;

public class NonAvailableRule implements Rule {

    private static final long serialVersionUID = 201908231123L;

    public boolean ok(Request request, Map<List<Integer>, Request> requestMap) {
        for (Request r : requestMap.values())
            if (r.getWork().equals(request.getWork()) && ((r.getWork().getCopies() - r.getWork().getCopiesTaken()) <= 0))
                return false;
        return true;
    }
}