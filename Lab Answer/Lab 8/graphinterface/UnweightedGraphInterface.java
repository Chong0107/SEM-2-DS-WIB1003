package lab.graphinterface;

public interface UnweightedGraphInterface<E extends Comparable<E>> extends GraphInterface<E> {
    boolean addEdge(E source, E destination);
    boolean addUndirectedEdge(E source, E destination);
    boolean removeEdge(E source, E destination);
}
