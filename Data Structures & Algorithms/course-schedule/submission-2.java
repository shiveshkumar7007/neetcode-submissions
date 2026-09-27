class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int pre[]: prerequisites){
            graph[pre[1]].add(pre[0]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(dfs(graph, i, vis, rec)){
                return false; // cycle found this means two subject dependent on each other
            }
        }
        return true;
    }

    // after this see leetcode 210
    // course scheduler 2

    // cycle detection in directed graph
    public boolean dfs(List<Integer>[] graph, int i, boolean[] vis, boolean[] rec){
        if(rec[i] == true){
            return true; // cycle detected
        }
        if(vis[i] == true){
            return false; // already checked for this node
        }

        vis[i] = true;
        rec[i] = true;

        for(int course: graph[i]){
            if(dfs(graph, course, vis, rec)){
                return true;
            }
            
        }

        rec[i] = false;
        return false;
    }
}
