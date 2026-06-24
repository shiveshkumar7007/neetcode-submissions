class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int curMax = 0;
        int maxSub = nums[0];

        int curMin = 0;
        int minSub = nums[0];

        for (int num : nums) {

            // Kadane for maximum subarray
            curMax = Math.max(num, curMax + num);
            maxSub = Math.max(maxSub, curMax);

            // Kadane for minimum subarray
            curMin = Math.min(num, curMin + num);
            minSub = Math.min(minSub, curMin);

            totalSum += num;
        }

        // all numbers negative
        if (maxSub < 0) {
            return maxSub;
        }

        return Math.max(maxSub, totalSum - minSub);
    }
}