class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] vis = new boolean[n+1];
            // if path from u to v already exist then the curr edges is of no use
            if(path(graph, u, v, vis)){
                return edge;
            }
            graph[u].add(v);
            graph[v].add(u);
        }
        return new int[0];       
    }

    public boolean path(List<Integer>[] graph, int src, int dst, boolean[] vis){
        if(src == dst){
            return true;
        }
        vis[src] = true;
        for(int nei: graph[src]){
            if(!vis[nei] && path(graph, nei, dst, vis)){
                return true;
            }
        }
        return false;
    }
}
