import java.lang.AssertionError;

public abstract class MyLinkedList<T> {
	
	class Node {
		T value = null;
		Node next = null;
		
		Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	int size = 0;
	protected Node head = null;
	protected Node tail = null;

	/**
	 * Construct an IntLinkedList.
	 */
	public MyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * Return the number of elements in the IntLinkedList.
	 *
	 * @return The number of elements in the IntLinkedList.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Add an element to the end of the IntLinkedList.
	 *
	 * @param element The element to add.
	 */
	public void add(T element) {
		Node newNode = new Node(element);
		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size++;
	}

	/**
	 * Get the element at the specified index.
	 *
	 * This function assumes that the index argument is within range of the IntLinkedList.
	 *
	 * @param index The index to get.
	 * @return The element at the specified index.
	 */
	public T get(int index) {
		Node curr = this.head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return curr.value;
	}

	/**
	 * Remove the element at the specified index.
	 *
	 * This function assumes that the index argument is within range of the IntLinkedList.
	 *
	 * @param index The index to remove.
	 */
	public void remove(int index) {
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else if (index == 0) {
			this.head = this.head.next;
		} else {
			Node curr = this.head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
			if (curr.next == null) {
				this.tail = curr;
			}
		}
		this.size--;
	}
	
	
	public abstract void push(T element);
	public abstract T pop();
	public abstract T peek();

	/**
	 * Create a String representation of the IntLinkedList.
	 *
	 * @return A String representation of the IntLinkedList.
	 */
	public String toString() {
		Node curr = this.head;
		if (curr == null) {
			return "{}";
		}
		String result = "{";
		result += curr.value;
		curr = curr.next;
		while (curr != null) {
			result += ", " + curr.value;
			curr = curr.next;
		}
		result += "}";
		return result;
	}

	/**
	 * Check that an MyLinkedList<Integer> contains the same elements as an int array.
	 *
	 * If the list and the array are not the same, throw an AssertionError.
	 *
	 * @param list The MyLinkedList to check.
	 * @param answer The expected answer, in the form of an int array.
	 */
	public static void assertIsEqual(MyLinkedList<Integer> list, int[] answer) {
		if (list.size() != answer.length) {
			throw new AssertionError("Expected list of length " + answer.length + " but got " + list.size());
		}
		for (int i = 0; i < answer.length; i++) {
			if (!list.get(i).equals((int)answer[i])) {
				throw new AssertionError("Expected " + answer[i] + " but got " + list.get(i));
			}
		}
	}


	public static void main(String[] args) {

		
		System.out.println("pass");
	}

}
