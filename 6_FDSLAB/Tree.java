import java.util.*;

// A class to represent a tree
class Tree<T> {
    // The root of the tree
    private TreeNode<T> root;
    
    // The size of the tree
    private int size;
    
    // Constructor to create an empty tree
    public Tree() {
        this.root = null;
        this.size = 0;
    }
    
    // Constructor to create a tree with a given root node
    public Tree(TreeNode<T> root) {
        this.root = root;
        this.size = 1;
    }
    
    // Getter and setter methods for root and size
    public TreeNode<T> getRoot() {
        return root;
    }
    
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    // A method to check if the tree is empty
    public boolean isEmpty() {
        return this.root == null;
    }
    
    // A method to get the height of the tree
    public int getHeight() {
        return getHeight(root);
    }
    
    // A helper method to get the height of a subtree rooted at a given node
    private int getHeight(TreeNode<T> node) {
        if (node == null) {
            return -1; // base case: empty subtree has height -1
        }
        int max = -1; // initialize the maximum height
        for (TreeNode<T> child : node.getChildren()) {
            int height = getHeight(child); // get the height of each child
            if (height > max) {
                max = height; // update the maximum height
            }
        }
        return 1 + max; // height of subtree is 1 + maximum height of children
    }
    
    // A method to get an iterator for the tree elements
    public Iterator<T> iterator() {
        return new TreeIterator();
    }
    
    // A class to implement the iterator interface for the tree
    private class TreeIterator implements Iterator<T> {
        // A queue to store the nodes in the order of traversal
        private Queue<TreeNode<T>> queue;
        
        // Constructor to initialize the queue with the root node
        public TreeIterator() {
            queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
        }
        
        // A method to check if there is a next element in the traversal
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        
        // A method to return the next element in the traversal
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeNode<T> node = queue.remove(); // remove the front node from the queue
            for (TreeNode<T> child : node.getChildren()) {
                queue.add(child); // add the children of the node to the queue
            }
            return node.getData(); // return the data of the node
        }
    }
    
    // A method to get an iterable collection of all the positions of the tree
    public Iterable<TreeNode<T>> positions() {
        return new PositionIterable();
    }
    
    // A class to implement the iterable interface for the positions of the tree
    private class PositionIterable implements Iterable<TreeNode<T>> {
        // A method to return an iterator for the positions of the tree
        public Iterator<TreeNode<T>> iterator() {
            return new PositionIterator();
        }
    }
    
    // A class to implement the iterator interface for the positions of the tree
    private class PositionIterator implements Iterator<TreeNode<T>> {
        // A queue to store the nodes in the order of traversal
        private Queue<TreeNode<T>> queue;
                // Constructor to initialize the queue with the root node
        public PositionIterator() {
            queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
        }
        
        // A method to check if there is a next position in the traversal
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        
        // A method to return the next position in the traversal
        public TreeNode<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeNode<T> node = queue.remove(); // remove the front node from the queue
            for (TreeNode<T> child : node.getChildren()) {
                queue.add(child); // add the children of the node to the queue
            }
            return node; // return the node
        }
    }
    
    // A method to get the list of leaves of the tree
    public List<TreeNode<T>> getLeaves() {
        List<TreeNode<T>> leaves = new ArrayList<>();
        for (TreeNode<T> node : positions()) {
            if (node.isLeaf()) {
                leaves.add(node);
            }
        }
        return leaves;
    }
    
    // A method to get the list of internal nodes of the tree
    public List<TreeNode<T>> getInternalNodes() {
        List<TreeNode<T>> internalNodes = new ArrayList<>();
        for (TreeNode<T> node : positions()) {
            if (node.isInternal()) {
                internalNodes.add(node);
            }
        }
        return internalNodes;
    }
    
    // A method to get the list of edges of the tree
    public List<String> getEdges() {
        List<String> edges = new ArrayList<>();
        for (TreeNode<T> node : positions()) {
            if (!node.isRoot()) {
                edges.add("(" + node.getParent().getData() + ", " + node.getData() + ")");
            }
        }
        return edges;
    }
    
    // A method to get the subtree rooted at a given node
    public Tree<T> getSubtree(TreeNode<T> node) {
        if (node == null) {
            return null; // no subtree for null node
        }
        Tree<T> subtree = new Tree<>(node); // create a new tree with the node as root
        subtree.setSize(getSize(node)); // set the size of the subtree as the size of the node
        return subtree;
    }
    
    // A helper method to get the size of a node
    private int getSize(TreeNode<T> node) {
        if (node == null) {
            return 0; // base case: null node has size 0
        }
        int size = 1; // initialize the size with 1
        for (TreeNode<T> child : node.getChildren()) {
            size += getSize(child); // add the size of each child
        }
        return size; // return the size
    }
    
    // A method to print the tree in a pre-order traversal
    public void print() {
        print(root, 0); // start from the root with level 0
    }
    
    // A helper method to print a subtree rooted at a given node with a given level
    private void print(TreeNode<T> node, int level) {
        if (node == null) {
            return; // base case: do nothing for null node
        }
        for (int i = 0; i < level; i++) {
            System.out.print("  "); // indent according to the level
        }
        node.print(); // print the data of the node
        System.out.println(); // move to the next line
        for (TreeNode<T> child : node.getChildren()) {
            print(child, level + 1); // print each child with one more level
        }
    }
}
