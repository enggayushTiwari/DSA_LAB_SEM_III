package treeQ3;

import java.util.*;


/**
 * Represents a test program for creating and manipulating a binary tree.
 */
public class testTreeExample_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode<String> root = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a tree");
            System.out.println("2. Display arithmetic expression: ");
            System.out.println("3. Iterate over the tree using iterator");
            System.out.println("4. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter the root value:");
                        String rootValue = scanner.nextLine();
                        root = new TreeNode<>(rootValue);
                        buildTree(root, scanner);
                        break;
                    case 2:
                        displayInfix(root);
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
            } catch (NoSuchElementException e) {
                System.out.println("No more nodes!");
            }
        }

        scanner.close();
    }

    private static void buildTree(TreeNode<String> node, Scanner scanner) {
        try {
            System.out.println("Enter left child for " + node.value + " (or type 'e' for no child):");
            String leftValue = scanner.nextLine();
            if (!leftValue.equals("e")) {
                node.left = new TreeNode<>(leftValue);
                buildTree(node.left, scanner);
            }

            System.out.println("Enter right child for " + node.value + " (or type 'e' for no child):");
            String rightValue = scanner.nextLine();
            if (!rightValue.equals("e")) {
                node.right = new TreeNode<>(rightValue);
                buildTree(node.right, scanner);
            }
        } catch (Exception e) {
            System.out.println("Error while building the tree: " + e.getMessage());
        }
    }

    private static void displayInfix(TreeNode<String> root) {
        if (root == null) {
            System.out.println("The tree is empty!");
        } else {
            System.out.print("Arithmetic expression in infix order: ");
            root.displayInfix();
            System.out.println();
        }
    }

    private static void iterateTree(TreeNode<String> root) {
        if (root == null) {
            System.out.println("The tree is empty!");
        } else {
            System.out.print("Iterating over the tree: ");
            for (TreeNode<String> node : root) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }
}
