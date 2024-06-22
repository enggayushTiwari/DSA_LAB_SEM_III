package treeQ1;
import java.util.*;

/**
 * A class to test the tree implementation.
 */
public class testTreeExample_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree<String> tree = new Tree<>("ElectronicsR'Us");
        boolean exit = false;

        while (!exit) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add a node to the tree");
            System.out.println("2. Print the tree");
            System.out.println("3. Exit the program");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addNodeToTree(tree, sc);
                        break;
                    case 2:
                        tree.printTree();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the invalid input
            }
        }

        sc.close();
    }

    private static void addNodeToTree(Tree<String> tree, Scanner sc) {
        System.out.println("Enter the parent data:");
        String parentData = sc.next();
        System.out.println("Enter the child data:");
        String childData = sc.next();
        TreeNode<String> parentNode = findNode(tree.getRoot(), parentData);

        if (parentNode != null) {
            parentNode.addChild(new TreeNode<>(childData));
            System.out.println("Node added successfully.");
        } else {
            System.out.println("Parent node not found.");
        }
    }

    private static TreeNode<String> findNode(TreeNode<String> node, String data) {
        if (node == null) {
            return null;
        }

        if (node.getData().equals(data)) {
            return node;
        }

        for (TreeNode<String> child : node) {
            TreeNode<String> result = findNode(child, data);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}