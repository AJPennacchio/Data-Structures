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
        // resize if needed
        // put the new node in the array
        // percolate up (Challenge Q3)
        // increment size

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

        /*
        // save the return value to a temporary variable
        // replace the root with the last element
        // decrement the size
        // percolate down
        //int currNodeIndex = 0;
        //return null;

        while (true) {
            // break if there is no children (Challenge Q4a)
            // find the appropriate child to compare with (Challenge Q4b)
            int childNodeIndex = -1; // initialize with dummy value
            // break if the child is lower priority (Challenge Q4c)
            // swap (Challenge Q4d)
        }


        // return the stored value
        return null;

         */
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

        /*
        while((node.priority > this.array[leftChild(nodeIndex)].priority || node.priority > this.array[rightChild(nodeIndex)].priority)){
            if(this.array[leftChild(nodeIndex)].priority >= this.array[rightChild(nodeIndex)].priority){
                swap(rightChild(nodeIndex), nodeIndex);
                nodeIndex = rightChild(nodeIndex);
            } else{
                swap(leftChild(nodeIndex), nodeIndex);
                nodeIndex = leftChild(nodeIndex);
            }
            if(leftChild(nodeIndex) >= this.size){
                break;
            }
        }

         */

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

    // MAIN

    public static void main(String[] args) {
        // create the heap
        System.out.println("Initial heap");
        MinHeap heap = new MinHeap();
        heap.add(new HeapElement("0"), 0);
        heap.add(new HeapElement("1"), 1);
        heap.add(new HeapElement("2"), 2);
        heap.printTree();


        System.out.println("Percolate Up");
        heap.add(new HeapElement("-1"), -1);
        heap.printTree();

        System.out.println("Percolate Up");
        heap.add(new HeapElement("-5"), -5);
        heap.printTree();

        System.out.println("Poll and Percolate down");
        heap.poll();
        heap.printTree();

        System.out.println("Poll and Percolate down");
        heap.poll();
        heap.printTree();

        /*
        // add some numbers
        int[] numbers = {56, 28, 7, 5, 51, 16, 79, 83, 97, 37, 75, 69, 24, 90};
        for (int i = 0; i < numbers.length; i++) {
            String numberString = new Integer(numbers[i]).toString();
            heap.add(new HeapElement(numberString), numbers[i]);
        }
        // print the heap as an array
        heap.printArray();
        // print the heap as a binary tree
        heap.printTree();
        // poll everything out

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(heap.poll());
        }



         */
    }

}