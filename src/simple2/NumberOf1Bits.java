// https://leetcode.com/problems/number-of-1-bits/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;        // Add the least significant bit
            n >>>= 1;              // Unsigned right shift by 1
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();

        int n = 11; // binary 1011
        System.out.println("Number of 1 bits: " + solution.hammingWeight(n));  // Output: 3
    }
}

