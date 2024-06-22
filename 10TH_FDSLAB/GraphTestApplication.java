import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class GraphTestApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new AdjacencyMapGraph(10); // You can adjust the capacity as needed

        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Vertex");
            System.out.println("2. Insert Edge");
            System.out.println("3. Display Vertices");
            System.out.println("4. Display Edges");
            System.out.println("5. Display Outgoing Edges");
            System.out.println("6. Display Incoming Edges");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the label for the new vertex: ");
                        String label = scanner.nextLine();
                        Vertex v = graph.insertVertex(label);
                        System.out.println("Vertex " + v.getLabel() + " inserted successfully.");
                        break;

                    case 2:
                        System.out.print("Enter the label of the source vertex: ");
                        String sourceLabel = scanner.nextLine();
                        Vertex sourceVertex = findVertex(graph, sourceLabel);

                        System.out.print("Enter the label of the destination vertex: ");
                        String destLabel = scanner.nextLine();
                        Vertex destVertex = findVertex(graph, destLabel);

                        System.out.print("Enter the weight of the edge: ");
                        int weight = scanner.nextInt();
                        Edge e = graph.insertEdge(sourceVertex, destVertex, weight);
                        System.out.println("Edge " + e + " inserted successfully.");
                        break;

                    case 3:
                        System.out.println("Vertices:");
                        displayVertices(graph);
                        break;

                    case 4:
                        System.out.println("Edges:");
                        displayEdges(graph);
                        break;

                    case 5:
                        System.out.print("Enter the label of the vertex: ");
                        String outVertexLabel = scanner.nextLine();
                        Vertex outVertex = findVertex(graph, outVertexLabel);
                        displayOutgoingEdges(graph, outVertex);
                        break;

                    case 6:
                        System.out.print("Enter the label of the vertex: ");
                        String inVertexLabel = scanner.nextLine();
                        Vertex inVertex = findVertex(graph, inVertexLabel);
                        displayIncomingEdges(graph, inVertex);
                        break;

                    case 7:
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void displayVertices(Graph graph) {
        Iterator<Vertex> iterator = graph.vertices();
        while (iterator.hasNext()) {
            Vertex v = iterator.next();
            System.out.println(v.getLabel());
        }
    }

    private static void displayEdges(Graph graph) {
        Iterator<Edge> iterator = graph.edges();
        while (iterator.hasNext()) {
            Edge e = iterator.next();
            System.out.println(e);
        }
    }

    private static void displayOutgoingEdges(Graph graph, Vertex v) {
        Iterator<Edge> iterator = graph.outGoingEdges(v);
        while (iterator.hasNext()) {
            Edge e = iterator.next();
            System.out.println(e);
        }
    }

    private static void displayIncomingEdges(Graph graph, Vertex v) {
        Iterator<Edge> iterator = graph.inComingEdges(v);
        while (iterator.hasNext()) {
            Edge e = iterator.next();
            System.out.println(e);
        }
    }

    private static Vertex findVertex(Graph graph, String label) {
        Iterator<Vertex> iterator = graph.vertices();
        while (iterator.hasNext()) {
            Vertex v = iterator.next();
            if (v.getLabel().equals(label)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Vertex with label " + label + " not found.");
    }
}
