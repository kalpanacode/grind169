// https://leetcode.com/problems/powx-n/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

public class PowXN {

    // Function to calculate x raised to the power n
    public static double myPow(double x, int n) {
        long nn = n; // use long to handle edge cases like Integer.MIN_VALUE
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }
        double result = 1;
        double current_product = x;

        while (nn > 0) {
            if (nn % 2 == 1) {
                result *= current_product;
            }
            current_product *= current_product;
            nn /= 2;
        }

        return result;
    }

    // Main method with test cases
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;

        double output = myPow(x, n);
        System.out.println("myPow(" + x + ", " + n + ") = " + output);  // Expected: 1024.0

        // Additional test cases
        System.out.println("myPow(2.1, 3) = " + myPow(2.1, 3));        // Expected: 9.261
        System.out.println("myPow(2.0, -2) = " + myPow(2.0, -2));      // Expected: 0.25
    }
}

