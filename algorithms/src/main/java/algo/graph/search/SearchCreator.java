package algo.graph.search;

import algo.graph.BaseGraph;

@FunctionalInterface
public interface SearchCreator {
    GraphSearch create(BaseGraph graph, Integer from);
}
