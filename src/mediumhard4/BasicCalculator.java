// https://leetcode.com/problems/basic-calculator/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        int result = 0;        // Current evaluated result
        int sign = 1;          // Current sign (1 or -1)
        int number = 0;        // Current number being built
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the current result and sign to stack for later
                stack.push(result);
                stack.push(sign);

                // Reset for new expression inside parentheses
                result = 0;
                sign = 1;
                number = 0;
            } else if (c == ')') {
                // End of parentheses, add last number first
                result += sign * number;
                number = 0;

                // Pop the sign before parentheses and multiply
                result *= stack.pop();

                // Pop previous result and add
                result += stack.pop();
            }
        }
        // Add any leftover number
        result += sign * number;
        return result;
    }

    // Demo main method to run in Eclipse
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        String s1 = "1 + 1";
        System.out.println("Result: " + calculator.calculate(s1)); // 2

        String s2 = " 2-1 + 2 ";
        System.out.println("Result: " + calculator.calculate(s2)); // 3

        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Result: " + calculator.calculate(s3)); // 23
    }
}
