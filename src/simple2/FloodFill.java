// https://leetcode.com/problems/flood-fill/description/?envType=problem-list-v2&envId=rabvlt31
package simple2;

import java.util.Arrays;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int originalColor = image[sr][sc];
		if (originalColor != newColor) {
			dfs(image, sr, sc, originalColor, newColor);
		}
		return image;
	}

	private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
		if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
		if (image[r][c] != originalColor) return;

		image[r][c] = newColor;

		dfs(image, r + 1, c, originalColor, newColor);
		dfs(image, r - 1, c, originalColor, newColor);
		dfs(image, r, c + 1, originalColor, newColor);
		dfs(image, r, c - 1, originalColor, newColor);
	}

	public static void main(String[] args) {
		FloodFill solution = new FloodFill();

		int[][] image = {
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};

		int sr = 1;
		int sc = 1;
		int newColor = 2;

		System.out.println("Original image:");
		printImage(image);

		int[][] modifiedImage = solution.floodFill(image, sr, sc, newColor);

		System.out.println("Image after flood fill:");
		printImage(modifiedImage);
	}

	// Utility method to print the 2D image array
	public static void printImage(int[][] image) {
		for (int[] row : image) {
			System.out.println(Arrays.toString(row));
		}
	}
}