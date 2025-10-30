// https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Contains duplicate? " + solution.containsDuplicate(nums1));  // Output: true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Contains duplicate? " + solution.containsDuplicate(nums2));  // Output: false
    }
}

