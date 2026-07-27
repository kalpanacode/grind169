// https://leetcode.com/problems/decode-string/description/?envType=problem-list-v2&envId=rabvlt31

//DecodeString.java
//https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/DecodeString.java
//https://www.youtube.com/watch?v=E9qHRcQXmDk
//eg:2[a3[c2[x]]y] 

//1st approach is solving inner most, then traversing back and solving next inner etc....it will take long time.
//So we use stack to solve it in linear time



package leetcode.medium;

import java.util.Stack;

public class DecodeString {

  public String decodeString(String s) {

    Stack<Integer> numStack = new Stack<>();
    Stack<String> stringStack = new Stack<>();
    int k = 0;

    for (char c : s.toCharArray()) {

      if (Character.isDigit(c)) {
        k = (k * 10) + (c - '0');
        continue;
      }

      if (c == '[') {
        numStack.push(k);
        k = 0;
        stringStack.push(String.valueOf(c));
        continue;
      }

      if (c != ']') {
        stringStack.push(String.valueOf(c));
        continue;
      }

      StringBuilder temp = new StringBuilder();
      while (!stringStack.peek().equals("["))
        temp.insert(0, stringStack.pop());

      // remove the "["
      stringStack.pop();

      // Get the new string
      StringBuilder replacement = new StringBuilder();
      int count = numStack.pop();
      for (int i = 0; i < count; i++)
        replacement.append(temp);

      // Add it to the stack
      stringStack.push(replacement.toString());
    }

    StringBuilder result = new StringBuilder();
    while (!stringStack.empty()) {
      result.insert(0, stringStack.pop());
    }
    return result.toString();
  }

}







//*********************************************
package mediumhard5;

import java.util.*;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);

            if (Character.isDigit(c)) {
                // Parse the full number
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (c == '[') {
                // Push current accumulated string on stack
                resultStack.push(currentString);
                currentString = new StringBuilder();
                index++;
            } else if (c == ']') {
                // Pop the last string and the repeat count
                StringBuilder decodedString = resultStack.pop();
                int repeatTimes = counts.pop();

                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
                index++;
            } else {
                // Normal character
                currentString.append(c);
                index++;
            }
        }
        return currentString.toString();
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        String s = "3[a]2[bc]";
        String decoded = solution.decodeString(s);
        System.out.println("Decoded string: " + decoded);  // Expected: "aaabcbc"
    }
}
