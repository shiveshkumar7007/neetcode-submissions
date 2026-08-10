class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (b-a));
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        res[j] = pq.peek();
        j++;
        for(int i = k; i < nums.length; i++){
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            res[j] = pq.peek();
            j++;
        }
        return res;
    }
}
