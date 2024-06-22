package treeQ1;


/**
 * Represents a generic tree structure.
 *
 * @param <T> The type of data stored in the tree nodes.
 */
class Tree<T> {
    private TreeNode<T> root;

    /**
     * Constructs a new tree with the specified root data.
     *
     * @param rootData The data for the root of the tree.
     */
    public Tree(T rootData) {
        root = new TreeNode<>(rootData);
    }

    /**
     * Gets the root of the tree.
     *
     * @return The root of the tree.
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Prints the tree in the desired format.
     */
    public void printTree() {
        StringBuilder sb = new StringBuilder();
        printTreeHelper(root, sb, 0, "");
        System.out.println(sb.toString());
    }

    private void printTreeHelper(TreeNode<T> node, StringBuilder sb, int level, String prefix) {
        for (int i = 0; i < level; i++) {
            sb.append("    ");
        }
        if (!prefix.isEmpty()) {
            sb.append(prefix).append(" ");
        }
        sb.append(node.getData()).append("\n");

        int count = 1;
        for (TreeNode<T> child : node) {
            String newPrefix = prefix.isEmpty() ? String.valueOf(count) : prefix + "." + count;
            printTreeHelper(child, sb, level + 1, newPrefix);
            count++;
        }
    }
}
