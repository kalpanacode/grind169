// https://leetcode.com/problems/binary-search/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;  // target found
            } else if (nums[mid] < target) {
                left = mid + 1;  // search right half
            } else {
                right = mid - 1; // search left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int index = solution.search(nums, target);
        System.out.println("Index of target: " + index);  // Output: 4
    }
}

