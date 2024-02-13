import java.util.Arrays;


public class MinHeap {

    /**
     * A min heap node that stores an element and its priority.
     */
    class Node {
        HeapElement value;
        int priority;

        public Node(HeapElement value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private Node[] array;
    private int size;

    /**
     * Initialize the min heap.
     */
    public MinHeap() {
        // start with space for ten strings
        this.array = new Node[10];
        this.size = 0;
    }

    // UTILITY METHODS

    /**
     * Double the size of the Node array.
     */
    private void resize() {
        Node[] newArray = new Node[2 * this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    /**
     * Calculate the index of the parent node.
     *
     * This method assumes the child index is valid,
     * and does not need to perform error checking.
     *
     * @param index The index of the child node.
     */
    private int parent(int index) {
        return (index-1) / 2;
    }

    /**
     * Calculate the index of the left child.
     *
     * This method assumes the parent index is valid,
     * and does not need to perform error checking.
     *
     * @param index The index of the parent node.
     * @return The index of the left child node.
     */
    private int leftChild(int index) {

        return (2 * index) + 1;
    }

    /**
     * Calculate the index of the right child.
     *
     * This method assumes the parent index is valid,
     * and does not need to perform error checking.
     *
     * @param index The index of the parent node.
     * @return The index of the right child node.
     */
    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    /**
     * Swap the array contents of the given indices.
     *
     * @param index1 The first index.
     * @param index2 The second index.
     */
    private void swap(int index1, int index2) {
       Node temp = this.array[index1];
       this.array[index1] = this.array[index2];
       this.array[index2] = temp;
    }

    // ADD

    /**
     * Add an element to the min heap.
     *
     * @param element The element to add.
     * @param priority The priority of the element.
     */
    public void add(HeapElement element, int priority) {

        Node node = new Node(element, priority);
        this.size++;

        if(this.size == this.array.length){
            resize();
        }

        this.array[this.size - 1] = node;
        int nodeIndex = this.size - 1;
        int parentIndex = parent(this.size - 1);

        while(node.priority < this.array[parentIndex].priority){
            swap(parentIndex, nodeIndex);
            nodeIndex = parentIndex;
            parentIndex = parent(parentIndex);
        }





    }

    // POLL

    /**
     * Remove and return the element with the lowest priority number.
     *
     * @return The HeapElement with the lowest priority number.
     */
    public HeapElement poll() {

        HeapElement rt = this.array[0].value;
        this.array[0] = this.array[this.size - 1];
        this.array[this.size - 1] = null;
        this.size--;
        Node node = this.array[0];
        int nodeIndex = 0;
        int lowestChild = lowest(nodeIndex);

        if(lowestChild != -1) {
            while (node.priority > this.array[lowestChild].priority) {
                swap(nodeIndex, lowestChild);
                nodeIndex = lowestChild;
                lowestChild = lowest(nodeIndex);
                if (lowestChild == -1) {
                    break;
                }
            }
        }

        return rt;
    }

    private int lowest(int index){
        if(leftChild(index) >= this.size && rightChild(index) >= this.size){
            return -1;
        }
        if(rightChild(index) >= this.size){
            return leftChild(index);
        }


        int L = this.array[leftChild(index)].priority;
        int R = this.array[rightChild(index)].priority;

        if(L<=R){
            return leftChild(index);
        }
        else{
            return rightChild(index);
        }


    }
    // OTHER HEAP METHODS

    /**
     * Get the size of the min heap.
     *
     * @return The size of the min heap.
     */
    public int size() {
        return this.size;
    }

    /**
     * Return (but not remove) the element with the lowest priority number.
     *
     * @return The HeapElement with the lowest priority number.
     */
    public HeapElement peek() {
        return this.array[0].value;
    }

    // DEBUG METHODS

    /**
     * Print the array of the min heap, as is.
     */
    public void printArray() {
        if (this.size == 0) {
            System.out.println("{}");
        }
        String result = "{" + this.array[0].value;
        for (int i = 1; i < this.size; i++) {
            result += ", " + this.array[i].value;
        }
        System.out.println(result + "}");

    }

    /**
     * Print the min heap as a binary tree.
     */
    public void printTree() {
        this.printTree(0, "");
    }

    private void printTree(int index, String indent) {
        if (index >= this.size) {
            return;
        }
        this.printTree(this.rightChild(index), indent + "    ");
        System.out.println(indent + this.array[index].value);
        this.printTree(this.leftChild(index), indent + "    ");
    }


}