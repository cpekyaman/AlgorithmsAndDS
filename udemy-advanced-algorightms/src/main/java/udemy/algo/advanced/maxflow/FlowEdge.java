package udemy.algo.advanced.maxflow;

import java.util.Objects;

public class FlowEdge {
    private final FlowVertex source;
    private final FlowVertex target;
    private final double capacity;
    private double flow;

    public FlowEdge(FlowVertex source, FlowVertex target, double capacity) {
        this.source = source;
        this.target = target;
        this.capacity = capacity;
        this.flow = 0.0D;
    }

    public FlowEdge(FlowEdge original) {
        this.source = original.source;
        this.target = original.target;
        this.capacity = original.capacity;
        this.flow = original.flow;
    }

    public FlowVertex getNeighbor(FlowVertex vertex) {
        if(vertex.equals(source)) {
            return target;
        } else {
            return source;
        }
    }

    public double getResidualCapaticy(FlowVertex vertex) {
        if(vertex.equals(source)) {
            // backward edge
            return this.flow;
        } else {
            return capacity - flow;
        }
    }

    public void addResidualFlow(FlowVertex vertex, double delta) {
        if(vertex.equals(source)) {
            // backward edge
            flow = flow - delta;
        } else {
            flow = flow + delta;
        }
    }

    public FlowVertex getSource() {
        return source;
    }

    public FlowVertex getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowEdge flowEdge = (FlowEdge) o;
        return Objects.equals(source, flowEdge.source) &&
                Objects.equals(target, flowEdge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
