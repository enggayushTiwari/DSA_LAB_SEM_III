import java.util.Iterator;

// define the Graph interface
public interface Graph {
    // get the number of vertices in the graph
    int numVertices();
    // get the number of edges in the graph
    int numEdges();
    // get an iterator of all vertices in the graph
    Iterator<Vertex> vertices();
    // get an iterator of all edges in the graph
    Iterator<Edge> edges();
    // get the edge from vertex u to vertex v, or null if none
    Edge getEdge(Vertex u, Vertex v);
    // get an array of the two endpoint vertices of edge e
    Vertex[] endVertices(Edge e);
    // get the vertex opposite to v on edge e
    Vertex opposite(Vertex v, Edge e);
    // get the out-degree of vertex v
    int outDegree(Vertex v);
    // get the in-degree of vertex v
    int inDegree(Vertex v);
    // get an iterator of all outgoing edges of vertex v
    Iterator<Edge> outGoingEdges(Vertex v);
    // get an iterator of all incoming edges of vertex v
    Iterator<Edge> inComingEdges(Vertex v);
    // insert and return a new vertex with label x
    Vertex insertVertex(String x);
    // insert and return a new edge from u to v with weight x
    Edge insertEdge(Vertex u, Vertex v, int x);
}
