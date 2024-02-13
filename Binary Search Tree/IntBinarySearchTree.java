import java.util.ArrayList;


public class IntBinarySearchTree {
	
	static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}	
	}
	
	Node root;
	
	IntBinarySearchTree(int rootValue){
        this.root = new Node(rootValue);
	}
	
	/**
	 * Add a node to a BinaryTree
	 * @param node The node to add.
	 */
	public void add(Node node) {
		add(node, this.root);
	}

    private void add(Node node, Node cur) {
        if((cur.left == null) && node.value < cur.value){
            cur.left = node;
            return;
        } else if((cur.right == null) && node.value > cur.value){
            cur.right = node;
            return;
        } else if(node.value < cur.value){
            cur = cur.left;
        } else if(node.value > cur.value){
            cur = cur.right;
        }
        add(node, cur);

    }

	/**
     * Create a binary tree from an array.
     *
     * The array lists numbers in layer order, with negative numbers as "holes".
     * So the tree:
     *
     *       4
     *      / \
     *     2   5
     *    / \   \
     *   1   3   6
     *  /
     * 0
     *
     * can be created from the array:
     *
     * {4, 2, 5, 1, 3, -1, 6, 0}
     * 
     * Note that this is not necessarily a binary *search* tree.
     * Overwrites the current tree.
     *
     * @param array The array of integers that form the tree.
     */
	public void addAll(int[] array) {
		
		  // create all the nodes for the tree
        Node[] nodes = new Node[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                nodes[i] = null;
            } else {
                nodes[i] = new Node(array[i]);
            }
        }
        // link the nodes (ask me about this when we get to heaps!)
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                continue;
            }
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if (leftIndex < nodes.length) {
                nodes[i].left = nodes[leftIndex];
            }
            if (rightIndex < nodes.length) {
                nodes[i].right = nodes[rightIndex];
            }
        }
        // set the root and the size
        if (nodes.length > 0) {
            this.root = nodes[0];
        }
    }
	
	
	/**
     * Find a node in the given value.
     *
     * @param value The value to search for
     * @return A node with that value.
     */
    public Node search(int value) {
        return this.search(this.root, value);
    }

    /**
     * Helper function for search().
     *
     * @param node The current node.
     * @param value The value to search for
     * @return A node with that value.
     */
    private Node search(Node node, int value) {
        if (node != null) {
            if (value == node.value) {
                return node;
            } else if (value < node.value) {
                return this.search(node.left, value);
            } else {
                return this.search(node.right, value);
            }
        }
        return null;
    }
    
    /**
     * Print out the elements of the tree in order.
     */
    public void inOrderPrint() {
        inOrderPrint(this.root);
    }

    private void inOrderPrint(Node node) {
        if(node.left != null){
            inOrderPrint(node.left);
        }
        System.out.println(node.value);
        if(node.right != null){
            inOrderPrint(node.right);
        }
    }

    /**
     * Sum all elements in the tree.
     *
     * @return The sum.
     */
    public int sum() {
        return sum(this.root);
    }

    private int sum(Node node){
        if(node == null){
            return 0;
        }
        return node.value + sum(node.left) + sum(node.right);
    }


    /**
     * Check if a binary tree is a binary search tree.
     *
     * @return True if the tree is a binary search tree.
     */
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(this.root, 2147483647, -1);
    }

    private boolean isBinarySearchTree(Node node, int max, int min) {
        if(node == null){
            return true;
        }
        if(node.value <= min){
            return false;
        }
        if(node.value >= max){
            return false;
        }
        return isBinarySearchTree(node.left, node.value, min) && isBinarySearchTree(node.right, max, node.value);
    }



    /* Solution to Challenge 1d
    private void inOrderPrint(Node node) {
        if (node != null) {
            inOrderPrint(node.left);
            System.out.println(node.value);
            inOrderPrint(node.right);
        }
    }
    */
    
    /**
     * Print out the elements of the tree in order, prettily.
     * Uncomment to help with debugging
     */

    public void prettyPrint() {
        this.prettyPrint(this.root, 0);
    }
 
    private void prettyPrint(Node node, int depth) {
        if (node != null) {
            this.prettyPrint(node.right, depth + 1);
            System.out.println(this.repeatString("  ", depth) + node.value);
            this.prettyPrint(node.left, depth + 1);
        }
    }
    
    public static String repeatString(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }



	public static void main (String[] args){
		//int[] numbers = {2, 5, 1, 3, -1, 6, 0};
        //IntBinarySearchTree tree = new IntBinarySearchTree(4);
        //tree.addAll(numbers);
        //tree.inOrderPrint();
        // uncomment this and the associated method to help with debugging
        //tree.prettyPrint();
        
        // Add more tests here

        IntBinarySearchTree tr = new IntBinarySearchTree(5);
        tr.add(new Node(4));
        tr.add(new Node(6));
        tr.add(new Node(8));
        tr.add(new Node(7));
        tr.add(new Node(1));

        System.out.println("Print test tree");
        tr.prettyPrint();
        System.out.println("In Order tests");
        tr.inOrderPrint();
        System.out.println("Sum tests");
        System.out.println(tr.sum());

        IntBinarySearchTree badTree = new IntBinarySearchTree(5);
        Node left = new Node(1);
        Node right = new Node(10);
        Node leftright = new Node(7);
        badTree.root.left = left;
        badTree.root.right = right;
        badTree.root.left.right = leftright;

        System.out.println("IsBinaryTree tests");
        System.out.println(tr.isBinarySearchTree());
        System.out.println(badTree.isBinarySearchTree());



	}


}