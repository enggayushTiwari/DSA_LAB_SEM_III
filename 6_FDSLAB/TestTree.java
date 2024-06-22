import java.util.*;

// A class to test the tree data structure
public class TestTree {
    // A method to display the menu options
    public static void displayMenu() {
        System.out.println("1: Create a tree");
        System.out.println("2: Add child to a node");
        System.out.println("3: Display the tree");
        System.out.println("4: Size of the tree");
        System.out.println("5: Height of the tree");
        System.out.println("6: Leaves of the tree");
        System.out.println("7: Internal nodes of tree");
        System.out.println("8: Edges of the tree");
        System.out.println("9: Siblings of a node");
        System.out.println("10: Depth of a node");
        System.out.println("11: Path of a node");
        System.out.println("12: Subtree of a node");
        System.out.println("13: Quit");
        System.out.print("\nMake your choice: ");
    }
    
    // A method to get a node from the user input
    public static TreeNode<String> getNode(Tree<String> tree, Scanner sc) {
        System.out.print("Enter the data of the node: ");
        String data = sc.next();
        for (TreeNode<String> node : tree.positions()) {
            if (node.getData().equals(data)) {
                return node; // return the node if found
            }
        }
        return null; // return null if not found
    }
    
    // The main method to run the test application
    public static void main(String[] args) {
        System.out.println("\n*****************************************************::WELCOME TO THE TREE TEST APPLICATION::***************************************************************");
        Scanner sc = new Scanner(System.in); // create a scanner object
        Tree<String> tree = null; // initialize the tree as null
        int choice; // declare a variable to store the user choice
        while (true) { // loop until the user quits
            displayMenu(); // display the menu options
            choice = sc.nextInt(); // read the user choice
            switch (choice) {
                case 1: // create a tree
                    System.out.print("Enter the data of the root node: ");
                    String rootData = sc.next();
                    TreeNode<String> root = new TreeNode<>(rootData); // create a root node
                    tree = new Tree<>(root); // create a tree with the root node
                    System.out.println("Tree created successfully.");
                    break;
                case 2: // add a child to a node
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    TreeNode<String> parent = getNode(tree, sc); // get the parent node
                    if (parent == null) {
                        System.out.println("No such node found.");
                        break;
                    }
                    System.out.print("Enter the data of the child node: ");
                    String childData = sc.next();
                    TreeNode<String> child = new TreeNode<>(childData); // create a child node
                    parent.addChild(child); // add the child to the parent
                    tree.setSize(tree.getSize() + 1); // increment the size of the tree
                    System.out.println("Child added successfully.");
                    break;
                case 3: // display the tree
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    System.out.println("The tree is:");
                    tree.print(); // print the tree
                    break;
                case 4: // display the size of the tree
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    System.out.println("The size of the tree is: " + tree.getSize());
                    break;
                case 5: // display the height of the tree
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    System.out.println("The height of the tree is: " + tree.getHeight());
                    break;
                case 6: // display the leaves of the tree
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    System.out.println("The leaves of the tree are:");
                    for (TreeNode<String> node : tree.getLeaves()) {
                        node.print();
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;
                case 7: // display the internal nodes of the tree
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    System.out.println("The internal nodes of the tree are:");
                    for (TreeNode<String> node : tree.getInternalNodes()) {
                        node.print();
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;
                case 8: // display the edges of the tree
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    System.out.println("The edges of the tree are:");
                    for (String edge : tree.getEdges()) {
                        System.out.print(edge + " ");
                    }
                    System.out.println();
                    break;
                case 9: // display the siblings of a node
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    TreeNode<String> node = getNode(tree, sc); // get the node
                    if (node == null) {
                        System.out.println("No such node found.");
                        break;
                    }
                    System.out.println("The siblings of the node are:");
                    for (TreeNode<String> sibling : node.getSiblings()) {
                        sibling.print();
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;
                case 10: // display the depth of a node
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    node = getNode(tree, sc); // get the node
                    if (node == null) {
                        System.out.println("No such node found.");
                        break;
                    }
                    System.out.println("The depth of the node is: " + node.getDepth());
                    break;
                case 11: // display the path of a node
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    node = getNode(tree, sc); // get the node
                    if (node == null) {
                        System.out.println("No such node found.");
                        break;
                    }
                    System.out.println("The path of the node is:");
                    for (TreeNode<String> p : node.getPath()) {
                        p.print();
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;
                case 12: // display the subtree of a node
                    if (tree == null) {
                        System.out.println("Please create a tree first.");
                        break;
                    }
                    node = getNode(tree, sc); // get the node
                    if (node == null) {
                        System.out.println("No such node found.");
                        break;
                    }
                    System.out.println("The subtree of the node is:");
                    Tree<String> subtree = tree.getSubtree(node); // get the subtree
                    subtree.print(); // print the subtree
                    break;
                case 13: // quit
                    System.out.println("Thank you for using the Tree Test Application.");
                    System.exit(0); // exit the program
                default: // invalid choice
                    System.out.println("Invalid choice!!! Please make a valid choice.");
            }
        }
    }
}