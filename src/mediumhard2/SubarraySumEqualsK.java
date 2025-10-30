// https://leetcode.com/problems/subarray-sum-equals-k/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard2;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // To handle subarrays that start from index 0
        
        int count = 0;
        int prefixSum = 0;
        
        for (int num : nums) {
            prefixSum += num;
            // Check if there is a prefix sum that equals prefixSum - k
            count += prefixSumCount.getOrDefault(prefixSum - k, 0);
            // Record the current prefix sum count
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Number of subarrays for nums1: " + subarraySum(nums1, k1));  // Expected: 2
        
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Number of subarrays for nums2: " + subarraySum(nums2, k2));  // Expected: 2
    }
}
