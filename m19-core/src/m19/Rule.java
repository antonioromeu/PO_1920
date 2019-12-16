package m19;

import java.io.Serializable;
import java.util.Map;
import java.util.List;

public interface Rule extends Serializable {
    public boolean ok(Request request, Map<List<Integer>, Request> requestMap);
}