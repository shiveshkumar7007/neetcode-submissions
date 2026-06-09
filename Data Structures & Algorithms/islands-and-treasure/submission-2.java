class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length == 0){
            return;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j, 0);
                }                
            }
        }
                
    }

    public void dfs(int[][] grid, int r, int c, int dist){
        // check for bound
        // wall(-1)
        //assign new dist if lower than current else return
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 || grid[r][c] < dist){
            return;
        }
        grid[r][c] = dist;
        dfs(grid, r, c+1, dist+1);
        dfs(grid, r, c-1, dist+1);
        dfs(grid, r+1, c, dist+1);
        dfs(grid, r-1, c, dist+1);
    }
}