// https://leetcode.com/problems/reverse-integer/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

public class ReverseInteger {

    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before multiplying by 10
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int input = 123;
        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reverse(input));
    }
}
