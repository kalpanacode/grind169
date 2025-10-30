// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/

package servicenow;
import java.util.*;

public class ParenthesesStringValid {
	/* approach -1 */
	
	public boolean canBeValid(String s, String locked) {
		int n = s.length();
		if (n % 2 != 0) return false;

		Stack<Integer> open = new Stack<>();
		Stack<Integer> openClose = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (locked.charAt(i) == '0') {
				openClose.push(i);
			} else if (s.charAt(i) == '(') {
				open.push(i);
			} else if (s.charAt(i) == ')') {
				if (!open.isEmpty()) {
					open.pop();
				} else if (!openClose.isEmpty()) {
					openClose.pop();
				} else {
					return false;
				}
			}
		}

		// Match remaining open parentheses with available unlocked positions
		while (!open.isEmpty() && !openClose.isEmpty() && open.peek() < openClose.peek()) {
			open.pop();
			openClose.pop();
		}

		return open.isEmpty();
	}
	
	/* approach -2 */
	public boolean canBeValid2(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // odd length can't be valid

        // Left to right check
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                open--;
            }
            if (open < 0) return false;
        }

        // Right to left check
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                close++;
            } else {
                close--;
            }
            if (close < 0) return false;
        }

        return true;
    }
}

