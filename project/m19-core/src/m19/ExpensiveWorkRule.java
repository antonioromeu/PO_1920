package m19;

import java.util.Map;

public class ExpensiveWorkRule implements Rule {
    public boolean ok(Request request, Map<Integer, Request> requestMap) {
        return request.getWork().getPrice() <= 25;
    }
}