class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int p = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        res[p] = pq.peek();
        p++;

        for(int i = k; i < len; i++){
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            res[p] = pq.peek();
            p++;
        }

        return res;
    }
}
