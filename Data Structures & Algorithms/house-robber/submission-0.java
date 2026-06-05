class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.max(helper(0, dp, nums), helper(1, dp, nums));
    }

    public int helper(int i, int[] dp, int[] nums){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        dp[i] = nums[i] + Math.max(helper(i+2, dp, nums), helper(i+3, dp, nums));
        return dp[i];
    }
}
