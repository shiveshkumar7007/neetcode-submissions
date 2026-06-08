class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freq) {
            if(f > 0) {
                maxHeap.add(f);
            }
        }

        // Stores {remainingCount, timeWhenAvailableAgain}
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;

                if(count > 0) {
                    cooldown.add(new int[]{count, time + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.add(cooldown.poll()[0]);
            }
        }
        return time;
    }
}