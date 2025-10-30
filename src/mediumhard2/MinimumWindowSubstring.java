// https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int have = 0;
        int need = targetCount.size();

        Map<Character, Integer> windowCounts = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCounts.get(c).intValue() == targetCount.get(c).intValue()) {
                have++;
            }

            while (have == need) {
                // Update result if smaller window is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Try to reduce window size from the left
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < targetCount.get(leftChar).intValue()) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);
        System.out.println("Minimum window substring: " + result);  // Expected: "BANC"
    }
}
