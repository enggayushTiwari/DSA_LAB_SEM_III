// define the InnerEdge class that implements the Edge interface
public class InnerEdge implements Edge {
    // the source vertex of the edge
    private Vertex source;
    // the destination vertex of the edge
    private Vertex destination;
    // the weight of the edge
    private int weight;
    // the constructor of the InnerEdge class
    public InnerEdge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    // get the source vertex of the edge
    public Vertex getSource() {
        return source;
    }
    // get the destination vertex of the edge
    public Vertex getDestination() {
        return destination;
    }
    // get the weight of the edge
    public int getWeight() {
        return weight;
    }
    // override the equals method to compare two edges by their source and destination vertices
    public boolean equals(Object o) {
        if (o instanceof InnerEdge) {
            InnerEdge e = (InnerEdge) o;
            return source.equals(e.source) && destination.equals(e.destination);
        }
        return false;
    }
    // override the hashCode method to generate a hash code based on the source and destination vertices
    public int hashCode() {
        return source.hashCode() + destination.hashCode();
    }
    // override the toString method to return the source, destination and weight of the edge
    public String toString() {
        return "(" + source + ", " + destination + ", " + weight + ")";
    }
}
