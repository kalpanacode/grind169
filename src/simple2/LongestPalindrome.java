// https://leetcode.com/problems/longest-palindrome/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;

        // Count pairs and odd characters
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                length += 2; // pair found
            } else {
                set.add(c);
            }
        }

        // If there are remaining characters, one can be used as the center
        if (!set.isEmpty()) {
            length += 1;
        }
        return length;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();

        String s1 = "abccccdd";
        System.out.println("Longest palindrome length: " + solution.longestPalindrome(s1)); // Output: 7

        String s2 = "A";
        System.out.println("Longest palindrome length: " + solution.longestPalindrome(s2)); // Output: 1
    }
}

