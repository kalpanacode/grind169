// https://leetcode.com/problems/word-search-ii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;


public class WordSearchII {
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		String word = null; // stores complete word when end is reached
	}

	private char[][] board;
	private List<String> result;

	public List<String> findWords(char[][] board, String[] words) {
		this.board = board;
		this.result = new ArrayList<>();

		// Step 1: Build Trie from word list
		TrieNode root = buildTrie(words);

		// Step 2: Traverse the board for words starting from any cell
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (root.children.containsKey(board[row][col])) {
					backtrack(row, col, root);
				}
			}
		}
		return result;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				node = node.children.computeIfAbsent(ch, k -> new TrieNode());
			}
			node.word = word; // mark complete word at last node
		}
		return root;
	}

	private void backtrack(int row, int col, TrieNode parent) {
		char letter = board[row][col];
		TrieNode currNode = parent.children.get(letter);

		// Step 3: Found one word in Trie
		if (currNode.word != null) {
			result.add(currNode.word);
			currNode.word = null; // avoid duplicate entries
		}

		// Mark cell as visited
		board[row][col] = '#';

		// Explore neighbors (up, right, down, left)
		int[] rowOffset = {-1, 0, 1, 0};
		int[] colOffset = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int newRow = row + rowOffset[i];
			int newCol = col + colOffset[i];
			if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
				continue;
			if (currNode.children.containsKey(board[newRow][newCol])) {
				backtrack(newRow, newCol, currNode);
			}
		}

		// Restore cell
		board[row][col] = letter;

		// Step 4: Optimization — remove leaf nodes from Trie
		if (currNode.children.isEmpty()) {
			parent.children.remove(letter);
		}
	}

	// Run on Eclipse IDE
	public static void main(String[] args) {
		WordSearchII ws = new WordSearchII();

		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};

		List<String> foundWords = ws.findWords(board, words);
		System.out.println("Found Words: " + foundWords);
	}
}

