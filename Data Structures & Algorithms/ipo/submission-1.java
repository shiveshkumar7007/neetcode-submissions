class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Store {capital required, profit}
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort by required capital
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        // Max heap based on profit
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;

        for (int project = 0; project < k; project++) {

            // Add every project we can currently afford
            while (i < n && projects[i][0] <= w) {
                pq.offer(projects[i][1]);
                i++;
            }

            // No project can currently be started
            if (pq.isEmpty()) {
                break;
            }

            // Take the project with maximum profit
            w += pq.poll();
        }

        return w;
    }
}