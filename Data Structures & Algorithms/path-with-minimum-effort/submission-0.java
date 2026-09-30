class Solution {
    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(heights, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canReach(int[][] heights, int effort) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        boolean[][] vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == rows - 1 && c == cols - 1) {
                return true;
            }
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || vis[nr][nc]) {
                    continue;
                }

                
                int diff = Math.abs(heights[r][c] - heights[nr][nc]);

                if(diff <= effort){
                    vis[nr][nc] = true;
                    q.add(new int[] {nr,nc});
                }
            }
        }

        return false;
    }
}