// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/?envType=problem-list-v2&envId=rabvlt31
//  static class Element implements Comparable<Element> {
        // int val;      // value
        // int listIdx;  // index of the list
        // int elemIdx;
// in each loop  pick minheap, while moving forward calculate is max and update currMax

package mediumhard3;

import java.util.*;

public class SmallestRange {

    // Class to hold elements from the lists
    static class Element implements Comparable<Element> {
        int val;      // value
        int listIdx;  // index of the list
        int elemIdx;  // index in the list

        Element(int val, int listIdx, int elemIdx) {
            this.val = val;
            this.listIdx = listIdx;
            this.elemIdx = elemIdx;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int currentMax = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        // Initialize the minHeap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Element(val, i, 0));
            currentMax = Math.max(currentMax, val);
        }

        boolean done = false;
        while (!done && minHeap.size() == nums.size()) {
            Element minElem = minHeap.poll();

            // Update range if smaller
            if (currentMax - minElem.val < end - start || 
                (currentMax - minElem.val == end - start && minElem.val < start)) {
                start = minElem.val;
                end = currentMax;
            }

            // Move to next element in the same list
            if (minElem.elemIdx + 1 < nums.get(minElem.listIdx).size()) {
                int nextVal = nums.get(minElem.listIdx).get(minElem.elemIdx + 1);
                minHeap.offer(new Element(nextVal, minElem.listIdx, minElem.elemIdx + 1));
                currentMax = Math.max(currentMax, nextVal);
            } else {
                // If any list is exhausted, stop
                done = true;
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(
            Arrays.asList(4, 10, 15, 24, 26),
            Arrays.asList(0, 9, 12, 20),
            Arrays.asList(5, 18, 22, 30)
        );

        int[] range = smallestRange(nums);
        System.out.println("Smallest range: [" + range[0] + ", " + range[1] + "]");
        // Expected output: [20, 24]
    }
}
