public class RangeSumQueryMutable {
    private int[] tree;
    private int n;
    
    public RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        update(index + 1, val - query(index + 1) + query(index));
    }
    
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
    
    private void update(int index, int delta) {
        while (index <= n) {
            tree[index] += delta;
            index += index & -index;
        }
    }
    
    private int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutable numArray = new RangeSumQueryMutable(nums);
        
        System.out.println(numArray.sumRange(0, 2));  // Output: 9
        
        numArray.update(1, 2);
        
        System.out.println(numArray.sumRange(0, 2));  // Output: 8
    }
}

