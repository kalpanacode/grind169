// https://leetcode.com/problems/find-the-duplicate-number/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];          // move one step
            fast = nums[nums[fast]];    // move two steps
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // Test example to run in Eclipse IDE
    public static void main(String[] args) {
        FindDuplicateNumber solution = new FindDuplicateNumber();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate: " + solution.findDuplicate(nums1));  // Expected: 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate: " + solution.findDuplicate(nums2));  // Expected: 3
    }
}
