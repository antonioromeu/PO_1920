package m19;

import java.util.Map;
import java.util.List;

public class ExpensiveWorkRule implements Rule {

    private static final long serialVersionUID = 201908001530L;

    public boolean ok(Request request, Map<List<Integer>, Request> requestMap) {
        return request.getWork().getPrice() <= 25;
    }
}