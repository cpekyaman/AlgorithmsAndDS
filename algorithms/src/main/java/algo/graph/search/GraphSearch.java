package algo.graph.search;

import algo.graph.Edge;

import java.util.List;

public interface GraphSearch {
    List<Edge> findPath(Integer to);

    boolean hasConnection(Integer to);
}
