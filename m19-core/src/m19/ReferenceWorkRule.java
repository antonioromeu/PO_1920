package m19;

import java.util.Map;
import java.util.List;

public class ReferenceWorkRule implements Rule {

    private static final long serialVersionUID = 201908531730L;


    public boolean ok(Request request, Map<List<Integer>, Request> requestMap) {
        return !request.getWork().getCategory().equals("Referência");
    }
}