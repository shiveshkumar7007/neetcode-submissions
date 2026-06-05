class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(helper(0, dp, cost), helper(1, dp, cost));
    }

    public int helper(int i, int[] dp, int[] cost){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        dp[i] = cost[i] + Math.min(helper(i+1, dp, cost), helper(i+2, dp, cost));
        return dp[i];
    }
}
