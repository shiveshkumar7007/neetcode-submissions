class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n - k + 1];
        int i = 0;

        ArrayDeque<Integer> dq = new ArrayDeque<>(); // store indices

        for(int j = 0; j < n; j++){
            if(!dq.isEmpty() && dq.peekFirst() <= j-k){  // remove outranged number
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]){
                dq.pollLast();
            }
            dq.addLast(j);

            if(j >= k-1){
                res[i] = nums[dq.peekFirst()];
                i++;
            }
        }

        return res;
    }
}
