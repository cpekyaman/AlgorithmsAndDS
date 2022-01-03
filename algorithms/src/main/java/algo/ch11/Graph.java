package algo.ch11;

import java.util.*;

public final class Graph {
    private final Vertex[] vertices;

    public Graph(int vCap) {
        this.vertices = new Vertex[vCap];
    }

    public int size() {
        return vertices.length;
    }

    public Vertex[] vertices() {
        return this.vertices;
    }

    public Graph addEdge(int v, int w) {
        Vertex vv = getOrCreate(v);
        Vertex wv = getOrCreate(w);
        vv.addEdge(wv);
        wv.addEdge(vv);
        return this;
    }

    private Vertex getOrCreate(int v) {
        if(vertices[v] == null) {
            vertices[v] = new Vertex(v);
        }
        return vertices[v];
    }

    public List<Edge> adjacents(int v) {
        if(vertices[v] != null) {
            return vertices[v].getEdges();
        }
        return Collections.emptyList();
    }
}
