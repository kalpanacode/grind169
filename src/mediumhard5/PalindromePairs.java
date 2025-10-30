// https://leetcode.com/problems/palindrome-pairs/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard5;

import java.util.*;

public class PalindromePairs {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1; // index of word ending here, -1 if none
        List<Integer> palindromeSuffixIndices = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        // Build a Trie of reversed words
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        // Search pairs for each word
        for (int i = 0; i < words.length; i++) {
            search(words, i, result);
        }

        return result;
    }

    private void insert(String word, int index) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            // If suffix word[0..i] is palindrome, record index here
            if (isPalindrome(word, 0, i)) {
                node.palindromeSuffixIndices.add(index);
            }

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.index = index;
        node.palindromeSuffixIndices.add(index); // whole word is palindrome suffix for itself
    }

    private void search(String[] words, int i, List<List<Integer>> result) {
        TrieNode node = root;
        String word = words[i];

        for (int j = 0; j < word.length(); j++) {
            // If this node is the end of a word and the remaining substring is palindrome, record pair
            if (node.index >= 0 && node.index != i && isPalindrome(word, j, word.length() - 1)) {
                result.add(Arrays.asList(i, node.index));
            }

            node = node.children[word.charAt(j) - 'a'];
            if (node == null) return;
        }

        // Check the palindromeSuffixIndices from this node
        for (int j : node.palindromeSuffixIndices) {
            if (i != j) {
                result.add(Arrays.asList(i, j));
            }
        }
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();

        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> pairs = solution.palindromePairs(words);

        System.out.println("Palindrome pairs: " + pairs);
        // Expected output: [[0,1],[1,0],[3,2],[2,4]]
    }
}
