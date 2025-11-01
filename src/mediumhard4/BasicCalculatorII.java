// https://leetcode.com/problems/basic-calculator-ii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.Stack;

public class BasicCalculatorII {
	//BasicCalculatorII
	public int calculate(String s) {
		int len = s.length();
		int cur = 0, prev = 0, res = 0;
		char curOperation = '+';

		for (int i = 0; i < len; i++) {
			char curChar = s.charAt(i);

			if (Character.isDigit(curChar)) {
				cur = cur * 10 + (curChar - '0');
			}

			if (!Character.isDigit(curChar) && curChar != ' ' || i == len - 1) {
				if (curOperation == '+') {
					res += cur;
					prev = cur;
				} else if (curOperation == '-') {
					res -= cur;
					prev = -cur;
				} else if (curOperation == '*') {
					res -= prev;
					prev *= cur;
					res += prev;
				} else if (curOperation == '/') {
					res -= prev;
					prev /= cur;
					res += prev;
				}

				curOperation = curChar;
				cur = 0;
			}
		}

		return res;
	}

	// Test code to run in Eclipse IDE
	public static void main(String[] args) {
		BasicCalculatorII calculator = new BasicCalculatorII();

		System.out.println(calculator.calculate("3+2*2"));  // Output: 7
		System.out.println(calculator.calculate(" 3/2 "));  // Output: 1
		System.out.println("from 2nd method: " + calculator.calculate1(" 3+5 / 2 ")); // Output: 5
	}

	/*
	 * 2nd way
	 */

	public int calculate1(String inputString) {
		Stack<Integer> numberStack = new Stack<>();
		int number = 0;
		char operator = '+';

		for (int index = 0; index < inputString.length(); index++) {
			char charValue = inputString.charAt(index);
			if (Character.isDigit(charValue)) {
				number = (number * 10) + (charValue - '0');
			}

			if ((!Character.isDigit(charValue) && charValue != ' ') ||
					(index == inputString.length() - 1)) {
				if (operator == '+') {
					numberStack.push(number);
				} else if (operator == '-') {
					numberStack.push(-1 * number);
				} else if (operator == '*') {
					numberStack.push(number * numberStack.pop());
				} else if (operator == '/') {
					numberStack.push(numberStack.pop() / number);
				}
				number = 0;
				operator = charValue;
			}
		}
		int sum = 0;
		while (!numberStack.isEmpty()) {
			sum = sum + numberStack.pop();
		}
		return sum;
	}
}
