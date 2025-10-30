// https://leetcode.com/problems/decode-string/description/?envType=problem-list-v2&envId=rabvlt31

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
