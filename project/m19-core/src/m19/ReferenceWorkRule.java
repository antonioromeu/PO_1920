package m19;

import java.util.ArrayList;

public class ReferenceWorkRuleRule implements Rule {
    public boolean ok(Request request) {
        return request.getWork().getCategory().equals("Reference");
    }
}