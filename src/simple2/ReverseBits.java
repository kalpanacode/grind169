
// https://leetcode.com/problems/reverse-bits/description/?envType=problem-list-v2&envId=rabvlt31
package simple2;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;              // Shift result left by 1
            result |= (n & 1);         // Add the least significant bit of n to result
            n >>>= 1;                  // Unsigned right shift n by 1
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        int n = 43261596;
        int reversed = solution.reverseBits(n);
        System.out.println("Reversed bits: " + reversed);  // Output: 964176192
    }
}
