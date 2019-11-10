package m19;

import java.util.ArrayList;

public class SuspendedUserRule implements Rule {
    public boolean ok(Request request) {
        return request.getUser().isActive();
    }
}