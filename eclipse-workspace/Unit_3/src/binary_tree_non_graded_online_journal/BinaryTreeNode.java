package binary_tree_non_graded_online_journal;

/**
 * An object of type BinaryTreeNode represents one node in a binary tree of
 * strings.
 */
public class BinaryTreeNode {
	int item;// The data in this node.
	BinaryTreeNode left; // Pointer to left subtree.
	BinaryTreeNode right; // Pointer to right subtree.

	public BinaryTreeNode(int item) {
		// Constructor. Make a node containing item.
		// Left and right pointers are null.
		this.item = item;
		this.left = null; // Pointer to left subtree.
		this.right = null;
	}
} // end class BinaryTreeNode