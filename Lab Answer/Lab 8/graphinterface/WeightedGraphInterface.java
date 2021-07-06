package lab.graphinterface;

public interface WeightedGraphInterface<E extends Comparable<E>, N extends Comparable<N>> extends GraphInterface<E> {

    boolean addEdge(E source, E destination, N weight);
    boolean addUndirectedEdge(E source, E destination, N weight);
    N removeEdge(E source, E destination);
    N getEdgeWeight(E source, E destination);
}
