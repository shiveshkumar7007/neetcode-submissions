class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        // if its end then add 1
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }
        // if its water then add 1
        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] == -1) {
            return 0;
        }

        grid[r][c] = -1; // visited

        int peri = 0;
        peri += dfs(grid, r + 1, c);
        peri += dfs(grid, r - 1, c);
        peri += dfs(grid, r, c + 1);
        peri += dfs(grid, r, c - 1);

        return peri;
    }
}