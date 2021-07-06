
package Graph;

import java.util.*;

public class WeightedGraph<T extends Comparable<T>,N extends Comparable<N>> {
    Vertex<T,N> head;
    int size;

    public WeightedGraph() {
        head = null;
        size = 0;
    }
    
    public int getSize(){
        return this.size;
    }
    
    // is this vertex in the graph ?
    public boolean hasVertex(T v){
        if (head == null){
            return false;
        }
        Vertex<T,N> temp = head;
        while(temp != null){
            // Comparation: to determine whether it is 
            // the vertex we are looking for or not.
            if(temp.vertexInfo.compareTo(v)==0){
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }
    
    // Get inDeg of a vertex
    public int getIndeg(T v){
        if(hasVertex(v) == true){
            Vertex<T,N> temp = head;
            while(temp != null){
                if(temp.vertexInfo.compareTo(v)== 0){
                    return temp.indeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1; // Return -1 if cannot find 
    }
    
    // Get outDeg of a vertex
    public int getOutdeg(T v){
        if(hasVertex(v) == true){
            Vertex<T,N> temp = head;
            while(temp != null){
                if(temp.vertexInfo.compareTo(v)== 0){
                    return temp.outdeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }
    
    // Add new Vertex
    public boolean addVertex(T v){
        // If the vertex is not in the graph
        if(hasVertex(v) == false){
            Vertex<T,N> temp = head;
            Vertex<T,N> newVertex = new Vertex<>(v,null);
            // If the graph is empty, point head to this vertex
            if(head == null){
                head = newVertex;
            }
            else{
                // Use the previous to move to the last vertex
                Vertex<T,N> previous = head;
                while(temp != null){
                    previous = temp;
                    temp = temp.nextVertex;
                }
                // Add the vertex as last in the 
                previous.nextVertex = newVertex;
            }
            size++;
            return true;
        }
        // Vertex is already in the graph
        else{
            return false;
        }
    }
    
    // With the node information, find the index of the vertex
    public int getIndex(T v){
        Vertex<T,N> temp = head;;
        int pos = 0;
        // Loop to find the vertex
        while(temp != null){
            // If the vertex is found, return pos value (index)
            if(temp.vertexInfo.compareTo(v)== 0){
                return pos;
            }
            // Move temp to next vertex
            temp = temp.nextVertex;
            pos++;
        }
        return -1;
    }
    
    // Return all the vertex info to an Arraylist
    public ArrayList<T> getAllVertexObjects(){
        ArrayList<T> list = new ArrayList<>();
        Vertex<T,N> temp = head;
        while(temp != null){
            // Use "add" methiod of Arraylist to add 
            // each vertex info
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;
    }
    
    // Get vertex info at a specific index (position)
    public T getVertex(int pos){
        // if the position is not valid
        if(pos > size - 1|| pos < 0){
            return null;
        }
        Vertex<T,N> temp = head;
        for(int i=0;i<pos;i++){
            temp = temp.nextVertex;
        }
        return temp.vertexInfo;
    }
    
    // Check whether there is an edge
    public boolean hadEdge(T source,T destination){
        // If the graph is empty
        if(head == null){
            return false;
        }
        // If there are no much vertices
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        // Search for the edge in valid condition
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null){
            // if the source vertex is not found, go to next 
            // iteration of outer while loop
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                // Reached source vertex, look for destination now
                // If Source vertex found, create an edge reference here
                // and look for destination vertex in the second while loop
                Edge<T,N> currentEdge = sourceVertex.firstEdge;
                while(currentEdge != null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        // destination vertex found
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false; // Find no such edge in previous loop
    }
    
    // Add a new edge from source of destination, with a weight
    public boolean addEdge(T source, T destination, N w){
        // If the graph is empty
        if( head == null){
            return false;
        }
        // If there are no much vertices
        if(!hasVertex(source) || !hasVertex(destination)){
            return false;
        }
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source)== 0){
                // Reached source vertex, look for destination now
                Vertex<T,N> destinationVertex = head;
                while(destinationVertex != null){
                    if(destinationVertex.vertexInfo.compareTo(destination)== 0){
                        // Reached destination vertex, add edge here
                        // Create an edge pointer and point to edges list
                        // which the source vertex is pointing to.
                        Edge<T,N> currentEdge = sourceVertex.firstEdge;
                        Edge<T,N> newEdge = new Edge<>(destinationVertex,w,currentEdge);
                        // Let the source vertex to the new edge object
                        sourceVertex.firstEdge = newEdge;
                        // Add 1 to in and out degree
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
    
    // Retrieve the weight of an edge
    public N getEdgeWeight(T source,T destination){
        N notFound = null;
        if(head == null){
            return notFound;
        }
        if(!hasVertex(source)||!hasVertex(destination)){
            return notFound;
        }
        Vertex<T,N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                Edge<T,N> currentEdge = sourceVertex.firstEdge;
                while(currentEdge != null){
                    // If edge found, return Weight
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        return currentEdge.weight;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return notFound;
    }
            
    // Return all the neighbours of a vertex to an ArrayList
    public ArrayList<T> getNeighbours(T v){
        if(!hasVertex(v)){
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();
        Vertex<T,N> temp = head;
        // Outer while: loop to find the vertex 
        // and create a reference to edge if found
        while(temp != null){
            if(temp.vertexInfo.compareTo(v)== 0){
                Edge<T,N> currentEdge = temp.firstEdge;
                // Nested while: read edges add add to ArrayList
                while(currentEdge != null){
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        return list;
    }
    
    // Print graph
    public void printEdges(){
        Vertex<T,N> temp = head;
        while(temp != null){
            // Print a vertex
            System.out.print("# "+temp.vertexInfo+" : ");
            Edge<T,N> currentEdge = temp.firstEdge;
            while(currentEdge != null){
                // Print edges in a nested loop
                System.out.print("["+temp.vertexInfo+"-->"+currentEdge.toVertex.vertexInfo+"] ");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }
}
