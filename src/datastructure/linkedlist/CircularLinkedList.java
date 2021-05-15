package datastructure.linkedlist;

/**
 * @author vijay
 *
 */
public class CircularLinkedList<T> {

	/**
	 * @author vijay
	 *
	 * @param <T>
	 */
	public static class Node<T> {

		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> head = null;
	private Node<T> tail = null;

	public void insert(T element) {
		Node<T> node = new Node<>(element);

		if (this.head == null) { // First Node
			this.head = node;
			this.tail = node;
			node.next = node;
			return;
		}

		this.tail.next = node;
		this.tail = node;
		node.next = this.head;

	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		if (this.head != null) {
			Node<T> node = this.head;
			do {
				buffer.append(node.data);
				node = node.next;
				buffer.append((node == this.head) ? "" : ",");
			} while (node != this.head);
		}
		return buffer.append("]").toString();
	}

	public static void main(String[] args) {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();

		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		System.out.println(list);

	}

}
