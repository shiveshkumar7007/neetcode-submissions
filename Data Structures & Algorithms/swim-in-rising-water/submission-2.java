class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        boolean[][] vis = new boolean[n][n];
        

        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];
            if(vis[r][c]){
                continue;
            }
            if(r == n-1 && c == n-1){
                return time;
            }
            vis[r][c] = true;
            for(int[] d: dir){
                int nr = d[0] + r;
                int nc = d[1] + c;
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){
                    int newtime = Math.max(time, grid[nr][nc]);
                    pq.add(new int[]{newtime, nr, nc});
                }
            }
        }

        return -1;
    }
}
