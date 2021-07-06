package lab.weightedgraph;

public class Edge<T extends Comparable<T>, N extends Comparable<N>> {
    // Reference to an adjacent vertex
    Vertex<T, N> toVertex;

    // Weight of this edge
    N weight;

    // Reference to next edge node
    Edge<T, N> nextEdge;

    public Edge() {
        this.toVertex = null;
        this.weight = null;
        this.nextEdge = null;
    }

    public Edge(Vertex<T, N> destination, N w, Edge<T, N> nextEdge) {
        this.toVertex = destination;
        this.weight = w;
        this.nextEdge = nextEdge;
    }
}
