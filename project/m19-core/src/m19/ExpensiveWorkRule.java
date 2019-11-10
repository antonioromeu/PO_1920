package m19;

import java.util.ArrayList;

public class ExpensiveWorkRule implements Rule {
    public boolean ok(Request request) {
        return request.getWork().getPrice() <= 25;
    }
}