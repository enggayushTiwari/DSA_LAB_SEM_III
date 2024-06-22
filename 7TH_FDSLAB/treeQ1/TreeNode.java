package treeQ1;
import java.util.*;
import java.util.Iterator;


/**
 * Represents a generic TreeNode that can be used to create a tree structure.
 *
 * @param <T> The type of data stored in the tree nodes.
 */
class TreeNode<T> implements Iterable<TreeNode<T>> {
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    /**
     * Constructs a new TreeNode with the specified data.
     *
     * @param data The data to be stored in the node.
     */
    public TreeNode(T data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    /**
     * Gets the data stored in the node.
     *
     * @return The data of the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Gets the parent of the node.
     *
     * @return The parent of the node.
     */
    public TreeNode<T> getParent() {
        return parent;
    }

    /**
     * Gets the list of children of the node.
     *
     * @return The list of children of the node.
     */
    public List<TreeNode<T>> getChildren() {
        return children;
    }

    /**
     * Adds a child to the node.
     *
     * @param child The child node to be added.
     */
    public void addChild(TreeNode<T> child) {
        child.parent = this;
        children.add(child);
    }

    /**
     * Returns an iterator over the children of the node.
     *
     * @return An iterator over the children of the node.
     */
    @Override
    public Iterator<TreeNode<T>> iterator() {
        return children.iterator();
    }
}
