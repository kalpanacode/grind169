import java.util.*;

public class CountSmallerNumbers {
    static class BinaryIndexedTree {
        private int[] tree;
        private int n;
        
        public BinaryIndexedTree(int size) {
            n = size + 1;
            tree = new int[n + 1];
        }
        
        public void update(int index, int delta) {
            while (index <= n) {
                tree[index] += delta;
                index += index & -index;
            }
        }
        
        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
    
    public int[] countSmaller(int[] nums) {
        if (nums.length == 0) return new int[0];
        
        // Coordinate compression: map values to 1-based ranks
        Integer[] unique = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            unique[i] = nums[i];
        }
        Arrays.sort(unique);
        
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int val : unique) {
            if (!rank.containsKey(val)) {
                rank.put(val, r++);
            }
        }
        
        // BIT for frequency counting
        BinaryIndexedTree bit = new BinaryIndexedTree(unique.length);
        int[] result = new int[nums.length];
        
        // Process from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = rank.get(nums[i]);
            result[i] = bit.query(idx - 1);  // Count smaller to the right (already inserted)
            bit.update(idx, 1);  // Insert current
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        CountSmallerNumbers solution = new CountSmallerNumbers();
        
        // Test case 1
        int[] nums1 = {5, 2, 6, 1};
        System.out.println(Arrays.toString(solution.countSmaller(nums1)));  // [2,1,1,0]
        
        // Test case 2
        int[] nums2 = {-1};
        System.out.println(Arrays.toString(solution.countSmaller(nums2)));  // [0]
        
        // Test case 3
        int[] nums3 = {-1, -1};
        System.out.println(Arrays.toString(solution.countSmaller(nums3)));  // [0,0]
    }
}

