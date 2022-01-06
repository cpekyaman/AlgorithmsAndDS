package algo.ch13;

import java.util.Collections;
import java.util.List;

public final class NilSortOrder implements GraphSortOrder {
    @Override
    public List<Integer> reversePost() {
        return Collections.emptyList();
    }
}
