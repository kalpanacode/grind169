// https://leetcode.com/problems/word-ladder/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                for (String nextWord : getNextWords(word, wordSet)) {
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }
            level++;
        }

        return 0; // No transformation sequence found
    }

    // Generate all words that differ by one letter from the given word and exist in wordSet
    private static List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;

                chars[i] = c;
                String newWord = new String(chars);

                if (wordSet.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
            chars[i] = original; // Restore original character
        }
        return nextWords;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + length);
        // Expected output: 5
    }
}

