package datastructure.linkedlist;

/**
 * @author vijay
 *
 */
public class DoublyLinkedList<T> {

	/**
	 * @author vijay
	 *
	 * @param <T>
	 */
	public static class Node<T> {

		public T data;
		public Node<T> next;
		public Node<T> previous;

		public Node(T data) {
			this.data = data;
		}
	}

	public Node<T> head = null; // Head of linked List
	public Node<T> tail = null; // Tail of Linked List

	public void insert(T element) {
		Node<T> node = new Node<>(element);

		if (this.head == null) { // First node
			this.head = node;
			this.tail = node;
			return;
		}

		this.tail.next = node;
		node.previous = this.tail;
		this.tail = node;

	}

	public void reverse() {
		Node<T> node = this.tail;
		while (node != null) {
			Node<T> temp = node.previous;
			node.previous = node.next;
			node.next = temp;
			node = temp;
		}

		Node<T> temp = this.tail;
		this.tail = this.head;
		this.head = temp;

	}

	public void delete(T element) {
		Node<T> node = findNodeByElement(element);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		node = null;
	}

	public Node<T> findNodeByElement(T element) {
		Node<T> node = this.head;
		while (node != null) {
			if (node.data == element) {
				break;
			}
			node = node.next;
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		Node<T> node = this.head;
		while (node != null) {
			buffer.append(node.data);
			node = node.next;
			buffer.append(node == null ? "" : ",");
		}
		return buffer.append("]").toString();
	}

	public static void main(String[] args) {

		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		System.out.println(list);
		list.reverse();
		System.out.println(list);
		list.insert(50);
		System.out.println(list);
		list.reverse();
		System.out.println(list);
		list.delete(20);
		System.out.println(list);
	}

}
