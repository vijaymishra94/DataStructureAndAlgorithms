package datastructure.stack;

import java.util.Stack;

/**
 * @author vijay
 *
 */
public class InfixToPostfix {

	public int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public String convert(String expression) {
		StringBuffer buffer = new StringBuffer();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				buffer.append(c);
				continue;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					buffer.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
					buffer.append(stack.pop());
				}
				stack.push(c);
			}
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		String expression = "a+b*(c^d-e)^(f+g*h)-i";

		InfixToPostfix infixToPostfix = new InfixToPostfix();

		String postfix = infixToPostfix.convert(expression);
		System.out.println("Infix Expression :- " + expression);
		System.out.println("Postfix Expression :- " + postfix);
	}

}
