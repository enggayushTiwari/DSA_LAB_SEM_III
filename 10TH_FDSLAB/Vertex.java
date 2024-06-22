// define the Vertex interface
public interface Vertex {
    // get the label of the vertex
    String getLabel();
}

// define the Edge interface
interface Edge {
    // get the source vertex of the edge
    Vertex getSource();
    // get the destination vertex of the edge
    Vertex getDestination();
    // get the weight of the edge
    int getWeight();
}