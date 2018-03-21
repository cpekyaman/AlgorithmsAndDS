package udemy.algo.advanced.stronglyconnected.tarjan;

import java.util.*;

public class Tarjan {
    private Stack<TarjanVertex> stack;
    private Set<TarjanVertex> vertices;
    private List<Set<TarjanVertex>> sccList;
    private int time = 0;
    private int count;

    public Tarjan(Set<TarjanVertex> vertices) {
        this.vertices = vertices;
        this.stack = new Stack<>();
        this.sccList = new ArrayList<>();
    }

    public void run() {
        this.vertices.stream().filter(v -> !v.isVisited()).forEach(this::dfs);
    }

    private void dfs(TarjanVertex vertex) {
        vertex.setLowLink(time++);
        vertex.markVisited();
        this.stack.push(vertex);

        System.out.printf("dfs vertex %s with low link %d\n", vertex, time);

        boolean isSccRoot = true;

        for (TarjanVertex neighbour : vertex.getNeighbours()) {
            if (!neighbour.isVisited()) {
                System.out.printf("dfs neighbour %s\n", neighbour);
                dfs(neighbour);
            }

            if (vertex.getLowLink() < neighbour.getLowLink()) {
                System.out.printf("Vertex %s lowlink %d, neighbour %s lowlink %d\n", vertex, vertex.getLowLink(), neighbour, neighbour.getLowLink());
                vertex.setLowLink(neighbour.getLowLink());
                isSccRoot = false;
            }

            if (isSccRoot) {
                count++;
                System.out.printf("Vertex %s is scc root\n", vertex);
                Set<TarjanVertex> component = new HashSet<>();
                while (true) {
                    TarjanVertex actualVertex = stack.pop();
                    component.add(actualVertex);
                    actualVertex.setLowLink(Integer.MAX_VALUE);
                    if (vertex.equals(actualVertex)) {
                        break;
                    }
                }
                this.sccList.add(component);
            }
        }
    }

    public void show() {
        System.out.println(this.sccList);
    }
}
