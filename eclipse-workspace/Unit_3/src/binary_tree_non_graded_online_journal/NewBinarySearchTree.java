package binary_tree_non_graded_online_journal;

//import java.util.Random;

public class NewBinarySearchTree {
	int depth;
	//static Random r = new Random();
	static final int SIZE = 1023;
	static final int MAX_VALUE = 1000;
	BinaryTreeNode root = null;
	public NewBinarySearchTree() {
		for (int i = 1; i <= SIZE; i++) {
			int item = (int)(Math.random() * (MAX_VALUE - 0 + 1)) + 0;
			root = treeInsert(root, item);
		}
		

	}

	/**
	 * Inserts an integer item into a binary search tree rooted at root.
	 * 
	 * @param root the root of the tree to insert into
	 * @param item the item to be inserted into the tree
	 * @return the root of the updated tree with the new item inserted in the
	 *         correct position
	 */
	static BinaryTreeNode treeInsert(BinaryTreeNode root, int item) {
		// if the root is null, the tree is empty, so create a new node containing the
		// item and return it as the new root
		if (root == null)
			{return new BinaryTreeNode(item);}
		// if the item is less than the root's item, insert it into the left subtree
		else if (item < root.item)
			// recursively call treeInsert() on the left subtree with the left subtree as
			// the new root and the item to be inserted
			{root.left = treeInsert(root.left, item);}
		// if the item is greater than the root's item, insert it into the right subtree
		else if (item > root.item)
				// recursively call treeInsert() on the right subtree with the right subtree as
				// the new root and the item to be inserted
			{root.right = treeInsert(root.right, item);}
		
		else if (item == root.item) {return root;}
		// return the root of the tree with the new item inserted in the correct position
		return root;
	}

	public void countLeaves() {
	}

	public void sumOfDebthOfLeaves() {
	}

	public void maxOfDebthOfLeaves() {
	}

	public void inorderTraversal(BinaryTreeNode root, int[] array, int index) {
		if (root != null) {
			inorderTraversal(root.right, array, index);
			array[index] = root.item;
			inorderTraversal(root.left, array, index + 1);
		}
	}
	public void printInOrder(BinaryTreeNode root) {
	    if (root == null) {
	        return;
	    }
	    printInOrder(root.left);
	    System.out.print(root.item + " ");
	    printInOrder(root.right);
	}
	public static void main(String[] args) {
		NewBinarySearchTree first = new NewBinarySearchTree();
		
	}
}
