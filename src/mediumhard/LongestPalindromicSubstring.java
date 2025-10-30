// https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=rabvlt31


// https://www.geeksforgeeks.org/dsa/longest-palindromic-substring/#using-manachers-algorithm

package mediumhard;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Even length palindrome
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // length of palindrome found
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Input: " + s);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s));
    }
}
