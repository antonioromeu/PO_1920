package m19;

import java.util.Map;

public interface Rule {
    public boolean ok(Request request, Map<Integer, Request> requestMap);
}