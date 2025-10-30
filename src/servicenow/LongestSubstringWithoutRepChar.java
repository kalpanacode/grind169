// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
package servicenow;
import java.util.*;

public class LongestSubstringWithoutRepChar {
	  public int lengthOfLongestSubstring(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        int maxLen = 0;
	        int left = 0;

	        for (int right = 0; right < s.length(); right++) {
	            char c = s.charAt(right);
	            if (map.containsKey(c)) {
	                // move left pointer to one past previous occurrence (max because left may already be ahead)
	                left = Math.max(left, map.get(c) + 1);
	            }
	            map.put(c, right);
	            maxLen = Math.max(maxLen, right - left + 1);
	        }

	        return maxLen;
	    }
}
