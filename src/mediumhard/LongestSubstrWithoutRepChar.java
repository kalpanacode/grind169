// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;
import java.util.HashMap;

public class LongestSubstrWithoutRepChar {
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		for (int end = 0, start = 0; end < n; end++) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				start = Math.max(map.get(c) + 1, start);
			}
			map.put(c, end);
			maxLen = Math.max(maxLen, end - start + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Input: " + s);
		System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s));
	}
}
