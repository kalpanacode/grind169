// https://leetcode.com/problems/backspace-string-compare/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
    	
        String s1 = buildString(s);
        String t1 = (buildString(t));
        System.out.println("s is.." + s1);
        
        return s1.equals(t1);
    }

    private String buildString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        //System.out.println("val of string.valueof(stack)..."+ String.valueOf(stack) );
        //return String.valueOf(stack);  // [a, e, f, g, c]
        return stack.toString();  // [a, e, f, g, c] if you want "aefgc" using StringBuild and keep appending 
        // StringBuilder sb = new StringBuilder();
        //for (Character ch : stack) {
        //    sb.append(ch);
        //}
    }

    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();

        String s1 = "aefgb#c";
        String t1 = "aefgd#c";
        System.out.println("Are the strings equal after backspaces? " + solution.backspaceCompare(s1, t1));  // Output: true

        String s2 = "a#c";
        String t2 = "b";
        System.out.println("Are the strings equal after backspaces? " + solution.backspaceCompare(s2, t2));  // Output: false
    }
}

