package lab.weightedgraph;

import lab.graphinterface.WeightedGraphInterface;

import java.util.ArrayList;

public class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>> implements WeightedGraphInterface<T, N> {

    // head of the graph
    Vertex<T, N> head;

    // total vertex in the graph
    int size;

    public WeightedGraph() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean hasVertex(T v) {
        if (head == null) {
            return false;
        }
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0) {
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    public int getIndeg(T v) {
        if (hasVertex(v)) {
            Vertex<T, N> temp = head;
            while (temp != null) {
                if (temp.vertexInfo.compareTo(v) == 0) {
                    return temp.indeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }

    public int getOutdeg(T v) {
        if (hasVertex(v)) {
            Vertex<T, N> temp = head;
            while (temp != null) {
                if (temp.vertexInfo.compareTo(v) == 0) {
                    return temp.outdeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }

    public boolean addVertex(T v) {
        if (!hasVertex(v)) { // if the graph still don't have this vertex, add it
            Vertex<T, N> temp = head;
            Vertex<T, N> newVertex = new Vertex<>(v, null);

            if (head == null) { // if the graph is initially empty
                head = newVertex;
            } else { // traverse to the last vertex and add it
                Vertex<T, N> previous = head;
                while (temp != null) {
                    previous = temp; // this is to keep the last vertex
                    temp = temp.nextVertex; // finally will be null when reach the last vertex
                }
                previous.nextVertex = newVertex; // assign new vertex at the back of the last vertex
            }
            size++;
            return true;
        }
        // if vertex is already been existed in the graph don't add it (the vertexInfo is unique for the whole graph)
        return false;
    }

    public int getIndex(T v) {
        Vertex<T, N> temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0) {
                return pos;
            }
            temp = temp.nextVertex;
            pos++;
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;
    }

    public T getVertex(int pos) {
        if (pos >= size || pos < 0) {
            return null;  // pos index out of range
        }
        Vertex<T, N> temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.nextVertex;
        }
        return temp.vertexInfo;
    }

    public boolean hasEdge(T source, T destination) { // check if there is an edge between source and destination
        if (head == null) { // if there's no vertex at all
            return false;
        }
        if (!hasVertex(source) || !hasVertex(destination)) { // if the graph doesn't have these 2 vertices
            return false;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) { // find source vertex
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { // source vertex found
                Edge<T, N> currentEdge = sourceVertex.firstEdge; // get the current edge
                while (currentEdge != null) { // find the destination using edge from source vertex
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) { // if reach the destination using current edge
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addEdge(T source, T destination, N w) {
        if (head == null) { // the graph is empty
            return false;
        }
        if (!hasVertex(source) || !hasVertex(destination)) { // if the graph doesn't have these 2 vertex
            return false;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) { // find the sourceVertex
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { // sourceVertex found
                Vertex<T, N> destinationVertex = head;
                while (destinationVertex != null) { // find the destinationVertex
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) { // destinationVertex found
                        // Reached destinationVertex, add Edge here
                        Edge<T, N> currentEdge = sourceVertex.firstEdge;
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, w, currentEdge); // create an edge and add this edge to the front of currentEdge
                        sourceVertex.firstEdge = newEdge; // the firstEdge for the sourceVertex has been changed to the newly added edge
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addUndirectedEdge(T source, T destination, N w) {
        if (head == null) {
            return false;
        } else if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                Vertex<T, N> destinationVertex = head;
                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        Edge<T, N> srcCurrentEdge = sourceVertex.firstEdge;
                        Edge<T, N> srcNewEdge = new Edge<>(destinationVertex, w, srcCurrentEdge);

                        Edge<T, N> destCurrentEdge = destinationVertex.firstEdge;
                        Edge<T, N> destNewEdge = new Edge<>(sourceVertex, w, destCurrentEdge);

                        sourceVertex.firstEdge = srcNewEdge;
                        destinationVertex.firstEdge = destNewEdge;

                        sourceVertex.indeg++;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        destinationVertex.outdeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public N removeEdge(T source, T destination) {
        if (head == null) { // if the graph is empty
            return null;
        } else if (!hasVertex(source) || !hasVertex(destination)) { // if the graph doesn't have these 2 vertex
            return null;
        }

        Vertex<T, N> srcVertex = head;
        while (srcVertex != null) {  // Search for source vertex
            if (srcVertex.vertexInfo.compareTo(source) == 0) {  // Source vertex found
                Edge<T, N> currentEdge = srcVertex.firstEdge;   // Get the first edge of the source vertex
                Edge<T, N> previousEdge = currentEdge;
                while (currentEdge != null) {  // Search for the edge to be removed
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {  // Edge to be removed found
                        N removedWeight = currentEdge.weight;
                        if (currentEdge == srcVertex.firstEdge) {  // If the edge to be removed is the first edge from the source vertex
                            srcVertex.firstEdge = currentEdge.nextEdge;
                        } else {  // If the edge to be removed is at the middle or end of the edge list
                            previousEdge.nextEdge = currentEdge.nextEdge;
                        }
                        currentEdge.toVertex.indeg--;  // decrement the indeg of the destination vertex
                        srcVertex.outdeg--;            // decrement the outdeg of the source vertex
                        currentEdge.nextEdge = null;   // set the attributes of the edge to be removed into null
                        currentEdge.toVertex = null;
                        currentEdge.weight = null;
                        return removedWeight;
                    }
                    previousEdge = currentEdge;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            srcVertex = srcVertex.nextVertex;
        }
        return null;
    }

    public N getEdgeWeight(T source, T destination) {
        N notFound = null;
        if (head == null) {
            return notFound;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return notFound;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        return currentEdge.weight;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }

            sourceVertex = sourceVertex.nextVertex;
        }
        return notFound;
    }

    public ArrayList<T> getNeighbours(T v) { // get all the neighbouring vertex of this given vertex
        if (!hasVertex(v)) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0) {
                Edge<T, N> currentEdge = temp.firstEdge;
                while (currentEdge != null) {
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
                break;
            }
            temp = temp.nextVertex;
        }
        return list;
    }

    public void printEdges() {
        Vertex<T, N> temp = head;
        while (temp != null) {
            System.out.print("# " + temp.vertexInfo + " : ");
            Edge<T, N> currentEdge = temp.firstEdge;
            while (currentEdge != null) {
                System.out.print("[" + temp.vertexInfo + "," + currentEdge.toVertex.vertexInfo + "]");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }
}
