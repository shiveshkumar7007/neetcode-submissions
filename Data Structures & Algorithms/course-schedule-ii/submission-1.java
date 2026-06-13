// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int n = numCourses;
//         int[] dependency = new int[n];
//         List<Integer>[] graph = new ArrayList[n];
//         for(int i = 0; i < n; i++){
//             graph[i] = new ArrayList<>();
//         }
//         for(int[] pre: prerequisites){
//             graph[pre[1]].add(pre[0]);
//             dependency[pre[0]]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i = 0; i < n; i++){
//             if(dependency[i] == 0){
//                 q.add(i);
//             }
//         }
//         int[] ans = new int[n];
//         int index = 0;
//         while(!q.isEmpty()){
//             int curr = q.poll();
//             ans[index++] = curr;

//             for(int next: graph[curr]){
//                 dependency[next]--;
//                 if(dependency[next] == 0){
//                     q.add(next);
//                 }
//             }
//         }
//         if(index != n){
//             return new int[0];
//         }
//         return ans;
//     }
// }

// USING TOPOLOGICAL SORT DFS TECHNIQUE

class Solution {
    Stack<Integer> st = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i]) {
                if(dfs(graph, vis, rec, i)) {
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while(!st.isEmpty()) {
            res[idx++] = st.pop();
        }

        return res;
    }

    public boolean dfs(List<Integer>[] graph, boolean[] vis, boolean[] rec, int node) {
        if(rec[node]) {
            return true; // cycle found
        }
        if(vis[node]) {
            return false;
        }
        vis[node] = true;
        rec[node] = true;

        for(int neigh : graph[node]) {
            if(dfs(graph, vis, rec, neigh)) {
                return true;
            }
        }
        rec[node] = false;
        st.push(node);
        return false;
    }
}