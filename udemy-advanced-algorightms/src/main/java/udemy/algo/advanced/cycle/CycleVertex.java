package udemy.algo.advanced.cycle;

import udemy.algo.advanced.graph.BaseVertex;

public class CycleVertex<T> extends BaseVertex<T, CycleVertex<T>> {
    private boolean isVisiting;

    public CycleVertex(T data) {
        super(data);
    }

    public boolean isVisiting() {
        return isVisiting;
    }

    public void startVisiting() {
        this.isVisiting = true;
    }

    public void endVisiting() {
        this.isVisiting = false;
        this.mark();
    }
}
