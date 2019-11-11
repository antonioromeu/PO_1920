package m19;

import java.util.Map;

public class ReferenceWorkRule implements Rule {
    public boolean ok(Request request, Map<Integer, Request> requestMap) {
        return request.getWork().getCategory().equals("Reference");
    }
}