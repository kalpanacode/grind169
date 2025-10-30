// https://leetcode.com/problems/longest-repeating-character-replacement/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;
public class LongRepeatCharReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0; // max frequency of a single char in the current window
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // Current window size is right - left + 1
            // If more than k chars need replacing (window size - maxCount > k), shrink window
            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        LongRepeatCharReplacement solution = new LongRepeatCharReplacement();

        String s = "ABAB";
        int k = 2;
        int longestLength = solution.characterReplacement(s, k);
        System.out.println("Longest repeating character replacement length: " + longestLength); // Expected: 4
    }
}
