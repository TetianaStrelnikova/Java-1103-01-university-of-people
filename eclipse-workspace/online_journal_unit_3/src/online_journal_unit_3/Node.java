package online_journal_unit_3;

class Node {
    /**
     * A class representing a node in a binary sort tree.
     */
    int data;
    Node left;
    Node right;

    /**
     * Constructs a new Node object with the given data value.
     *
     * @param data The value to be stored in the node.
     */
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}