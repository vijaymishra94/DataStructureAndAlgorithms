package datastructure.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vijay
 *
 */
public class InfixToPrefix {

	public String reverse(String expression) {
		char[] chars = expression.toCharArray();
		List<String> characters = new ArrayList<>();
		for (char c : chars) {
			characters.add(String.valueOf(c));
		}
		Collections.reverse(characters);
		return characters.stream().collect(Collectors.joining(""));
	}

	public String convert(String expression) {
		char[] chars = reverse(expression).toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				chars[i] = ')';
			} else if (chars[i] == ')') {
				chars[i] = '(';
			}
		}

		expression = String.valueOf(chars);
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		String postfix = infixToPostfix.convert(expression);
		return reverse(postfix);
	}

	public static void main(String[] args) {
		String infix = "((A-(B/C))*((A/K)-L))";

		InfixToPrefix infixToPrefix = new InfixToPrefix();
		String postfix = infixToPrefix.convert(infix);

		System.out.println("Infix Expression :- " + infix);
		System.out.println("Postfix Expression :- " + postfix);
	}

}
