class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[] {v, w});           
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.add(new int[] {k,0});
        dist[k] = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if(time > dist[node]){
                continue;
            }

            for(int neigh[]: graph[node]){
                int next = neigh[0];
                int wt = neigh[1];

                if(dist[next] > time + wt){
                    dist[next] = time + wt;
                    pq.add(new int[] {next, dist[next]});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;

    }
}
