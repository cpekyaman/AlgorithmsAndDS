package udemy.algo.advanced.cycle;

import java.util.List;

public class CycleDetection<T> {
    public void detect(List<CycleVertex<T>> vertices) {
        vertices.stream().filter(v -> ! v.isVisited()).forEach(this::dfs);
    }

    private void dfs(CycleVertex<T> vertex) {
        vertex.startVisiting();

        System.out.printf("Processing neighbours of %s\n", vertex);
        for(CycleVertex<T> v : vertex.getNeighbours()) {
            if(v.isVisiting()) {
                System.out.printf("There is cycle : %s -> %s\n", v, vertex);
                return;
            }

            if(! v.isVisited()) {
                v.mark();
                dfs(v);
            }
        }

        vertex.endVisiting();
    }
}
