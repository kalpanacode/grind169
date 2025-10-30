// https://leetcode.com/problems/product-of-array-except-self/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // output[i] will be product of all elements to the left of i
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        // R will hold product of all elements to the right of i
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            // multiply output[i] by product of all elements to right
            output[i] = output[i] * R;
            R = R * nums[i];
        }

        return output;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();

        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);

        System.out.println(java.util.Arrays.toString(result)); // Expected: [24, 12, 8, 6]
    }
}
