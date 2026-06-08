class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Find all rotten fruits and count fresh fruits
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        // No fresh fruit exists
        if (fresh == 0){
            return 0;
        }

        int minutes = 0;

        int[][] dir = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottenThisMinute = false;

            // Process one BFS level
            for (int k = 0; k < size; k++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Fresh neighbor found
                    if (nr >= 0 && nc >= 0 &&  nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        rottenThisMinute = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            // One minute passed if infection spread
            if (rottenThisMinute){
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}