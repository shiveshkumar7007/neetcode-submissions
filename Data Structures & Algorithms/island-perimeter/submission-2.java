class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Find any land cell and start DFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    // Returns perimeter contributed by this island
    private int dfs(int[][] grid, int r, int c) {
        // Out of boundary contributes 1
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 1;

        // Water contributes 1
        if (grid[r][c] == 0)
            return 1;

        // Already visited contributes 0
        if (grid[r][c] == -1)
            return 0;

        // Mark as visited
        grid[r][c] = -1;

        int perimeter = 0;

        perimeter += dfs(grid, r + 1, c);
        perimeter += dfs(grid, r - 1, c);
        perimeter += dfs(grid, r, c + 1);
        perimeter += dfs(grid, r, c - 1);
        return perimeter;
    }
}