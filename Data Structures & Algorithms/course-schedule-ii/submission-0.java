class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] dependency = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] pre: prerequisites){
            graph[pre[1]].add(pre[0]);
            dependency[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(dependency[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[n];
        int index = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[index++] = curr;

            for(int next: graph[curr]){
                dependency[next]--;
                if(dependency[next] == 0){
                    q.add(next);
                }
            }
        }
        if(index != n){
            return new int[0];
        }
        return ans;
    }
}
