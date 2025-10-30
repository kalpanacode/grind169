// https://leetcode.com/problems/decode-ways/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string
        dp[1] = 1; // first char is valid (not zero)

        for (int i = 2; i <= n; i++) {
            // Check single-digit decode possibility
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check two-digit decode possibility
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println("Number of ways to decode \"" + s + "\": " + numDecodings(s)); // Expected: 2

        s = "11106";
        System.out.println("Number of ways to decode \"" + s + "\": " + numDecodings(s)); // Expected: 2
        
        s = "06";
        System.out.println("Number of ways to decode \"" + s + "\": " + numDecodings(s)); // Expected: 0
    }
}
