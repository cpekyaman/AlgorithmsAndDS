package algo.ch11.search;

import algo.ch11.Edge;

import java.util.List;

public interface GraphSearch {
    List<Edge> findPath(Integer to);

    boolean hasConnection(Integer to);
}
