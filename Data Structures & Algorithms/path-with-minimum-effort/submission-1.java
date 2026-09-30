class Solution {
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // [effort, row, col]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int effort = cur[0];
            int r = cur[1];
            int c = cur[2];

            // We reached the destination
            if (r == rows - 1 && c == cols - 1) {
                return effort;
            }

            for (int[] dir : dirs) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                int diff = Math.abs(
                    heights[r][c] - heights[nr][nc]
                );

                // Path effort = maximum difference seen so far
                int newEffort = Math.max(effort, diff);

                if (newEffort < dist[nr][nc]) {

                    dist[nr][nc] = newEffort;

                    pq.offer(new int[]{
                        newEffort, nr, nc
                    });
                }
            }
        }

        return 0;
    }
}