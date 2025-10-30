// https://leetcode.com/problems/basic-calculator-ii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // If c is an operator or last character, compute previous operation
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack) {
            result += val;
        }

        return result;
    }

    // Test code to run in Eclipse IDE
    public static void main(String[] args) {
        BasicCalculatorII calculator = new BasicCalculatorII();

        System.out.println(calculator.calculate("3+2*2"));  // Output: 7
        System.out.println(calculator.calculate(" 3/2 "));  // Output: 1
        System.out.println(calculator.calculate(" 3+5 / 2 ")); // Output: 5
    }
}
