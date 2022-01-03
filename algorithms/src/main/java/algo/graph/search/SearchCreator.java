package algo.graph.search;

import algo.ch11.Graph;

@FunctionalInterface
public interface SearchCreator {
    GraphSearch create(Graph graph, Integer from);
}
