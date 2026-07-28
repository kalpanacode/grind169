// https://leetcode.com/problems/basic-calculator-ii/description/?envType=problem-list-v2&envId=rabvlt31


// eg: 3+2*5-4  //o/p: 9
//save the previous operator in sign variable

// Evaluate simple expression containing non-negative integers and + - * /
// No parentheses. Spaces allowed.
    public static int evaluate(String s) {
        if (s == null || s.isEmpty()) return 0;

        Stack<Integer> st = new Stack<>();
        int n = s.length();
        char sign = '+';             // last seen operator (treat start as '+')
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // build the full integer value
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // now 'val' holds the parsed integer, i points to first non-digit or n
                // apply based on previous sign
                if (sign == '+') {
                    st.push(val);
                } else if (sign == '-') {
                    st.push(-val);
                } else if (sign == '*') {
                    int a = st.pop();
                    st.push(a * val);
                } else if (sign == '/') {
                    int a = st.pop();
                    st.push(a / val); // integer division truncates toward zero
                }
                continue; // continue outer while (i already points at next char)
            }

            // ignore spaces
            if (ch == ' ') {
                i++;
                continue;
            }

            // if not digit and not space, it's an operator: update sign and move on
            sign = ch;
            i++;
        }

        // sum all values in stack
        int result = 0;
        while (!st.isEmpty()) result += st.pop();
        return result;
    }






//****************************************
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
