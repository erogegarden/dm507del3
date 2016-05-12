
/**
 * Authors:
 * Janosa Vijayathurai - javij15@student.sdu.dk
 * Phillip Geisler - phgei15@student.sdu.dk
 * Rasmus Bang Poulsen - rapou15@student.sdu.dk
 * 
 * DictBinTree is a class which implements the interface Dict. In this class we
 * have methods to insert new keys into a binary tree, go through the tree and return an array of ordered keys,
 * and methods for searching for a specific key in the tree. Here we also define
 * the first node object to be the root.
 */
public class DictBinTree implements Dict {

	private Node root;
	private int number;
	private int counter;
	private int[] sorted;

	DictBinTree() {
	}

	/*
	 * Insert is a method where we first initialize y to be a node with the
	 * value null and x to be our root node. If the root is not
	 * null we make a new node using the key k to be the root. If the root key is bigger than our
	 * input integer k. We put our integer in the nodes left child (small
	 * values). If the root key is smaller we put our k in the right child (big
	 * values).
	 */

	public void insert(int k) {
		Node y = null;
		Node x = root;

		while (x != null) {

			y = x;
			if (k < x.key) {
				x = x.left;

			} else {
				x = x.right;

			}
		}

		if (y == null) {
			this.root = new Node(null, null, k);
			this.number = 1;
		} else if (k < y.key) {
			y.left = new Node(null, null, k);
			this.number = this.number + 1;
		} else {
			y.right = new Node(null, null, k);
			this.number = this.number + 1;
		}
	}

	/*
	 * orderedTraversal makes an array size 'numbers' and uses treeWalk to fill it with the keys in the tree in order.
	 * It then returns the array 'sorted'
	 */
	public int[] orderedTraversal() {

		this.sorted = new int[this.number];
		counter = 0;
		treeWalk(root);
		return sorted;
	}

	/*
	 * treeWalk recursively goes through the tree and saves the values in the array named
	 * sorted. First it takes the smallest values in the tree by going from the far left
	 * and the array will save the values while the counter increases and it 'walks over the keys from left to right
	 */

	private void treeWalk(Node x) {
		if (x != null) {
			treeWalk(x.left);
			this.sorted[counter] = x.key;
			this.counter++;
			treeWalk(x.right);
		}
	}

	/*
	 * Method search takes an integer k as variable, and calls treeSearch with
	 * the integer. This method will return null if the integer k is not in the tree or a reference to the node
	 * where it was found, as x, if it is in the tree. It then return either true or false based on the value of x
	 */
	public boolean search(int k) {
		// TODO Auto-generated method stub
		Node x = treeSearch(root, k);
		return x != null;
	}

	/*
	 * treeSearch is a method which takes a Node 'x' and integer 'k' as
	 * variables. If node x is null or input k is equal to key of node, then
	 * return the current Node x. If k is smaller than the key then call treeSearch again
	 * with the nodes left child as node instead. And if k is bigger than the
	 * key call the method again with right child as the node.
	 */
	private Node treeSearch(Node x, int k) {
		if (x == null || k == x.key) {
			return x;
		}
		if (k < x.key) {
			return treeSearch(x.left, k);
		} else {
			return treeSearch(x.right, k);
		}
	}

}
