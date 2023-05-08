package online_journal_unit_3;

/*Output
Average depth: 11,65
Maximum depth: 20

Average depth: 11,95
Maximum depth: 21

Average depth: 12,29
Maximum depth: 23

 */

import java.util.Random;

public class BinarySortTree {
	/**
	 * Inserts a new node with the given data value into the binary sort tree rooted
	 * at `root`.
	 *
	 * @param root The root of the binary sort tree.
	 * @param data The value to insert.
	 * @return The modified root node.
	 */
	public static Node treeInsert(Node root, int data) {
		// If the root is null, create a new node with the given data value
		if (root == null) {
			return new Node(data);
		}
		// If the data value is less than the root, insert it into the left subtree
		else if (data < root.data) {
			root.left = treeInsert(root.left, data);
		}
		// Otherwise, insert it into the right subtree
		else {
			root.right = treeInsert(root.right, data);
		}
		// Return the modified root node
		return root;
	}

	/**
	 * Counts the number of leaves in the binary sort tree rooted at `node`.
	 *
	 * @param node The root of the binary sort tree.
	 * @return The number of leaves in the tree.
	 */
	public static int countLeaves(Node node) {
		// If the node is null, there are no leaves
		if (node == null) {
			return 0;
		}
		// If the node is a leaf, there is exactly one leaf
		if (node.left == null && node.right == null) {
			return 1;
		}
		// Otherwise, recurse on the left and right subtrees and combine the results
		return countLeaves(node.left) + countLeaves(node.right);
	}

	/**
	 * Computes the sum of depths of all leaves in the binary sort tree rooted at
	 * `node`.
	 *
	 * @param node  The root of the binary sort tree.
	 * @param depth The current depth in the tree.
	 * @return The sum of depths of all leaves in the tree.
	 */
	public static int sumLeafDepths(Node node, int depth) {
		// If the node is null, there are no leaves
		if (node == null) {
			return 0;
		}
		// If the node is a leaf, its depth is the given depth
		if (node.left == null && node.right == null) {
			return depth;
		}
		// Otherwise, recurse on the left and right subtrees and combine the results
		return sumLeafDepths(node.left, depth + 1) + sumLeafDepths(node.right, depth + 1);
	}

	/**
	 * Computes the maximum depth among all the leaves in the binary sort tree
	 * rooted at `node`.
	 *
	 * @param node  The root of the binary sort tree.
	 * @param depth The current depth in the tree.
	 * @return The maximum depth among all the leaves in the tree.
	 */
	public static int maxLeafDepth(Node node, int depth) {
		// If the node is null, there are no leaves
		if (node == null) {
			return depth;
		}
		// Otherwise, recurse on the left and right subtrees and return 
		// depth from left and right
		return Math.max(maxLeafDepth(node.left, depth + 1), maxLeafDepth(node.right, depth + 1));
	}

	public static void main(String[] args) {
		// Create a new random number generator
		Random random = new Random();
		// Create an empty binary sort tree
		Node root = null;

		// Insert 1023 random double values into the tree
		for (int i = 0; i < 1023; i++) {
			root = treeInsert(root, random.nextInt());
		}

		// Count the average depth and maximum depth of all leaves in the tree
		int numLeaves = countLeaves(root);
		int sumDepths = sumLeafDepths(root, 0);
		double avgDepth = (double) sumDepths / numLeaves;
		int maxDepth = maxLeafDepth(root, 0);

		// Print the results to the console
		System.out.printf("Average depth: %.2f%n", avgDepth);
		System.out.printf("Maximum depth: %d%n", maxDepth);
	}
}