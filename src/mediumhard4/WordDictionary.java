// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class WordDictionary {

	static class TrieNode {
		TrieNode[] children;
		boolean isWordEnd;

		public TrieNode() {
			children = new TrieNode[26];
			isWordEnd = false;
		}
	}

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the Trie
	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (node.children[index] == null)
				node.children[index] = new TrieNode();
			node = node.children[index];
		}
		node.isWordEnd = true;
	}

	// Searches a word that may contain '.'
	public boolean search(String word) {
		return dfsSearch(word, 0, root);
	}

	private boolean dfsSearch(String word, int index, TrieNode node) {
		if (node == null)
			return false;

		// Reached end of word
		if (index == word.length())
			return node.isWordEnd;

		char c = word.charAt(index);
		if (c == '.') {
			// Try all 26 possibilities
			for (TrieNode child : node.children) {
				if (child != null && dfsSearch(word, index + 1, child))
					return true;
			}
			return false;
		} else {
			return dfsSearch(word, index + 1, node.children[c - 'a']);
		}
	}

	// Example to run in Eclipse IDE
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");

		System.out.println(wordDictionary.search("pad")); // false
		System.out.println(wordDictionary.search("bad")); // true
		System.out.println(wordDictionary.search(".ad")); // true
		System.out.println(wordDictionary.search("b..")); // true
	}
}

