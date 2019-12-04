package m19;

import java.util.Map;
import java.util.List;

public class SuspendedUserRule implements Rule {

    private static final long serialVersionUID = 201905831530L;


    public boolean ok(Request request, Map<List<Integer>, Request> requestMap) {
        return request.getUser().isActive();
    }
}