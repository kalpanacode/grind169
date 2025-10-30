// https://leetcode.com/problems/palindrome-number/description/?envType=problem-list-v2&envId=rabvlt31
package simple1;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome by definition
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        // Reverse the integer
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // Compare the reversed number with the original
        return reversed == original;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();

        int x1 = 121;
        System.out.println("Input: " + x1 + " -> Output: " + solution.isPalindrome(x1)); // true

        int x2 = -121;
        System.out.println("Input: " + x2 + " -> Output: " + solution.isPalindrome(x2)); // false

        int x3 = 10;
        System.out.println("Input: " + x3 + " -> Output: " + solution.isPalindrome(x3)); // false
    }
}

