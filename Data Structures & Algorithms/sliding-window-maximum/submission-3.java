class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] res = new int[n - k + 1];
        int j = 0;

        // Store indices, not values.
        // Values corresponding to these indices
        // are maintained in decreasing order.
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices that are outside
            // the current sliding window.
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back.
            // They can never become the maximum
            // while nums[i] is present in the window.
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index.
            dq.offerLast(i);

            // Once we have a complete window,
            // the front contains the index of the maximum.
            if (i >= k - 1) {
                res[j] = nums[dq.peekFirst()];
                j++;
            }
        }

        return res;
    }
}

