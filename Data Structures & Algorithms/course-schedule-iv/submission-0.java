class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // a -> b means a is prerequisite of b
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }

        List<Boolean> ans = new ArrayList<>();

        // Process each query
        for (int[] q : queries) {

            boolean[] vis = new boolean[numCourses];

            ans.add(dfs(graph, vis, q[0], q[1]));
        }

        return ans;
    }

    // Returns true if target can be reached
    private boolean dfs(List<Integer>[] graph, boolean[] vis, int src, int target) {

        if (src == target){
            return true;
        }
        vis[src] = true;
        
        for (int next : graph[src]) {
            if (!vis[next]) {
                if (dfs(graph, vis, next, target))
                    return true;
            }
        }

        return false;
    }
}