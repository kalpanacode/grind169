// https://leetcode.com/problems/counting-bits/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();

        int n = 2;
        int[] result = solution.countBits(n);

        System.out.println("Counting bits: " + Arrays.toString(result));  // Output: [0, 1, 1]
    }
}
