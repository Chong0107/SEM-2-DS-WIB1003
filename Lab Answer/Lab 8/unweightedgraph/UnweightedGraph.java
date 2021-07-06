package lab.unweightedgraph;

import lab.graphinterface.UnweightedGraphInterface;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UnweightedGraph<E extends Comparable<E>> implements UnweightedGraphInterface<E> {
    private Vertex<E> head;
    private int size;

    public UnweightedGraph() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getIndeg(E v) {
        Vertex<E> current = head;
        while (current != null) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return current.indeg;
            }
            current = current.nextVertex;
        }
        return -1;
    }

    @Override
    public int getOutdeg(E v) {
        Vertex<E> current = head;
        while (current != null) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return current.outdeg;
            }
            current = current.nextVertex;
        }
        return -1;
    }

    @Override
    public boolean hasVertex(E v) {
        Vertex<E> current = head;
        while (current != null) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return true;
            }
            current = current.nextVertex;
        }
        return false;
    }

    @Override
    public int getIndex(E v) {
        Vertex<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return index;
            }
            index++;
            current = current.nextVertex;
        }
        return index = -1;
    }

    @Override
    public E getVertex(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }

        Vertex<E> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.nextVertex;
        }
        return current.vertexInfo;
    }

    @Override
    public boolean addVertex(E v) {
        if (!hasVertex(v)) {
            Vertex<E> current = head;
            Vertex<E> newVertex = new Vertex<>(v);

            if (head == null) {
                head = newVertex;
            } else {
                Vertex<E> lastVertex = head;
                while (current != null) {
                    lastVertex = current;
                    current = current.nextVertex;
                }
                lastVertex.nextVertex = new Vertex<>(v);
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasEdge(E source, E destination) {
        if (head == null) {
            return false;
        } else if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        } else {
            Vertex<E> sourceVertex = head;
            while (sourceVertex != null) {
                if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                    Edge<E> currentEdge = sourceVertex.firstEdge;
                    while (currentEdge != null) {
                        if (currentEdge.adjVertex.vertexInfo.compareTo(destination) == 0) {
                            return true;
                        }
                        currentEdge = currentEdge.nextEdge;
                    }
                }
                sourceVertex = sourceVertex.nextVertex;
            }
        }
        return false;
    }

    @Override
    public boolean removeEdge(E source, E destination) {
        if (head == null) {
            return false;
        } else if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        } else {
            Vertex<E> sourceVertex = head;
            while (sourceVertex != null) {
                if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                    Edge<E> currentEdge = sourceVertex.firstEdge;
                    Edge<E> previousEdge = sourceVertex.firstEdge;
                    while (currentEdge != null) {
                        if (currentEdge.adjVertex.vertexInfo.compareTo(destination) == 0) {
                            if (currentEdge == sourceVertex.firstEdge) {   // when the edge is the first edge
                                sourceVertex.firstEdge = currentEdge.nextEdge;
                            } else {  // when the edge is in the centre or at the last
                                previousEdge.nextEdge = currentEdge.nextEdge;
                            }
                            currentEdge.nextEdge = null;
                            currentEdge.adjVertex = null;
                            return true;
                        }
                        previousEdge = currentEdge;
                        currentEdge = currentEdge.nextEdge;
                    }
                }
                sourceVertex = sourceVertex.nextVertex;
            }
        }
        return false;
    }

    @Override
    public ArrayList<E> getAllVertexObjects() {
        ArrayList<E> allVertices = new ArrayList<>();
        Vertex<E> current = head;
        while (current != null) {
            allVertices.add(current.vertexInfo);
            current = current.nextVertex;
        }
        return allVertices;
    }

    @Override
    public ArrayList<E> getNeighbours(E v) {
        if (!hasVertex(v)) {
            throw new NoSuchElementException();
        }
        ArrayList<E> neighbours = new ArrayList<>();
        Vertex<E> current = head;
        while (current != null) {
            if (current.vertexInfo.compareTo(v) == 0) {
                Edge<E> edge = current.firstEdge;
                while (edge != null) {
                    neighbours.add(edge.adjVertex.vertexInfo);
                    edge = edge.nextEdge;
                }
                break;
            }
            current = current.nextVertex;
        }
        return neighbours;
    }

    @Override
    public boolean addEdge(E source, E destination) {
        if (head == null) {
            return false;
        } else if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        } else {
            Vertex<E> sourceVertex = head;
            while (sourceVertex != null) {
                if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                    Vertex<E> destVertex = head;
                    while (destVertex != null) {
                        if (destVertex.vertexInfo.compareTo(destination) == 0) {
                            Edge<E> newEdge = new Edge<>(destVertex, sourceVertex.firstEdge);
                            sourceVertex.firstEdge = newEdge;
                            sourceVertex.outdeg++;
                            destVertex.indeg++;
                            return true;
                        }
                        destVertex = destVertex.nextVertex;
                    }
                }
                sourceVertex = sourceVertex.nextVertex;
            }
        }
        return false;
    }

    @Override
    public boolean addUndirectedEdge(E source, E destination) {
        if (head == null) {
            return false;
        } else if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        } else {
            Vertex<E> sourceVertex = head;
            while (sourceVertex != null) {
                if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                    Vertex<E> destVertex = head;
                    while (destVertex != null) {
                        if (destVertex.vertexInfo.compareTo(destination) == 0) {
                            Edge<E> newSourceEdge = new Edge<>(destVertex, sourceVertex.firstEdge);
                            sourceVertex.firstEdge = newSourceEdge;
                            Edge<E> newDestEdge = new Edge<>(sourceVertex, destVertex.firstEdge);
                            destVertex.firstEdge = newDestEdge;
                            sourceVertex.indeg++;
                            sourceVertex.outdeg++;
                            destVertex.indeg++;
                            sourceVertex.outdeg++;
                            return true;
                        }
                        destVertex = destVertex.nextVertex;
                    }
                }
                sourceVertex = sourceVertex.nextVertex;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Vertex<E> temp = head;
        while (temp != null) {
            sb.append(temp.vertexInfo).append(" : [");
            Edge<E> tempEdge = temp.firstEdge;
            while (tempEdge != null) {
                sb.append(tempEdge.adjVertex.vertexInfo);
                if (tempEdge.nextEdge != null) {
                    sb.append(", ");
                }
                tempEdge = tempEdge.nextEdge;
            }
            sb.append("]\n");
            temp = temp.nextVertex;
        }
        return sb.toString();
    }

    // Vertex class for unweighted graph
    private class Vertex<T extends Comparable<T>> {
        private T vertexInfo;
        private int indeg;
        private int outdeg;
        private Vertex<T> nextVertex;
        private Edge<T> firstEdge;

        Vertex(T vertexInfo) {
            this(vertexInfo, null);
        }

        Vertex(T vertexInfo, Vertex<T> nextVertex) {
            this.vertexInfo = vertexInfo;
            this.indeg = 0;
            this.outdeg = 0;
            this.nextVertex = nextVertex;
            this.firstEdge = null;
        }
    }

    // Edge class for unweighted graph
    private class Edge<T extends Comparable<T>> {
        private Vertex<T> adjVertex;
        private Edge<T> nextEdge;

        Edge(Vertex<T> adjVertex) {
            this(adjVertex, null);
        }

        Edge(Vertex<T> adjVertex, Edge<T> nextEdge) {
            this.adjVertex = adjVertex;
            this.nextEdge = nextEdge;
        }
    }
}
