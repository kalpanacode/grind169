// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
package servicenow;

public class MinNoSwapsToStrBalance {
	public int minSwaps(String s) {
        int balance = 0, maxImbalance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                balance++;
            } else {
                balance--;
            }
            maxImbalance = Math.min(maxImbalance, balance);
        }
        return (Math.abs(maxImbalance) + 1) / 2;
    }
}
