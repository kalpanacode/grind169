package simple1;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If opening bracket, push corresponding closing bracket to stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If stack is empty or top is not matching closing bracket, return false
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // Valid if stack is empty after processing all characters
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String s1 = "()";
        System.out.println("Input: " + s1 + " -> Output: " + solution.isValid(s1)); // true
        String s4 = "([)]";
        System.out.println("Input: " + s4 + " -> Output: " + solution.isValid(s4)); // false
    }
}
