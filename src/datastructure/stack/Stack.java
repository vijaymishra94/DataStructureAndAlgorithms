package datastructure.stack;

/**
 * @author vijay
 *
 */
public class Stack<T> {

	int top = -1;

	T[] elements = null;

	public Stack() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	public void push(T element) {
		if (top == elements.length - 1) {
			throw new RuntimeException("Stact overflow!!!");
		}
		elements[++top] = element;
	}

	public T pop() {
		if (top == -1) {
			throw new RuntimeException("Stack underflow!!!");
		}
		return elements[top--];
	}

	public T peek() {
		if (top == -1) {
			throw new RuntimeException("Stack underflow!!!");
		}
		return elements[top];
	}

	public void clear() {
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		if (top > -1) {
			for (int i = 0; i <= top; i++) {
				buffer.append(elements[i]);
				buffer.append(i == top ? "" : ",");
			}
		}
		return buffer.append("]").toString();
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("10");
		stack.push("20");
		stack.push("30");
		stack.push("40");
		System.out.println("Statck : " + stack);
		System.out.println("Peek : " + stack.peek());
		System.out.println("Pop : " + stack.pop());
		System.out.println("Statck : " + stack);
		stack.push("50");
		stack.push("60");
		stack.push("70");
		stack.push("90");
		stack.push("100");
		stack.push("110");
		stack.push("120");
		System.out.println("Statck : " + stack);
		stack.clear();
		System.out.println("Statck : " + stack);
		System.out.println("Statck is " + (stack.isEmpty() ? "empty." : "not empty."));
	}

}
