import java.lang.AssertionError;


public class MyLinkedList <T> {
	
	class Node {
		public T data = null;
		public Node next = null;

		
		Node(T data) { // Node inherits T from MyLinkedList
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	/**
	 * Construct an MyLinkedList.
	 */
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * Return the number of elements in the MyLinkedList.
	 *
	 * @return The number of elements in the MyLinkedList.
	 */
	public int size() {
		int size = 0;

		if (this.head == null){
			return size;
		} else {
			Node cur = new Node(null);
			cur = this.head;
			size = 1;

			while(cur.next != null){
				size++;
				cur = cur.next;
			}

			return size;
		}

	}

	/**
	 * Add an element to the end of the MyLinkedList.
	 *
	 * @param element The element to add.
	 */
	public void add(T element) {
		if (this.head == null){
			Node head = new Node(element);
			this.head = head;
		} else {
			Node cur = this.head;
			while(cur.next != null){
				cur = cur.next;
			}
			Node tail = new Node(element);
			cur.next = tail;
			this.tail = tail;
		}
	}

	/**
	 * Get the element at the specified index.
	 *
	 * This function assumes that the index argument is within range of the MyLinkedList.
	 *
	 * @param index The index to get.
	 * @return The element at the specified index.
	 */
	public T get(int index) {
		Node cur = new Node(null);
		cur = this.head;
		int counter = 0;
		while(index != counter){
			counter++;
			cur = cur.next;
		}

		return cur.data;

	}

	/**
	 * Remove the element at the specified index.
	 *
	 * This function assumes that the index argument is within range of the MyLinkedList.
	 *
	 * @param index The index to remove.
	 */
	public void remove(int index) {
		Node cur = this.head;

		if(index == 0 & this.size() == 1){
			this.head = null;
			this.tail = null;
		} else if (index == 0){
			this.head = cur.next;
			cur = null;
		} else if (index == this.size() - 1){
			for(int i = 0; i < index - 1; i++){
				cur = cur.next;
			}
			this.tail = cur;
			cur.next = null;
		} else {
			for(int i = 0; i < index - 1; i++){
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
	}

	/**
	 * Create a String representation of the MyLinkedList.
	 *
	 * @return A String representation of the MyLinkedList.
	 */
	public String toString() {
		String result = "{";
		if (this.size() > 0) {
			result += this.get(0);
		}
		for (int i = 1; i < this.size(); i++) {
			result += ", " + this.get(i);
		}
		result += "}";
		return result;
	}

	/**
	 * Check that an MyLinkedList contains the same elements as an int array.
	 *
	 * If the list and the array are not the same, throw an AssertionError.
	 *
	 * @param list The MyLinkedList to check.
	 * @param answer The expected answer, in the form of an int array.
	 */
	public static void assertArraysEqual(MyLinkedList list, int[] answer) {
		if (list.size() != answer.length) {
			throw new AssertionError("Expected list of length " + answer.length + " but got " + list.size());
		}
		for (int i = 0; i < answer.length; i++) {
			if ((Integer)list.get(i) != answer[i]) {
				throw new AssertionError("Expected " + answer[i] + " but got " + list.get(i) + " at index " + i);
			}
		}
	}

	/*
	 * Test that the empty arraylist has size 0.
	 */
	public static void test1() {
		MyLinkedList<Integer> list = new MyLinkedList();
		int[] answer = new int[0];
		assertArraysEqual(list, answer);
	}

	/*
	 * Test insertion into an arraylist (without resizing).
	 */
	public static void test2() {
		MyLinkedList list = new MyLinkedList();
		for (int i = 0; i < 3; i++) {
			list.add(i * i);
		}
		int[] answer = {0, 1, 4};
		assertArraysEqual(list, answer);
	}

	/*
	 * Test deletion from an arraylist without emptying it.
	 */
	public static void test3() {
		MyLinkedList <Integer> list = new MyLinkedList();
		for (int i = 0; i < 5; i++) {
			list.add(i * i);
		}
		list.remove(1);
		list.remove(2);
		int[] answer = {0, 4, 16};
		MyLinkedList.assertArraysEqual(list, answer);
	}

	/*
	 * Test deletion from an arraylist and emptying it.
	 */
	public static void test4() {
		MyLinkedList <Integer> list = new MyLinkedList();
		for (int i = 0; i < 5; i++) {
			list.add(i * i);
		}

		list.remove(1);
		list.remove(2);

		// delete the final remaining numbers
		list.remove(0);
		list.remove(0);
		list.remove(0);
		int[] answer1 = {};
		MyLinkedList.assertArraysEqual(list, answer1);

		// check that there are no last-element issues
		for (int i = 0; i < 5; i++) {
			list.add(i * i);
		}
		list.remove(4);
		list.add(-1);
		int[] answer2 = {0, 1, 4, 9, -1};
		MyLinkedList.assertArraysEqual(list, answer2);
	}

	/*
	 * Test insertion into an arraylist (with resizing).
	 */
	public static void test5() {
		MyLinkedList <Integer> list = new MyLinkedList();
		for (int i = 0; i < 12; i++) {
			list.add(i * i);
		}
		int[] answer = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121};
		MyLinkedList.assertArraysEqual(list, answer);
	}

	/**
	 * Put the MyLinkedList through some simple tests.
	 *
	 * @param args Ignored command line arguments.
	 */
	public static void main(String[] args) {


		MyLinkedList linker = new MyLinkedList();
		linker.add(3); linker.add("hi"); linker.add(3.3); linker.add("bye");
		System.out.print("Initial List: "); System.out.println(linker);
		System.out.print("Initial Size: "); System.out.println(linker.size());
		System.out.print("Get Index 2: "); System.out.println(linker.get(2));
		System.out.print("Remove head: "); linker.remove(0);
		System.out.println(linker);
		System.out.print("Remove middle: "); linker.remove(1);
		System.out.println(linker);
		System.out.print("Remove tail: "); linker.remove(1);
		System.out.println(linker);
		System.out.print("Remove last node: "); linker.remove(0);
		System.out.println(linker);




		test1();
		test2();
		test3();
		test4();
		test5();

		System.out.println("pass");
	}

}
