class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for(int[] pre: prerequisites){
            graph[pre[0]].add(pre[1]);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] q: queries){
            int src = q[0];
            int dst = q[1];
            boolean[] vis = new boolean[numCourses];
            ans.add(dfs(graph, vis, src, dst));            
        }
        return ans;
    }

    public boolean dfs(List<Integer>[] graph, boolean[] vis, int src, int dst){
        if(src == dst){
            return true;
        }
        vis[src] = true;
        for(int next: graph[src]){
            if(!vis[next]){
                if(dfs(graph, vis, next, dst)){
                    return true;
                }
            }
        }

        return false;
    }
}