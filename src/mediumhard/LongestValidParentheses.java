// https://leetcode.com/problems/longest-valid-parentheses/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

import java.util.Stack;

public class LongestValidParentheses {
    
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base for valid substring calculation
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);  // Reset the base index for next valid substring
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "(()";
        int result = longestValidParentheses(s);
        System.out.println("Longest valid parentheses length for \"" + s + "\": " + result);
    }
}

