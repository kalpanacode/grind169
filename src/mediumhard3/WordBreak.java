// https://leetcode.com/problems/word-break/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1]; // +1 because empty string is True
        dp[0] = true; // empty string can be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further splits for position i
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        boolean canSegment = wordBreak(s, wordDict);
        System.out.println("Can \"" + s + "\" be segmented?: " + canSegment);
        // Expected output: true
    }
}
