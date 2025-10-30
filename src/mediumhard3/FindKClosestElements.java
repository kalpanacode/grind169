// https://leetcode.com/problems/find-k-closest-elements/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;

        // Binary search to find the starting index of the closest subarray
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Compare distances of window edges to x
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;

        List<Integer> closest = findClosestElements(arr, k, x);
        System.out.println("K closest elements: " + closest);
        // Expected output: [1, 2, 3, 4]
    }
}

