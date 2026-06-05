class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i <n; i++){
            if(!vis[i]){
                count++;
                dfs(graph, i, vis);
            }
        }
        return count;
    }

    public void dfs(List<Integer> graph[], int i, boolean vis[]){
        if(vis[i]){
            return;
        }
        vis[i] = true;
        for(int neigh: graph[i]){
            dfs(graph, neigh, vis);
        }        
    }
}
