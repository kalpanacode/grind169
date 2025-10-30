// https://leetcode.com/problems/random-pick-with-weight/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.Random;

public class RandomPickWithWeight {
    private int[] prefixSums;
    private int totalSum;
    private Random rand;

    public RandomPickWithWeight(int[] w) {
        prefixSums = new int[w.length];
        rand = new Random();

        int prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        totalSum = prefixSum;
    }

    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1; // Random integer in [1, totalSum]
        // Binary search to find the index where target would fit in prefixSums
        int low = 0, high = prefixSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        int[] w = {1, 3};
        RandomPickWithWeight solution = new RandomPickWithWeight(w);

        // Multiple calls to demonstrate weighted randomness
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked index: " + solution.pickIndex());
        }
    }
}
