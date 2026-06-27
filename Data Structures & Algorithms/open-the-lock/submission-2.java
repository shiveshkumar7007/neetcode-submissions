class Solution {
    public int openLock(String[] deadends, String target) {
        // Store all deadend states
        HashSet<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        // If starting state is blocked
        if (dead.contains("0000")){
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.offer("0000");
        vis.add("0000");
        
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // Process one BFS level
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                // Target found
                if (curr.equals(target))
                    return moves;

                // Try rotating each wheel
                for (int j = 0; j < 4; j++) {
                    char[] arr = curr.toCharArray();
                    // Rotate wheel forward
                    arr[j] = (char) ((arr[j] - '0' + 1) % 10 + '0');
                    String next = new String(arr);
                    if (!dead.contains(next) && !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }

                    // Restore original digit
                    arr = curr.toCharArray();

                    // Rotate wheel backward
                    arr[j] = (char) ((arr[j] - '0' + 9) % 10 + '0');
                    next = new String(arr);

                    if (!dead.contains(next) && !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }
                }
            }
            // One level completed
            moves++;
        }
        return -1;
    }
}