// https://leetcode.com/problems/number-of-islands/description/
package servicenow;

public class NumberOfIslands {

	    public int numIslands(char[][] grid) {
	        if (grid == null || grid.length == 0) {
	            return 0;
	        }
	        int nr = grid.length;
	        int nc = grid[0].length;
	        int numIsland = 0;
	        for (int r = 0; r < nr; ++r) {
	            for (int c = 0; c < nc; ++c) {
	                if (grid[r][c] == '1') {
	                    ++numIsland;
	                    dfs(grid, r, c);
	                }
	            }
	        }
	        return numIsland;
	    }

	    void dfs(char[][] grid, int r, int c) {
	        int nr = grid.length;
	        int nc = grid[0].length;
	        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') return;

	        grid[r][c] = '0';
	        dfs(grid, r - 1, c);  // up
	        dfs(grid, r + 1, c);  // down
	        dfs(grid, r, c - 1);  // left
	        dfs(grid, r, c + 1);  // right
	    }
	}

