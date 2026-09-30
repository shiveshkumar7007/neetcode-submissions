class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int dist = 
                        Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new int[]{j, dist});
                graph[j].add(new int[]{i, dist});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        boolean[] vis = new boolean[n];
        pq.add(new int[]{0,0});
        int cost = 0;
        int edgeUsed = 0;

        while(!pq.isEmpty() && edgeUsed < n){
            int[] cur = pq.poll();
            int node = cur[0];
            int wt = cur[1];
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            edgeUsed++;
            cost += wt;
            for(int[] neigh: graph[node]){
                int next = neigh[0];
                int w = neigh[1];
                if(!vis[next]){
                    pq.add(new int[]{next, w});
                }
            }
        }

        return cost;
    }
}
