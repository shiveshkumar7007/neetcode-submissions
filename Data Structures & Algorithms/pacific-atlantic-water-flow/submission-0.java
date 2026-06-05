class Solution {
    int row;
    int col;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];

        // left column
        for(int r = 0; r < row; r++){
            dfs(heights, r, 0, pacific, heights[r][0]);
        }

        //upper row
        for(int c = 0; c < col; c++){
            dfs(heights, 0, c, pacific, heights[0][c]);
        }

        // right column
        for(int r = 0; r < row; r++){
            dfs(heights, r, col-1, atlantic, heights[r][col-1]);
        }

        // lower row
        for(int c = 0; c < col; c++){
            dfs(heights, row-1, c, atlantic, heights[row-1][c]);
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(atlantic[r][c] && pacific[r][c]){
                    ans.add(Arrays.asList(r,c));
                }
            }
        }

        return ans;

    }


    public void dfs(int heights[][], int r, int c, boolean ocean[][], int prevHeight){
        if(r < 0 || c < 0 || r >= row || c >= col){
            return;
        }
        if(ocean[r][c]){
            return;
        }
        if(heights[r][c] < prevHeight){
            return;
        }

        ocean[r][c] = true;

        //exploring 4 direction
        dfs(heights, r, c-1, ocean, heights[r][c]);
        dfs(heights, r, c+1, ocean, heights[r][c]);
        dfs(heights, r-1, c, ocean, heights[r][c]);
        dfs(heights, r+1, c, ocean, heights[r][c]);





    }
}