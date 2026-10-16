class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (n == 1)
            return true;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new PriorityQueue<>();
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = cur + minJump; i <= Math.min(cur + maxJump, n - 1); i++) {
                if (i == n - 1 && arr[n - 1] == 0) {
                    return true;
                }
                if (arr[i] == 0 && vis[i] == false) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }

        return false;
    }
}