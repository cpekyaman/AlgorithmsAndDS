package algo.ch15;

import algo.ch13.Digraph;

@FunctionalInterface
public interface ShortestPathSearchCreator {
    ShortestPathSearch create(Digraph graph, Integer from);
}
