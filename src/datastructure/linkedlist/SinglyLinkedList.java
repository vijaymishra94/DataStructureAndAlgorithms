package datastructure.linkedlist;

/**
 * @author vijay
 *
 */
public class SinglyLinkedList {

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

	/**
	 * @author vijay
	 *
	 * @param <T>
	 */
	public static class LinkedList<T> {

		private Node<T> head;

		public void insert(T element) {
			Node<T> node = new Node<>(element);
			node.next = this.head;
			this.head = node;
		}

		public void insertAfter(T prevElement, T element) {
			Node<T> prevNode = findNodeByElement(prevElement);
			if (prevElement == null) {
				throw new RuntimeException("Element doesn't exist.");
			}

			Node<T> newNode = new Node<>(element);
			newNode.next = prevNode.next;
			prevNode.next = newNode;
		}

		public void insertAfterPosition(int index, T element) {
			if (index < 0 || index > (size() - 1)) {
				throw new RuntimeException("Invalid index " + index);
			}

			Node<T> prevNode = findNodeByIndex(index);
			Node<T> newNode = new Node<>(element);
			newNode.next = prevNode.next;
			prevNode.next = newNode;
		}

		public void deleteByElement(T element) {
			Node<T> node = this.head;
			Node<T> previous = null;

			while (node != null) {
				if (node.data == element) {
					break;
				}
				previous = node;
				node = node.next;
			}

			if (node == null) {
				throw new RuntimeException("Element doesn't exist.");
			}

			if (previous == null) {
				this.head = node.next;
				return;
			}

			previous.next = node.next;
			node = null;

		}

		public void deleteByPosition(int index) {
			if (index < 0 || index > (size() - 1)) {
				throw new RuntimeException("Invalid index " + index);
			}

			Node<T> node = this.head;
			Node<T> previous = null;
			int currentPosition = 0;
			while (currentPosition < index && node != null) {
				previous = node;
				node = node.next;
				currentPosition++;
			}

			if (previous == null) {
				this.head = node.next;
				return;
			}

			previous.next = node.next;
			node = null;
		}

		public int size() {
			int count = 0;
			Node<T> node = this.head;
			while (node != null) {
				node = node.next;
				count++;
			}
			return count;
		}

		private Node<T> findNodeByElement(T element) {
			Node<T> node = this.head;
			while (node != null) {
				if (element == node.data) {
					break;
				}
				node = node.next;
			}
			return node;
		}

		private Node<T> findNodeByIndex(int index) {
			Node<T> node = this.head;
			int currentPosition = 0;
			while (currentPosition < index && node != null) {
				currentPosition++;
				node = node.next;
			}
			return node;
		}

		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			Node<T> node = this.head;
			while (node != null) {
				buffer.append(node.data).append(" ");
				node = node.next;
			}
			return buffer.toString();
		}
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.insert("10");
		list.insert("20");
		list.insert("30");
		list.insert("40");
		list.insert("10");
		System.out.println(list);
		System.out.println("Insert 50 after 10.");
		list.insertAfter("10", "50");
		list.insert("60");
		System.out.println(list);
		System.out.println("Size is " + list.size());
		System.out.println("Insert 70 after 6th index.");
		list.insertAfterPosition(6, "70");
		System.out.println(list);
		System.out.println("Delete 30");
		list.deleteByElement("30");
		System.out.println(list);
		System.out.println("Delete 2nd element");
		list.deleteByPosition(2);
		System.out.println(list);
	}
}
