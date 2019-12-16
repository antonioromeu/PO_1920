package m19;

import java.util.Map;
import java.util.List;

public class BorrowedTwiceRule implements Rule {

    private static final long serialVersionUID = 201908211569L;

    public boolean ok(Request request, Map<List<Integer>, Request> requestMap) {
        for (Request r : requestMap.values()) {
            if (r.getWork().equals(request.getWork()) && r.getUser().equals(request.getUser())) return false;
        }
        return true;
    }
}