// https://leetcode.com/problems/find-median-from-data-stream/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // lower half, max heap
    private PriorityQueue<Integer> minHeap; // upper half, min heap

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap for lower half
        minHeap = new PriorityQueue<>();                 // Min heap for upper half
    }

    public void addNum(int num) {
        // Add to maxHeap (lower half)
        maxHeap.offer(num);

        // Balance: move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Maintain size property: maxHeap can have 1 more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            // Even number of elements: average of tops of both heaps
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }


    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian()); // 1.5

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian()); // 2.0
    }
}
