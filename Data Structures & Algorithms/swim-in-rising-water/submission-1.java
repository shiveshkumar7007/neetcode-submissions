class Solution {
    public int swimInWater(int[][] grid){
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[][] vis = new boolean[n][n];        
        int[][] dir = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        pq.add(new int[] {grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if(vis[r][c]){
                continue;
            }
            if(r == n-1 && c == n-1){
                return time;
            }
            vis[r][c] = true;
            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){
                    int newtime = Math.max(time, grid[nr][nc]);
                    pq.add(new int[] {newtime, nr, nc});
                }
            }
        }
        return -1;

    }
}