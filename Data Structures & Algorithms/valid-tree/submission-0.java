class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] vis = new boolean[n];
        dfs(graph, 0, vis);

        for(int i = 0; i<n; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }

    public void dfs(List<Integer>[] graph, int i, boolean[] vis){
        if(vis[i]){
            return;
        }
        vis[i] = true;
        for(int neigh: graph[i]){
            dfs(graph, neigh, vis);
        }
        
    }
}
