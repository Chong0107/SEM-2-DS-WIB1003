package lab.weightedgraph;

public class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
    // Current vertex info
    T vertexInfo;
    int indeg;
    int outdeg;

    // Reference to next Vertex
    Vertex<T, N> nextVertex;

    // Reference to first edge node
    Edge<T, N> firstEdge;

    public Vertex() {
        this.vertexInfo = null;
        this.indeg = 0;
        this.outdeg = 0;
        this.nextVertex = null;
        this.firstEdge = null;
    }

    public Vertex(T vertexInfo, Vertex<T, N> nextVertex) {
        this.vertexInfo = vertexInfo;
        this.indeg = 0;
        this.outdeg = 0;
        this.nextVertex = nextVertex;
        this.firstEdge = null;
    }
}
