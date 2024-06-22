package treeQ4;

import java.util.*;

/**
 * A class to test the tree implementation.
 */
public class treeTestExample_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode<Integer> root = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a tree");
            System.out.println("2. Display the tree in pre-order");
            System.out.println("3. Iterate over the tree using iterator");
            System.out.println("4. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the root node data:");
                        int rootData = scanner.nextInt();
                        root = new TreeNode<>(rootData);
                        createTree(root, scanner);
                        break;
                    case 2:
                        displayPreOrder(root);
                        break;
                    case 3:
                        iterateTree(root);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        scanner.close();
    }

    /**
     * Creates a tree based on user input.
     *
     * @param node    The root node of the tree.
     * @param scanner The Scanner object for user input.
     */
    private static void createTree(TreeNode<Integer> node, Scanner scanner) {
        System.out.print("Enter left child of " + node.data + " or -1 for no child:");
        int data = scanner.nextInt();
        if (data != -1) {
            node.left = new TreeNode<>(data);
            createTree(node.left, scanner);
        }

        System.out.print("Enter right child of " + node.data + " or -1 for no child:");
        data = scanner.nextInt();
        if (data != -1) {
            node.right = new TreeNode<>(data);
            createTree(node.right, scanner);
        }
    }

    /**
     * Displays the tree in pre-order.
     *
     * @param root The root of the tree.
     */
    private static void displayPreOrder(TreeNode<Integer> root) {
        if (root == null) {
            System.out.println("The tree is empty!");
        } else {
            System.out.println("The tree in pre-order is:");
            TreeNode.displayPreOrder(root, 0);
        }
    }

    /**
     * Iterates over the tree using an iterator.
     *
     * @param root The root of the tree.
     */
    private static void iterateTree(TreeNode<Integer> root) {
        if (root == null) {
            System.out.println("The tree is empty!");
        } else {
            System.out.print("Iterating over the tree: ");
            for (TreeNode<Integer> node : root) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}
