class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // Top neighbor
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter--;

                    // Bottom neighbor
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        perimeter--;

                    // Left neighbor
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter--;

                    // Right neighbor
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
                        perimeter--;
                }
            }
        }
        return perimeter;
    }
}