// https://leetcode.com/problems/string-to-integer-atoi/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

public class StringToIntegerAtoi {

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1;
        int start = 0;
        long result = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (s.charAt(0) == '+') {
            start++;
        }

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;

            result = result * 10 + (c - '0');
            long signedResult = sign * result;

            if (signedResult > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (signedResult < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        String input = "42";
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output: " + myAtoi(input));
    }
}
