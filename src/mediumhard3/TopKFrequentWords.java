// https://leetcode.com/problems/top-k-frequent-words/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;
import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        // Count the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Create a comparator for the PriorityQueue
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                int freqCompare = freqMap.get(b) - freqMap.get(a);
                if (freqCompare == 0) {
                    // If same frequency, sort lexicographically
                    return a.compareTo(b);
                }
                return freqCompare;
            }
        );

        // Add all words to the priority queue
        pq.addAll(freqMap.keySet());

        // Extract top k words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        List<String> topWords = topKFrequent(words, k);
        System.out.println("Top " + k + " frequent words: " + topWords);
        // Expected output: ["i", "love"]
    }
}
