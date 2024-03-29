public class StringLinkedList {

    /**
     * A private Linked List Node class.
     */
    private class Node {
        String value = null;
        Node prev = null;
        Node next = null;

        /**
         * Constructor with a single value.
         *
         * @param value The String this node contains.
         */
        public Node(String value) {
            this.value = value;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     * Add a string to the list.
     *
     * @param string The string to add.
     */
    public void add(String string) {
        Node newNode = new Node(string);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Get an element of the list.
     * <p>
     * This function assumes that the index is within range.
     *
     * @param index The index to get.
     * @return The string at that index.
     */
    public String get(int index) {
        Node curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    /**
     * Print the list, one element per line.
     */
    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * Sort the list with merge sort.
     */
    public void mergesort() {
        this.head = splitList(this.head);
    }

    private Node splitList(Node node) {

        if (node.next == null) {
            return node;
        }

        Node middle = findMiddle(node);
        Node rightHead = middle.next;
        middle.next = null;
        rightHead.prev = null;

        Node h1 = splitList(node);
        Node h2 = splitList(rightHead);


        return merge(h1, h2);

    }

    public Node merge(Node h1, Node h2) {

        Node smallest = new Node("head");
        Node ans = smallest;

        while (h1 != null && h2 != null) {

            if (h1.value.compareTo(h2.value) <= 0) {
                ans.next = h1;
                h1.prev = ans;
                h1 = h1.next;
            } else {
                ans.next = h2;
                h2.prev = ans;
                h2 = h2.next;
            }

            ans = ans.next;

        }

        while(h1 != null){
            ans.next = h1;
            h1.prev = ans;
            h1 = h1.next;
            ans = ans.next;
        }

        while(h2 != null){
            ans.next = h2;
            h2.prev = ans;
            h2 = h2.next;
            ans = ans.next;
        }

        return smallest.next;
    }

    private Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        String[] alphabet = {
                "uniform", "tango", "sierra", "papa", "november",
                "alfa", "whiskey", "quebec", "hotel", "bravo",
                "india", "oscar", "romeo", "x-ray", "delta",
                "echo", "golf", "charlie", "zulu", "yankee",
                "juliett", "foxtrot", "mike", "lima", "victor",
                "kilo"
        };

        StringLinkedList list = new StringLinkedList();

        for (int i = 0; i < alphabet.length; i++) {
            list.add(alphabet[i]);
        }

        list.mergesort();
        list.print();


    }

}
