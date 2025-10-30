
// https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=rabvlt31
package simple2;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
     // Verification step:
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element
        }

        // return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        int[] nums1 = {3, 2, 3};
        System.out.println("Majority element: " + solution.majorityElement(nums1));  // Output: 3

        int[] nums2 = {2, 2, 2,5,6,7,3,3,3, 1, 2};
        System.out.println("Majority element: " + solution.majorityElement(nums2));  // Output: 2
    }
}
