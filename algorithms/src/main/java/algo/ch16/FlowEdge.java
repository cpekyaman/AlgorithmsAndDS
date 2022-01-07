package algo.ch16;

import algo.graph.Edge;
import algo.graph.Vertex;

import java.util.Objects;

// using weight as capacity
public class FlowEdge extends Edge {
    private int flow;

    public FlowEdge(Vertex V, Vertex W, int weight) {
        super(V, W, weight);
        if(weight < 0) {
            throw new IllegalArgumentException("can't have negative capacity");
        }
    }

    public Vertex from() {
        return V;
    }

    public Vertex to() {
        return W;
    }

    public int residualCapacity(Integer toVertex) {
        // 1. backward edge
        // 2. forward edge
        if(toVertex.equals(V.getId())) {
            return flow;
        } else if(toVertex.equals(W.getId())) {
            return weight - flow;
        }
        throw new IllegalArgumentException("not a vertex of this edge");
    }

    public void addFlow(Integer toVertex, int flow) {
        // 1. backward edge
        // 2. forward edge
        if(toVertex.equals(V.getId())) {
            if(this.flow - flow < 0) {
                throw new IllegalArgumentException("can't reduce flow to less than zero");
            }
            this.flow -= flow;
        } else if(toVertex.equals(W.getId())) {
            if(this.flow + flow > weight) {
                throw new IllegalArgumentException("can't increase flow to more than capacity");
            }
            this.flow += flow;
        } else {
            throw new IllegalArgumentException("not a vertex of this edge");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowEdge edge = (FlowEdge) o;
        return V.equals(edge.V) && W.equals(edge.W);
    }

    @Override
    public int hashCode() {
        return Objects.hash(V, W);
    }
}
