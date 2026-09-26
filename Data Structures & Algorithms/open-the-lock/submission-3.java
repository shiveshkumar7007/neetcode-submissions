class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")) {
            return -1;
        }

        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        vis.add("0000");
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return moves;
                }
                for (int j = 0; j < 4; j++) {
                    char[] arr = cur.toCharArray();

                    // wheel forward
                    arr[j] = (char) ((arr[j] - '0' + 1) % 10 + '0');
                    String next = new String(arr);
                    if (!dead.contains(next) && !vis.contains(next)) {
                        q.offer(next);
                        vis.add(next);
                    }

                    arr = cur.toCharArray();
                    // wheel backward
                    arr[j] = (char) ((arr[j] - '0' + 9) % 10 + '0');
                    next = new String(arr);
                    if (!dead.contains(next) && !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
