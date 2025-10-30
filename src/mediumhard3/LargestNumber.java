// https://leetcode.com/problems/largest-number/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;
import java.util.*;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        // Convert integers to strings for comparison
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort strings using custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If largest number is "0", then all numbers are zero
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build largest number by concatenation
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        String result = largestNumber(nums);
        System.out.println("Largest number: " + result);  // Expected: "210"
    }
}

