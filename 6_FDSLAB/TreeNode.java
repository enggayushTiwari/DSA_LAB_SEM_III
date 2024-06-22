import java.util.*;

// A class to represent a node of a tree
class TreeNode<T> {
    // Data stored at this node
    private T data;
    
    // Parent of this node
    private TreeNode<T> parent;
    
    // Children of this node
    private List<TreeNode<T>> children;
    
    // Constructor to create a node with given data
    public TreeNode(T data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
    }
    
    // Getter and setter methods for data, parent and children
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public TreeNode<T> getParent() {
        return parent;
    }
    
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }
    
    public List<TreeNode<T>> getChildren() {
        return children;
    }
    
    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
    
    // A method to add a child to this node
    public void addChild(TreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }
    
    // A method to check if this node is a leaf
    public boolean isLeaf() {
        return this.children.isEmpty();
    }
    
    // A method to check if this node is the root
    public boolean isRoot() {
        return this.parent == null;
    }
    
    // A method to check if this node is an internal node
    public boolean isInternal() {
        return !this.isLeaf() && !this.isRoot();
    }
    
    // A method to get the siblings of this node
    public List<TreeNode<T>> getSiblings() {
        List<TreeNode<T>> siblings = new ArrayList<>();
        if (this.isRoot()) {
            return siblings; // root has no siblings
        }
        for (TreeNode<T> node : this.parent.getChildren()) {
            if (node != this) {
                siblings.add(node);
            }
        }
        return siblings;
    }
    
    // A method to get the depth of this node
    public int getDepth() {
        if (this.isRoot()) {
            return 0; // root has depth 0
        }
        return 1 + this.parent.getDepth();
    }
    
    // A method to get the path from this node to the root
    public List<TreeNode<T>> getPath() {
        List<TreeNode<T>> path = new ArrayList<>();
        TreeNode<T> current = this;
        while (current != null) {
            path.add(current);
            current = current.getParent();
        }
        Collections.reverse(path); // reverse the order to get root to node path
        return path;
    }
    
    // A method to print the data of this node
    public void print() {
        System.out.print(this.data);
    }
}
