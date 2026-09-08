class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int count = 1;

        // beginWord should not be considered again.
        set.remove(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String cur = q.poll();

                if (cur.equals(endWord)) {
                    return count;
                }

                // Store the words that will be added to the queue.
                List<String> next = new ArrayList<>();

                for (String word : set) {
                    if (isOneDiff(cur, word)) {
                        q.add(word);
                        next.add(word);
                    }
                }

                // Remove them after finishing the iteration.
                for (String word : next) {
                    set.remove(word);
                }
            }

            count++;
        }

        return 0;
    }

    // Checks whether two words differ by exactly one character.
    public boolean isOneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}