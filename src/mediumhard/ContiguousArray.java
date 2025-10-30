// https://leetcode.com/problems/contiguous-array/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard;

import java.util.HashMap;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // sum 0 at index -1
        int maxLength = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1 to handle sum calculation
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println("Maximum length of subarray with equal 0s and 1s: " + findMaxLength(nums));
    }
}

