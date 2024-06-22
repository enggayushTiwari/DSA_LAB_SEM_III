// define the InnerVertex class that implements the Vertex interface
public class InnerVertex implements Vertex {
    // the label of the vertex
    private String label;
    // the position of the vertex in the vertex array
    private int position;
    // the constructor of the InnerVertex class
    public InnerVertex(String label, int position) {
        this.label = label;
        this.position = position;
    }
    // get the label of the vertex
    public String getLabel() {
        return label;
    }
    // get the position of the vertex
    public int getPosition() {
        return position;
    }
    // override the equals method to compare two vertices by their labels
    public boolean equals(Object o) {
        if (o instanceof InnerVertex) {
            InnerVertex v = (InnerVertex) o;
            return label.equals(v.label);
        }
        return false;
    }
    // override the hashCode method to generate a hash code based on the label
    public int hashCode() {
        return label.hashCode();
    }
    // override the toString method to return the label of the vertex
    public String toString() {
        return label;
    }
}
