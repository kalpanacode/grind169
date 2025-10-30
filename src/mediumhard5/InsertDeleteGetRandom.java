// https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class InsertDeleteGetRandom {
    private List<Integer> nums;
    private Map<Integer, Integer> valToIndex;
    private Random rand;

    public InsertDeleteGetRandom() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastElement = nums.get(nums.size() - 1);

        // Move the last element to the place of the element to delete
        nums.set(index, lastElement);
        valToIndex.put(lastElement, index);

        // Remove last
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();

        System.out.println(obj.insert(1));  // true
        System.out.println(obj.remove(2));  // false
        System.out.println(obj.insert(2));  // true
        System.out.println(obj.getRandom()); // 1 or 2
        System.out.println(obj.remove(1));  // true
        System.out.println(obj.insert(2));  // false
        System.out.println(obj.getRandom()); // 2
    }
}
