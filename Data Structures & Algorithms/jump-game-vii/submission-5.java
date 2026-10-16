class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (n == 1) return true;
        if (s.charAt(n - 1) == '1') return false;
        

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int farthest = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int start = Math.max(cur + minJump, farthest + 1);
            int end = Math.min(cur + maxJump, n - 1);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    if (i == n - 1) return true;
                    q.add(i);
                }
            }

            farthest = Math.max(farthest, end);
        }

        return false;
    }
}