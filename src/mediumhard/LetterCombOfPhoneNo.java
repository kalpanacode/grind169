// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

import java.util.ArrayList;
import java.util.List;

public class LetterCombOfPhoneNo {
	    private static final String[] KEYPAD = {
	        "",     // 0
	        "",     // 1
	        "abc",  // 2
	        "def",  // 3
	        "ghi",  // 4
	        "jkl",  // 5
	        "mno",  // 6
	        "pqrs", // 7
	        "tuv",  // 8
	        "wxyz"  // 9
	    };

	    public static List<String> letterCombinations(String digits) {
	        List<String> result = new ArrayList<>();
	        if (digits == null || digits.isEmpty()) return result;

	        backtrack(result, new StringBuilder(), digits, 0);
	        return result;
	    }

	    private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
	        if (index == digits.length()) {
	            result.add(current.toString());
	            return;
	        }

	        String letters = KEYPAD[digits.charAt(index) - '0'];
	        for (char c : letters.toCharArray()) {
	            current.append(c);
	            backtrack(result, current, digits, index + 1);
	            current.deleteCharAt(current.length() - 1);
	        }
	    }

	    public static void main(String[] args) {
	        String digits = "23";
	        List<String> combinations = letterCombinations(digits);
	        System.out.println("Letter combinations for \"" + digits + "\": " + combinations);
	    }
	}
