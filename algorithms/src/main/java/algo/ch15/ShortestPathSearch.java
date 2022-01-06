package algo.ch15;

import algo.graph.Edge;

import java.util.List;

public interface ShortestPathSearch {

    List<Edge> pathTo(Integer to);

    boolean hasPathTo(Integer to);
}
