// https://leetcode.com/problems/generate-parentheses/description/
package servicenow;
import java.util.*;

// open and close values are apt in that particular call stack. 

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backtrack(result, new StringBuilder(), 0, 0, n);
		return result;
	}

	private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
		// Base case: when current string has reached maximum possible length
		if (current.length() == max * 2) {
			result.add(current.toString());
			return;
		}

		// Add '(' if still allowed
		if (open < max) {
			current.append('(');
			backtrack(result, current, open + 1, close, max);
			current.deleteCharAt(current.length() - 1); // backtrack
		}

		// Add ')' only if there's a matching open parenthesis available
		if (close < open) {
			current.append(')');
			backtrack(result, current, open, close + 1, max);
			current.deleteCharAt(current.length() - 1); // backtrack
		}
	}
}

