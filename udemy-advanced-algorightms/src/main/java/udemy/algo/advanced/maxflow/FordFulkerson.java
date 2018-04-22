package udemy.algo.advanced.maxflow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    // marked[i] == true means there is a path
    // in residual graph from source to i
    private boolean[] marked;

    // edges in augmenting path
    private FlowEdge[] augmentingPathEdges;

    private double maxFlow = 0.0D;

    public FordFulkerson(FlowNetwork network, FlowVertex source, FlowVertex sink) {
        while(hasAugmentingPath(network, source, sink)) {
            double minFlow = Double.POSITIVE_INFINITY;

            // work from sink to source in residual network
            // and find min flow which can be added to edges in augmenting path in original network
            for(FlowVertex v = sink; v != source; v = augmentingPathEdges[v.getId()].getNeighbor(v)) {
                minFlow = Math.min(minFlow, augmentingPathEdges[v.getId()].getResidualCapaticy(v));
            }

            // work from sink to source in original network
            // and add min flow to edges in augmenting path
            for(FlowVertex v = sink; v != source; v = augmentingPathEdges[v.getId()].getNeighbor(v)) {
                augmentingPathEdges[v.getId()].addResidualFlow(v, minFlow);
            }

            maxFlow = maxFlow + minFlow;
        }
    }

    //TODO: this is edmunds-karp (may be extracted to its own class)
    private boolean hasAugmentingPath(FlowNetwork network, FlowVertex source, FlowVertex sink) {
        augmentingPathEdges = new FlowEdge[network.getNumVertices()];
        marked = new boolean[network.getNumVertices()];

        Queue<FlowVertex> verticesToVisit = new LinkedList<>();
        verticesToVisit.add(source);
        marked[source.getId()] = true;

        while(! verticesToVisit.isEmpty() && ! marked[sink.getId()]) {
            FlowVertex current = verticesToVisit.remove();

            for(FlowEdge edge : network.getAdjacencies(current)) {
                FlowVertex currentNeighbor = edge.getNeighbor(current);

                if(edge.getResidualCapaticy(currentNeighbor) > 0 && ! marked[currentNeighbor.getId()]) {
                    augmentingPathEdges[currentNeighbor.getId()] = edge;
                    marked[currentNeighbor.getId()] = true;
                    verticesToVisit.add(currentNeighbor);
                }
            }
        }

        return marked[sink.getId()];
    }
}
