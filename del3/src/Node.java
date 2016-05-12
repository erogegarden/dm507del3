/**
 * @authors:
 *
 * 			In class Node we define our object node which has two objects and a
 *          integer as a key. The two object for one node is its left and right
 *          child.
 */

public class Node {
    public Node left;
    public Node right;
    public int key;

    public Node(Node left, Node right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

}