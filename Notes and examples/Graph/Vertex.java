
package Graph;

public class Vertex<T extends Comparable<T>,N extends Comparable<N>> {
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;

    public Vertex() {
        vertexInfo = null;
        indeg = 0;
        outdeg = 0;
        nextVertex = null;
        firstEdge = null;
    }

    public Vertex(T vInfo, Vertex<T, N> next) {
        vertexInfo = vInfo;
        indeg = 0;
        outdeg = 0;
        nextVertex = next;
        firstEdge = null;
    }
}

class Edge<T extends Comparable<T>,N extends Comparable<N>> {
    Vertex<T, N> toVertex;
    N weight;
    Edge<T, N> nextEdge;

    public Edge() {
        toVertex = null;
        weight = null;
        nextEdge = null;
    }

    public Edge(Vertex<T, N> destination, N w, Edge<T, N> a) {
        toVertex = destination;
        weight = w;
        nextEdge = a;
    }
}
