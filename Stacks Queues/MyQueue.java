
public class MyQueue<T> extends MyLinkedList<T> {

	/**
	 * Push an element onto the Queue
	 *
	 * @param element The element to push.
	 */
	@Override
	public void push(T element) {
		Node node = new Node(element);
		node.next = this.head;
		this.head = node;
		this.size++;
	}

	/**
	 * Pop an element off the Queue
	 *
	 * @return The popped element
	 */
	@Override
	public T pop() {
		if(this.size <= 0){
			return null;
		}else {
			T value = get(this.size - 1);
			remove(this.size - 1);
			return value;
		}
	}

	/**
	 * Peek at the next element in the Queue
	 *
	 * @return The peeked element
	 */
	@Override
	public T peek() {
		return this.head.value;
	}
	
	/**
	 * Put the MyQueue through some simple tests.
	 *
	 * @param args Ignored command line arguments.
	 */
	public static void main(String[] args) {

		MyQueue<Integer> list = new MyQueue();

		// check that an initial arraylist has nothing in it.
		int[] answer1 = new int[0];
		assertIsEqual(list, answer1);

		// push some elements onto the Stack
		for (int i = 0; i < 5; i++) {
			list.push(i * i);
		}
		int[] answer2 = {16, 9, 4, 1, 0};
		assertIsEqual(list, answer2);

		// delete some numbers in the middle
		list.remove(1);
		list.remove(2);
		int[] answer3 = {16, 4, 0};
		assertIsEqual(list, answer3);

		// pop some numbers from the stack
		list.pop();
		list.pop();
		int[] answer4 = {16};
		assertIsEqual(list, answer4);

		// delete the final remaining number
		list.remove(0);
		int[] answer5 = {};
		assertIsEqual(list, answer5);

		// if everything is good, we passed
		System.out.println("pass");
	
	}

}