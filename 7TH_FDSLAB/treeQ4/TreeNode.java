package treeQ4;

import java.util.*;

/**
 * Represents a generic TreeNode that can be used to create a binary tree.
 *
 * @param <T> The type of data stored in the tree nodes.
 */
class TreeNode<T> implements Iterable<TreeNode<T>> {
    T data;
    TreeNode<T> left, right;

    /**
     * Constructs a new TreeNode with the specified data.
     *
     * @param data The data to be stored in the node.
     */
    public TreeNode(T data) {
        this.data = data;
        this.left = this.right = null;
    }

    /**
     * Performs a pre-order traversal and displays the tree.
     *
     * @param root   The root of the tree.
     * @param depth  The depth of the current node in the tree.
     */
    protected static <T> void displayPreOrder(TreeNode<T> root, int depth) {
        if (root != null) {
            // Display the current node
            displayNode(root, depth);

            // Recursively display the left and right subtrees
            displayPreOrder(root.left, depth + 1);
            displayPreOrder(root.right, depth + 1);
        }
    }

    /**
     * Helper method to display a node with proper indentation.
     *
     * @param node   The node to be displayed.
     * @param depth  The depth of the current node in the tree.
     */
    private static <T> void displayNode(TreeNode<T> node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("|    ");
        }
        System.out.println("└── " + node.data);
    }

    /**
     * Returns an iterator over the elements in the tree.
     *
     * @return An iterator over the elements in the tree.
     */
    @Override
    public Iterator<TreeNode<T>> iterator() {
        return new TreeIterator(this);
    }

    /**
     * Represents an iterator over the elements in the tree.
     */
    private class TreeIterator implements Iterator<TreeNode<T>> {
        Stack<TreeNode<T>> stack;

        /**
         * Constructs a new TreeIterator with the specified root.
         *
         * @param root The root of the tree.
         */
        public TreeIterator(TreeNode<T> root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        /**
         * Pushes the left children of the node onto the stack.
         *
         * @param node The current node.
         */
        private void pushLeft(TreeNode<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * Checks if there are more nodes to iterate over.
         *
         * @return true if there are more nodes, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * Returns the next node in the iteration.
         *
         * @return The next node in the iteration.
         * @throws NoSuchElementException if there are no more nodes.
         */
        @Override
        public TreeNode<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes!");
            }
            TreeNode<T> node = stack.pop();
            pushLeft(node.right);
            return node;
        }
    }
}
