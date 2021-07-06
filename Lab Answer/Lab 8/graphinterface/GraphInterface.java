package lab.graphinterface;

import java.util.ArrayList;

public interface GraphInterface<E extends Comparable<E>> {
    int getSize();
    int getIndeg(E v);
    int getOutdeg(E v);

    boolean hasVertex(E v);
    int getIndex(E v);
    E getVertex(int pos);
    boolean addVertex(E v);

    boolean hasEdge(E source, E destination);


    ArrayList<E> getAllVertexObjects();
    ArrayList<E> getNeighbours(E v);
}
