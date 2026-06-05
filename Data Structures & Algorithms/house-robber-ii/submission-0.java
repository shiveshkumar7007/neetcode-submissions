class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int case1 = helper(0, n - 2, dp1, nums);

        int case2 = helper(1, n - 1, dp2, nums);

        return Math.max(case1, case2);
    }

    public int helper(int i, int j, int[] dp, int[] nums) {

        if (i > j) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.max(nums[i] + helper(i + 2, j, dp, nums), helper(i + 1, j, dp, nums));
        return dp[i];
    }
}