package treeQ3;

import java.util.*;
import java.util.Iterator;

/**
 * Represents a generic TreeNode that can be used to create a binary tree.
 *
 * @param <T> The type of data stored in the tree nodes.
 */
class TreeNode<T> implements Iterable<TreeNode<T>> {
    T value;
    TreeNode<T> left, right;

    /**
     * Creates a new TreeNode with the specified value.
     *
     * @param value The value to be stored in the node.
     */
    public TreeNode(T value) {
        this.value = value;
        this.left = this.right = null;
    }

    /**
     * Displays the arithmetic expression in infix order.
     */
    public void displayInfix() {
        if (left != null || right != null) {
            System.out.print("(");
        }

        if (left != null) {
            left.displayInfix();
        }

        System.out.print(value);

        if (right != null) {
            right.displayInfix();
        }

        if (left != null || right != null) {
            System.out.print(")");
        }
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return new TreeIterator(this);
    }

    private class TreeIterator implements Iterator<TreeNode<T>> {
        Stack<TreeNode<T>> stack;

        public TreeIterator(TreeNode<T> root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        private void pushLeft(TreeNode<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

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
